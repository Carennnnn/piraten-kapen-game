package project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Game implements Runnable{
    private Socket socket;
    public ObjectInputStream inputStream;
    public ObjectOutputStream outputStream;
    private Boolean isRunning = true;
    public int playerId;
    public Game(Socket s, int id) {
        socket = s;
        playerId = id;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Server connection failed");
        }
    }

    public void run() {
        try {
            while (isRunning) {
            }

        } catch (Exception ex) {
            {
                System.out.println("Run failed");
                ex.printStackTrace();
            }
        }
    }

    // send players to player server
    public void sendPlayersToServer(PlayerServer[] playerServers) {
        try {
            for (int i = 0; i < Constants.PLAYER_NUM; i++) {
                outputStream.writeObject(playerServers[i]);
                outputStream.flush();
            }
        } catch (IOException e) {
            System.out.println("Players send to server failed");
            e.printStackTrace();
        }
    }

    // send current round number to player server
    public void sendRoundNum(int n) {
        try {
            outputStream.writeInt(n);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send round number to server failed");
            e.printStackTrace();
        }
    }

    // send all player scores to player server
    public void sendPlayerScores(PlayerServer[] playerServers) {
        try {
            for (int i = 0; i < playerServers.length; i++) {
                outputStream.writeInt(playerServers[i].getPlayerScore());
            }
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send player scores to server failed");
            e.printStackTrace();
        }
    }

    // send current player id to player server
    public void sendPlayerId(int id) {
        try {
            outputStream.writeInt(id);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send player id to server failed");
            e.printStackTrace();
        }
    }

    // send fortune card to player server
    public void sendFortuneCard(String card) {
        try {
            outputStream.writeUTF(card);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send fortune card to server failed");
            e.printStackTrace();
        }
    }

    // send player's previous score to game server
    // this is used to calculate the deducted points and report to player
    public void sendPreviousScore(int previousScore) {
        try {
            outputStream.writeInt(previousScore);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send previous score to server failed");
            e.printStackTrace();
        }
    }

    // Send winner to player server
    public void sendWinner(PlayerServer winner) {
        try {
            outputStream.writeObject(winner);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Send winner to server failed");
            e.printStackTrace();
        }
    }

    // receive player score from player server
    public int receivePlayerScore() {
        try {
            int score = inputStream.readInt();
            return score;
        } catch (IOException e) {
            System.out.println("Player score not received");
            e.printStackTrace();
        }
        return 0;
    }

    // receive deducted points from player server
    public int receiveDeductedPoints() {
        try {
            int deductedPoints = inputStream.readInt();
            return deductedPoints;
        } catch (IOException e) {
            System.out.println("Deducted points not received");
            e.printStackTrace();
        }
        return 0;
    }

}
