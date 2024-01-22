package project;

import java.io.Serializable;
import java.util.Scanner;

public class PlayerServer implements Serializable {
    private static final long serialVersionUID = 1L;
    PlayerServer[] playerServers = new PlayerServer[Constants.PLAYER_NUM];
    Player player;
    Score score = new Score();
    private int currentPlayerId;
    private int playerScore;
    int playerId;
    public String name;
    Card card = new Card();
    Dice dice = new Dice();

    public PlayerServer(String n) {
        name = n;
    }

    // get player
    public PlayerServer getPlayer() {
        return this;
    }

    // get player's score
    public int getPlayerScore() {
        return playerScore;
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.next();
        PlayerServer p = new PlayerServer(name);
        p.setPlayers();
        p.connectToPlayer();
        p.startGame();
        p.reportWinner();
        input.close();
    }

    public int[] convertUserInput(String input) {
        int[] inValid = new int[1];
        inValid[0] = -1;
        try {
            String[] userInput = input.replaceAll("\\s", "").split(",");
            int[] reRollPosition = new int[userInput.length];
            for (int i = 0; i < userInput.length; i++) {
                reRollPosition[i] = Integer.parseInt(userInput[i]) - 1;
            }
            return reRollPosition;
        } catch (NumberFormatException e) {
            System.out.println("You must enter integers between 1 and 8");
        }
        return inValid;
    }

    // initialize three players
    public void setPlayers() {
        for (int i = 0; i < Constants.PLAYER_NUM; i++) {
            playerServers[i] = new PlayerServer(" ");
        }
    }

    // set player id
    public void setPlayerId(int id) {
        this.playerId = id;
    }

    // set player score
    public void setPlayerScore(int score) {
        this.playerScore = score;
    }

    // connect to player
    public void connectToPlayer() {
        player = new Player(getPlayer());
    }

    // Get player's action choice
    public int getAction(String fortuneCard) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select an action: ");
        System.out.println("(1) Choose dice to roll again");
        System.out.println("(2) End this round");
        if (fortuneCard.equals(Constants.CHEST)) {
            System.out.println("(3) Put dice on the Treasure Chest card");
            System.out.println("(4) Take out dice from the Treasure Chest card");
        }
        int choice = input.nextInt();
        return choice;
    }

    // play island of skull
    public int playSkullIsland(String[] currentDice, String fortuneCard) {
        Scanner input = new Scanner(System.in);
        int deductedPoints = 0;
        boolean endThisRound = false;
        while (!endThisRound) {
            int actionNumber = getAction(fortuneCard);
            if (actionNumber == 1) {
                boolean isInputInvalid = true;
                while (isInputInvalid) {
                    System.out.println("Select dice position to roll again(1,2,3...)");
                    System.out.println("You must gain at least one skull in order to continue");
                    String userInput = input.next();
                    int[] reRollPosition = convertUserInput(userInput);
                    if (reRollPosition[0] != -1) {
                        isInputInvalid = dice.verifyReRollInput(reRollPosition, currentDice, fortuneCard, 0);
                        if (!isInputInvalid) {
                            currentDice = dice.reRollDice(currentDice, reRollPosition);
                            boolean canContinue = dice.atLeastOneSkull(currentDice, reRollPosition);
                            if (!canContinue) {
                                System.out.println("You ended your turn");
                                System.out.println("You got 0 in this round");
                                System.out.println("You deducted " + deductedPoints + " from all your opponents");
                                endThisRound = true;
                            }
                            dice.printDice(currentDice);
                        }
                    }
                }
            } else if (actionNumber == 2) {
                deductedPoints = score.calculateDeductedPoints(fortuneCard, currentDice);
                System.out.println("You ended your turn");
                System.out.println("You got 0 in this round");
                System.out.println("You deducted " + deductedPoints + " from all your opponents");
                endThisRound = true;
            }
        }
        return deductedPoints;
    }

    // play game for a round
    public int playGame(String[] currentDice, String fortuneCard) {
        Scanner input = new Scanner(System.in);
        int roundScore = 0;
        boolean endThisRound = false;
        int numReRollSkull = 0;
        String[] protectedDice = new String[0];
        if (fortuneCard.equals(Constants.SORCERESS)) {
            numReRollSkull = 1;
        }
        while (!endThisRound) {
            int actionNumber = getAction(fortuneCard);
            if (actionNumber == 1) {
                boolean isInputInvalid = true;
                while (isInputInvalid) {
                    System.out.println("Select dice position to roll again(1,2,3...)");
                    String userInput = input.next();
                    int[] reRollPosition = convertUserInput(userInput);
                    if (reRollPosition[0] != -1) {
                        isInputInvalid = dice.verifyReRollInput(reRollPosition, currentDice, fortuneCard, numReRollSkull);
                        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
                            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition, currentDice, numReRollSkull);
                        }
                    }
                    if (!isInputInvalid) {
                        currentDice = dice.reRollDice(currentDice, reRollPosition);
                        card.printCard(fortuneCard);
                        dice.printDice(currentDice);
                        if (fortuneCard.equals(Constants.CHEST)) {
                            dice.printProtectedDice(protectedDice);
                        }
                        boolean isDied = score.isDisqualified(currentDice, fortuneCard, false);
                        if (isDied) {
                            reportDeath();
                            roundScore = endRound(currentDice, protectedDice, fortuneCard, false);
                            isInputInvalid = false;
                            endThisRound = true;
                        }
                    }
                }
            } else if (actionNumber == 2) {
                System.out.println("You ended your turn");
                roundScore = endRound(currentDice, protectedDice, fortuneCard, false);
                endThisRound = true;
            } else if (actionNumber == 3 && fortuneCard.equals(Constants.CHEST)) {
                boolean isInputInvalid = true;
                while (isInputInvalid) {
                    System.out.println("Select dice position to put on the Treasure Chest card(1,2,3...)");
                    String userInput = input.next();
                    int[] putPosition = convertUserInput(userInput);
                    if (putPosition[0] != -1) {
                        isInputInvalid = dice.verifyDicePosition(putPosition, currentDice, true);
                    }
                    if (!isInputInvalid) {
                        protectedDice = dice.putDice(currentDice, putPosition, protectedDice);
                        currentDice = dice.takeDice(currentDice, putPosition);
                        dice.printDice(currentDice);
                        dice.printProtectedDice(protectedDice);
                        card.printCard(fortuneCard);
                    }
                }
            } else if (actionNumber == 4 && fortuneCard.equals(Constants.CHEST)) {
                boolean isInputInvalid = true;
                while (isInputInvalid) {
                    System.out.println("Select dice position to take out from the Treasure Chest card(1,2,3...)");
                    String userInput = input.next();
                    int[] takePosition = convertUserInput(userInput);
                    if (takePosition[0] != -1) {
                        isInputInvalid = dice.verifyDicePosition(takePosition, protectedDice, false);
                    }
                    if (!isInputInvalid) {
                        currentDice = dice.putDice(protectedDice, takePosition, currentDice);
                        protectedDice = dice.takeDice(protectedDice, takePosition);
                        dice.printDice(currentDice);
                        dice.printProtectedDice(protectedDice);
                    }
                }
            } else {
                System.out.println("Please select valid option");
            }
        }
        return roundScore;
    }

    // start the game
    public void startGame() {
        playerServers = player.receivePlayerServers();
        boolean isGameRunning = true;
        while (isGameRunning) {
            int currentRoundNo = player.receiveCurrentRoundNo();
            // if the last round, end the game
            if (currentRoundNo == -1) {
                break;
            }
            int deductedPointsFromOpponents = 0;
            int[] playerScores = player.receivePlayerScores();
            currentPlayerId = player.receiveCurrentPlayerId();
            int previousScore = player.receivePreviousScore();
            String newCard = player.receiveFortuneCard();
            // receive player scores from game server and set player scores
            for (int i = 0; i < playerScores.length; i++) {
                playerServers[i].setPlayerScore(playerScores[i]);
            }
            int playerScore = playerServers[currentPlayerId].getPlayerScore();
            int deductedPoints = previousScore - playerScore;

            System.out.println("Your turn has started");
            System.out.println("*************** Round "+ currentRoundNo + " ***************");
            if (deductedPoints > 0) {
                System.out.println("You suffered a deduction of " + deductedPoints);
            }
            printAllPlayerScores(playerServers);
            String[] newDice = dice.rollAllDice();
            card.printCard(newCard);
            dice.printDice(newDice);
            boolean isInIslandOfSkulls = score.isInIslandOfSkulls(newDice, newCard);
            boolean isDied = score.isDisqualified(newDice, newCard, true);
            int roundScore = 0;
            if (isDied) {
                reportDeath();
                roundScore = endRound(newDice, null, newCard, true);
                playerScore += roundScore;
            } else if (isInIslandOfSkulls) {
                System.out.println("You've entered the Island of Skulls");
                deductedPointsFromOpponents = playSkullIsland(newDice, newCard);
            } else {
                roundScore = playGame(newDice, newCard);
                playerScore += roundScore;
            }
            // Report deduction if any in UI
            if (roundScore < 0) {
                System.out.println("You suffered a deduction of " + roundScore);
            }
            // Player score cannot be negative
            if (playerScore < 0) {
                playerScore = 0;
            }
            System.out.println("Your total score is: " + playerScore);
            player.sendPlayerScoreToServer(playerScore);
            player.sendDeductedPointsToOpponents(deductedPointsFromOpponents);
        }
    }

    // This function ends player's round and returns player's score
    public int endRound(String[] currentDice, String[] protectedDice, String fortuneCard, boolean isFirstRound) {
        int roundScore = 0;
        if (fortuneCard.equals(Constants.CHEST) && !isFirstRound) {
            String[] combinedDice = dice.combineDice(currentDice, protectedDice);
            boolean isDisqualified = score.isDisqualified(combinedDice, fortuneCard, false);
            if (isDisqualified) {
                roundScore = score.calculateScore(fortuneCard, protectedDice);
            } else {
                roundScore = score.calculateScore(fortuneCard, combinedDice);
            }
        } else {
            roundScore = score.calculateScore(fortuneCard, currentDice);
        }
        System.out.println("You got " + roundScore + " in this round");
        return roundScore;
    }

    // print all player scores
    public void printAllPlayerScores(PlayerServer[] playerServers) {
        for (int i = 0; i < playerServers.length; i++) {
            score.printPlayerScore(playerServers[i]);
        }
    }

    // This function reports death and returns death message
    public String reportDeath() {
        String deathMessage = "You're died";
        System.out.println(deathMessage);
        return deathMessage;
    }

    // report winner of the game
    public void reportWinner() {
        PlayerServer winner = player.receiveWinner();
        if (playerId == winner.playerId) {
            System.out.println("You are the winner!");
        } else {
            System.out.println("The winner is " + winner.name);
        }
        System.out.println("Game Over");
    }

}