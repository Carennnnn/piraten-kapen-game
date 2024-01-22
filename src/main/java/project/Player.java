package project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    PlayerServer p;
    private int playerId;

    public Player(PlayerServer playerServer) {
        try {
            p = playerServer;
            socket = new Socket("localhost", Constants.GAME_SERVER_PORT_NUMBER);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            playerId = inputStream.readInt();
            p.setPlayerId(playerId);
            System.out.println("Your player id is " + playerId);
            sendPlayerToServer(p);
        } catch (IOException e) {
            System.out.println("Client failed to connect");
        }
    }

    // send  player to game server
    public void sendPlayerToServer(PlayerServer p) {
        try {
            outputStream.writeObject(p);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Player failed to send");
            e.printStackTrace();
        }
    }

    // send player score to game server
    public void sendPlayerScoreToServer(int score) {
        try {
            outputStream.writeInt(score);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Player score failed to send");
            e.printStackTrace();
        }
    }

    // send opponents deducted points to game server
    public void sendDeductedPointsToOpponents(int deductedPointsFromOpponents) {
        try {
            outputStream.writeInt(deductedPointsFromOpponents);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Deducted points failed to send");
            e.printStackTrace();
        }
    }

    // receive players from player server
    public PlayerServer[] receivePlayerServers() {
        PlayerServer[] ps = new PlayerServer[Constants.PLAYER_NUM];
        try {
            for (int i = 0; i < Constants.PLAYER_NUM; i++) {
                PlayerServer p = (PlayerServer) inputStream.readObject();
                ps[i] = p;
            }
            return ps;
        } catch (IOException e) {
            System.out.println("Players not received");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // receive current round number
    public int receiveCurrentRoundNo() {
        try {
            return inputStream.readInt();
        } catch (IOException e) {
            System.out.println("Current Round number not received");
            e.printStackTrace();
        }
        return 0;
    }

    // receive player scores from game server
    public int[] receivePlayerScores() {
        try {
            int [] scores = new int[Constants.PLAYER_NUM];
            for (int i = 0; i < Constants.PLAYER_NUM; i++) {
                scores[i] = inputStream.readInt();
            }
            return scores;
        } catch (IOException e) {
            System.out.println("Player scores not received");
            e.printStackTrace();
        }
        return null;
    }

    // receive current player id from game server
    public int receiveCurrentPlayerId() {
        try {
            int playerId = inputStream.readInt();
            return playerId;
        } catch (IOException e) {
            System.out.println("Current player id not received");
            e.printStackTrace();
        }
        return 0;
    }

    // Receive fortune card for this turn from game server
    public String receiveFortuneCard() {
        try {
            String fortuneCard = inputStream.readUTF();
            return fortuneCard;
        } catch (IOException e) {
            System.out.println("Fortune card not received");
            e.printStackTrace();
        }
        return "";
    }

    // receive current player's previous score
    public int receivePreviousScore() {
        try {
            int previousScore = inputStream.readInt();
            return previousScore;
        } catch (IOException e) {
            System.out.println("Previous score not received");
            e.printStackTrace();
        }
        return 0;
    }

    // receive winner from game server
    public PlayerServer receiveWinner() {
        try {
            PlayerServer winner = (PlayerServer) inputStream.readObject();
            return winner;
        } catch (IOException e) {
            System.out.println("Winner not received");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
