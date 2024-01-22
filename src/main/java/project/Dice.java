package project;

import java.io.Serializable;

public class Dice implements Serializable {
    private static final long serialVersionUID = 1L;

    // Get dice name by number
    public String getDiceName(int num) {
        switch (num) {
            case 1:
                return Constants.MONKEY;
            case 2:
                return Constants.PARROT;
            case 3:
                return Constants.SWORD;
            case 4:
                return Constants.SKULL;
            case 5:
                return Constants.COIN;
            case 6:
                return Constants.DIAMOND;
        }
        return "";
    }

    // Roll all dice
    public String[] rollAllDice() {
        String[] dice = new String[Constants.DICE_NUM];
        for (int i = 0; i < Constants.DICE_NUM; i++) {
            int temp = (int) (Math.random() * Constants.DIE_FACE_NUM + 1);
            dice[i] = getDiceName(temp);
        }
        return dice;
    }

    // Re roll dice at specified positions
    public String[] reRollDice(String[] currentDice, int[] reRollPosition) {
        for (int i = 0; i < reRollPosition.length; i++) {
            int temp = (int) (Math.random() * Constants.DIE_FACE_NUM + 1);
            currentDice[reRollPosition[i]] = getDiceName(temp);
        }
        return currentDice;
    }
    
    // Verify user input to re-roll the dice
    public boolean verifyReRollInput(int[] reRollPosition, String[] currentDice, String fortuneCard, int numReRollSkull) {
        if (reRollPosition.length < 2) {
            int skullNum = 0;
            for (int i = 0; i < reRollPosition.length; i++) {
                if (currentDice[reRollPosition[i]].equals(Constants.SKULL)) {
                    skullNum++;
                }
            }
            if (fortuneCard.equals(Constants.SORCERESS) && skullNum == 1) {
                return false;
            } else {
                System.out.println("You must roll at least 2 dice");
                return true;
            }
        } else {
            for (int i = 0; i < reRollPosition.length; i++) {
                if (reRollPosition[i] < 0 || reRollPosition[i] > 7) {
                    System.out.println("You must enter integers between 1 and 8");
                    return true;
                }
                if (currentDice[reRollPosition[i]].equals(Constants.SKULL)) {
                    if (fortuneCard.equals(Constants.SORCERESS) && numReRollSkull > 0) {
                        numReRollSkull--;
                    } else {
                        if (fortuneCard.equals(Constants.SORCERESS)) {
                            System.out.println("You are only allowed to re-roll one skull with sorceress card");
                        } else {
                            System.out.println("Skull cannot be re-rolled");
                        }
                        return true;
                    }
                }
            }
            if (reRollPosition.length > 8) {
                System.out.println("You cannot re-roll more than 8 dices");
                return true;
            }
        }
        return false;
    }

    // Verify each dice position is valid
    // and dice position is valid on the Treasure Chest card
    public boolean verifyDicePosition(int[] dicePosition, String[] currentDice, boolean isPut) {
        for (int i = 0; i < dicePosition.length; i++) {
            if (dicePosition[i] < 0 || dicePosition[i] >= currentDice.length) {
                if (currentDice.length > 1) {
                    System.out.println("You must enter integers between 1 and " + (currentDice.length));
                } else if (currentDice.length == 1) {
                    System.out.println("You must enter integer 1");
                } else {
                    if (isPut) {
                        System.out.println("You've already put all dice on the Treasure Chest card");
                    } else {
                        System.out.println("You've already taken out all dice from the Treasure Chest card");
                    }
                }
                return true;
            }
        }
        if (dicePosition.length > currentDice.length) {
            if (isPut) {
                System.out.println("You cannot put more than 8 dice on the Treasure Chest card");
            } else {
                System.out.println("You cannot take out more than " + currentDice.length + " dice from the Treasure Chest card");
            }
            return true;
        }
        return false;
    }

    // Print all dice
    public void printDice(String[] dice) {
        System.out.print("Dice: ");
        for (int i = 0; i < dice.length; i++) {
            System.out.print(dice[i] + " ");
        }
        System.out.println();
    }

    // Code to combine non-protected and protected dice
    public String[] combineDice(String[] nonProtectedDice, String[] protectedDice) {
        String[] combinedDice = new String[nonProtectedDice.length + protectedDice.length];
        for (int i = 0; i < nonProtectedDice.length; i++) {
            combinedDice[i] = nonProtectedDice[i];
        }
        int index = 0;
        for (int i = nonProtectedDice.length; i < combinedDice.length; i++) {
            combinedDice[i] = protectedDice[index];
            index++;
        }
        return combinedDice;
    }

    // Calculate the remaining times a player can re-roll a skull
    public int calculateRemainingSkullReRoll(int[] reRollPosition, String[] currentDice, int numReRollSkull) {
        for (int i = 0; i < reRollPosition.length; i++) {
            if (currentDice[reRollPosition[i]].equals(Constants.SKULL) && numReRollSkull > 0) {
                numReRollSkull--;
            }
        }
        return numReRollSkull;
    }

    // This function place dice from current dice to target dice by indicated dice positions
    // This function returns new target dice
    public String[] putDice(String[] currentDice, int[] dicePosition, String[] targetDice) {
        String[] newDice = new String[dicePosition.length + targetDice.length];
        for (int i = 0; i < targetDice.length; i++) {
            newDice[i] = targetDice[i];
        }
        for (int i = 0; i < dicePosition.length; i++) {
            newDice[i + targetDice.length] = currentDice[dicePosition[i]];
        }
        return newDice;
    }

    // This function takes dice out from current dice by indicated dice position
    // This function returns current dice after the dice are taken
    public String[] takeDice(String[] currentDice, int[] dicePosition) {
        String[] tempDice = currentDice;
        String[] newDice = new String[currentDice.length - dicePosition.length];
        for (int i = 0; i < dicePosition.length; i++) {
            tempDice[dicePosition[i]] = null;
        }
        int index = 0;
        for (int i = 0; i < tempDice.length; i++) {
            if (tempDice[i] != null) {
                newDice[index] = tempDice[i];
                index++;
            }
        }
        return newDice;
    }

    // Print dice on Treasure Chest card
    public void printProtectedDice(String[] dice) {
        System.out.print("Dice on Treasure Chest Card: ");
        for (int i = 0; i < dice.length; i++) {
            System.out.print(dice[i] + " ");
        }
        System.out.println();
    }

    // This function returns if re-rolled dice have at least one skull
    // So player can continue play in skull island
    public boolean atLeastOneSkull(String[] currentDice, int[] reRollPosition) {
        String[] rerolledDice = new String[reRollPosition.length];
        for (int i = 0; i < reRollPosition.length; i++) {
            rerolledDice[i] = currentDice[reRollPosition[i]];
        }
        for (int i = 0; i < rerolledDice.length; i++) {
            if (rerolledDice[i].equals(Constants.SKULL)) {
                return true;
            }
        }
        return false;
    }

}
