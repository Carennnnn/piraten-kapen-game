package project;

import java.io.Serializable;

public class Score implements Serializable {
    private static final long serialVersionUID = 1L;

    // print player score
    public void printPlayerScore(PlayerServer p) {
        System.out.println("Player " + p.name + " with id " + p.playerId + "'s score: " + p.getPlayerScore());
    }

    // Check if player is in skull island
    public boolean isInIslandOfSkulls(String[] currentDice, String fortuneCard) {
        int skullNum = getSkullNum(currentDice, fortuneCard);
        boolean isInSeaBattle = isInSeaBattle(fortuneCard);
        if (skullNum >= 4 && !isInSeaBattle) {
            return true;
        }
        return false;
    }

    // Check if player has sea battle card
    public boolean isInSeaBattle(String fortuneCard) {
        if (
                fortuneCard.equals(Constants.TWO_SWORDS) ||
                        fortuneCard.equals(Constants.THREE_SWORDS) ||
                        fortuneCard.equals(Constants.FOUR_SWORDS)
        ) {
            return true;
        }
        return false;
    }

    // Get number of skulls in dice
    public int getSkullNum(String[] currentDice, String fortuneCard) {
        int skullNum = 0;
        if (fortuneCard.equals(Constants.ONE_SKULL)) {
            skullNum++;
        } else if (fortuneCard.equals(Constants.TWO_SKULLS)) {
            skullNum += 2;
        }
        for (int i = 0; i < currentDice.length; i++) {
            if (currentDice[i].equals(Constants.SKULL)) {
                skullNum++;
            }
        }
        return skullNum;
    }

    // if player rolls 3 skulls in the first turn, or accumulates more than 3 skulls in the following turns,
    // the player is disqualified
    public boolean isDisqualified(String[] currentDice, String fortuneCard, boolean isFirstTurn) {
        int skullNum = getSkullNum(currentDice, fortuneCard);
        if (skullNum == 3 && isFirstTurn) {
            return true;
        } else if (skullNum >= 3 && !isFirstTurn) {
            return true;
        }
        return false;
    }

    // calculate deducted points to all the opponents in skull island
    public int calculateDeductedPoints(String fortuneCard, String[] currentDice) {
        int skullNum = getSkullNum(currentDice, fortuneCard);
        int deductedPoints = skullNum * 100;
        if (fortuneCard.equals(Constants.CAPTAIN)) {
            deductedPoints *= 2;
        }
        return deductedPoints;
    }

    // Calculate score for a round
    public int calculateScore(String fortuneCard, String[] currentDice) {
        int numDiceGeneratePoints = 0;
        int score = 0;
        int skullNum = 0;
        int monkeyNum = 0;
        int parrotNum = 0;
        int swordNum = 0;
        int coinNum = 0;
        int diamondNum = 0;

        // add fortune card number
        if (fortuneCard.equals(Constants.DIAMOND_CARD)) {
            numDiceGeneratePoints--;
            diamondNum++;
        } else if (fortuneCard.equals(Constants.COIN_CARD)) {
            numDiceGeneratePoints--;
            coinNum++;
        } else if (fortuneCard.equals(Constants.ONE_SKULL)) {
            skullNum++;
        } else if (fortuneCard.equals(Constants.TWO_SKULLS)) {
            skullNum += 2;
        }

        //add different dice number
        for (int i = 0; i < currentDice.length; i++) {
            // if fortune card is monkey business, then monkey and parrot are grouped together and are considered as one group
            if (fortuneCard.equals(Constants.MONKEY_AND_PARROT)) {
                if (currentDice[i].equals(Constants.MONKEY) || currentDice[i].equals(Constants.PARROT)) {
                    monkeyNum++;
                }
            } else {
                if (currentDice[i].equals(Constants.MONKEY)) {
                    monkeyNum++;
                } else if (currentDice[i].equals(Constants.PARROT)) {
                    parrotNum++;
                }
            }
           if (currentDice[i].equals(Constants.SKULL)) {
                skullNum++;
           } else if (currentDice[i].equals(Constants.SWORD)) {
                swordNum++;
           } else if (currentDice[i].equals(Constants.COIN)) {
                coinNum++;
           } else if (currentDice[i].equals(Constants.DIAMOND)) {
                diamondNum++;
           }
        }

        // add 100 points for each coin or diamond
        if (coinNum > 0) {
            score += 100 * coinNum;
        }
        if (diamondNum > 0) {
            score += 100 * diamondNum;
        }

        // add points for sets of identical objects
        int[] identicalObjectsNum = {skullNum, monkeyNum, parrotNum, swordNum, coinNum, diamondNum};
        for (int i = 0; i < identicalObjectsNum.length; i++) {
            if (identicalObjectsNum[i] == 3) {
                numDiceGeneratePoints += 3;
                score += Constants.THREE_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 4) {
                numDiceGeneratePoints += 4;
                score += Constants.FOUR_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 5) {
                numDiceGeneratePoints += 5;
                score += Constants.FIVE_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 6) {
                numDiceGeneratePoints += 6;
                score += Constants.SIX_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 7) {
                numDiceGeneratePoints += 7;
                score += Constants.SEVEN_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 8) {
                numDiceGeneratePoints += 8;
                score += Constants.EIGHT_OF_A_KIND_POINTS;
            } else if (identicalObjectsNum[i] == 9) {
                numDiceGeneratePoints += 9;
                score += Constants.EIGHT_OF_A_KIND_POINTS;
            }
        }

        // diamond and coin also generate points
        if (diamondNum < 3) {
            numDiceGeneratePoints += diamondNum;
        }
        if (coinNum < 3) {
            numDiceGeneratePoints += coinNum;
        }

        // if fortune card is sea battle, add the bonus points if indicated number of swords is rolled
        if (fortuneCard.equals(Constants.TWO_SWORDS)) {
            if (swordNum >= 2 && skullNum < 3) {
                numDiceGeneratePoints += 2;
                score += 300;
            } else {
                score = -300;
            }
        } else if (fortuneCard.equals(Constants.THREE_SWORDS)) {
            if (swordNum >= 3 && skullNum < 3) {
                score += 500;
            } else {
                score = -500;
            }
        } else if (fortuneCard.equals(Constants.FOUR_SWORDS)) {
            if (swordNum >= 4 && skullNum < 3) {
                score += 1000;
            } else {
                score = -1000;
            }
        }
        if (numDiceGeneratePoints == 8 && score >= 0) {
            score += 500;
        }
        if (fortuneCard.equals(Constants.CAPTAIN)) {
            score *= 2;
        }
        boolean isInSeaBattle = isInSeaBattle(fortuneCard);
        if (skullNum == 3 && !isInSeaBattle) {
            score = 0;
        }
        return score;
    }

}
