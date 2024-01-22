package project;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer implements Serializable, Runnable{
    private static final long serialVersionUID = 1L;
    private int numOfPlayers;
    private int numOfTurns;
    private int currentPlayerId = 0;
    private int deductedPoints = 0;
    private int[] previousScore = {0, 0, 0};
    private int remainingRounds = 3;
    private int currentCardIndex = 34;
    public boolean isAcceptingPlayers;
    private String[] deckOfCards;
    private String currentPlayerName = "";
    PlayerServer[] playerServers = new PlayerServer[Constants.PLAYER_NUM];
    Game[] gameServer = new Game[Constants.PLAYER_NUM];
    ServerSocket serverSocket;
    Boolean isRunning = true;

    Card card = new Card();


    public static void main(String[] args) throws Exception {
        GameServer gs = new GameServer();
        gs.startConnections();
        gs.gameLooping();
    }

    @Override
    public void run() {
        try {
            startConnections();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (isRunning) {

        }
    }

    public GameServer() {
        numOfPlayers = 0;
        numOfTurns = 0;
        System.out.println("Game started");
        for (int i = 0; i < playerServers.length; i++) {
            playerServers[i] = new PlayerServer(" ");
        }
        try {
            serverSocket = new ServerSocket(Constants.GAME_SERVER_PORT_NUMBER);
        } catch (IOException e) {
            System.out.println("Server failed to start");
        }
    }

    // Network code for three players to join the game
    synchronized public void startConnections() throws ClassNotFoundException {
        try {
            System.out.println("Waiting for players to join");
            while (numOfPlayers < Constants.PLAYER_NUM) {
                isAcceptingPlayers = true;
                Socket so = serverSocket.accept();
                numOfPlayers += 1;
                Game g = new Game(so, numOfPlayers);
                // send player id
                g.outputStream.writeInt(g.playerId);
                g.outputStream.flush();
                // get player name
                PlayerServer p = (PlayerServer) g.inputStream.readObject();
                System.out.println("Player " + p.name + " with id " + g.playerId + " has joined");
                playerServers[g.playerId - 1] = p;
                gameServer[numOfPlayers - 1] = g;
            }
            System.out.println("Three players have joined the game");
            // start 3 thread
            for (int i = 0; i < numOfPlayers; i++) {
                Thread t = new Thread(gameServer[i]);
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Player connection failed");
            e.printStackTrace();
        }
        isAcceptingPlayers = false;
    }

    // Game loop
    synchronized public void gameLooping() {
        boolean isGamerRunning = true;
        boolean isLastTwoRounds = false;
        for (int i = 0; i < Constants.PLAYER_NUM; i++) {
            gameServer[i].sendPlayersToServer(playerServers);
        }
        deckOfCards = card.getDeckOfCards();
        while (isGamerRunning) {
            numOfTurns++;
            System.out.println("********************* Round " + numOfTurns + " *********************");
            currentPlayerName = playerServers[currentPlayerId].name;
            System.out.println("Player " + currentPlayerName + " has started his/her round");
            // each time draw fortune card from the back of the deck
            String fortuneCard = card.drawFortuneCard(deckOfCards, currentCardIndex);
            currentCardIndex--;
            // if deck is empty, reshuffle the fortune cards
            if (currentCardIndex == -1) {
                deckOfCards = card.getDeckOfCards();
                currentCardIndex = 34;
            }
            // send to player server
            gameServer[currentPlayerId].sendRoundNum(numOfTurns);
            gameServer[currentPlayerId].sendPlayerScores(playerServers);
            gameServer[currentPlayerId].sendPlayerId(currentPlayerId);
            gameServer[currentPlayerId].sendPreviousScore(previousScore[currentPlayerId]);
            gameServer[currentPlayerId].sendFortuneCard(fortuneCard);

            // receive from player server
            int playerScore = gameServer[currentPlayerId].receivePlayerScore();
            deductedPoints = gameServer[currentPlayerId].receiveDeductedPoints();
            playerServers[currentPlayerId].setPlayerScore(playerScore);
            previousScore[currentPlayerId] = playerScore;
            System.out.println("Player " + currentPlayerName + " ends his/her round and got score " + playerScore);
            // if deducted points are greater than 0, than deduct the points from all other players
            if (deductedPoints > 0) {
                for (int i = 0; i < playerServers.length; i++) {
                    if (i != currentPlayerId) {
                        int newScore = playerServers[i].getPlayerScore() - deductedPoints;
                        // player cannot have negative scores
                        if (newScore < 0) {
                            newScore = 0;
                        }
                        playerServers[i].setPlayerScore(newScore);
                        System.out.println("Player " + playerServers[i].name + " suffered a deduction of " + deductedPoints + " and got score " + newScore);
                    }
                }
            }
            currentPlayerId++;
            if (currentPlayerId == Constants.PLAYER_NUM) {
                currentPlayerId = 0;
            }
            if (playerScore >= 3000) {
                isLastTwoRounds = true;
            }
            if (isLastTwoRounds) {
                remainingRounds--;
            }
            if (remainingRounds == 0) {
                for (int i = 0; i < gameServer.length; i++) {
                    gameServer[i].sendRoundNum(-1);
                }
                PlayerServer winner = getWinner(playerServers);
                System.out.println("The winner is " + winner.name);
                for (int i = 0; i < playerServers.length; i++) {
                    gameServer[i].sendWinner(winner);
                }
                System.out.println("Game over");
                isGamerRunning = false;
            }
        }
    }

    // Get the winner of the game
    public PlayerServer getWinner(PlayerServer[] playerServers) {
        PlayerServer winner = playerServers[0];
        if (playerServers[0].getPlayerScore() < playerServers[1].getPlayerScore()) {
            winner = playerServers[1];
        }
        if (winner.getPlayerScore() < playerServers[2].getPlayerScore()) {
            winner = playerServers[2];
        }
        return winner;
    }
}
