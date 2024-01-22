package project.unitTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.Constants;
import project.Dice;

import java.util.Arrays;

public class DiceUnitTest extends TestCase {

    @Test
    // Test at least one skull is in re-rolled dice
    public void testAtLeastOneSkull() {
        Dice dice = new Dice();
        String[] dice1 = {Constants.SWORD, Constants.SWORD, Constants.PARROT, Constants.SKULL, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.COIN};
        int[] reRollPosition1 = {0, 1, 2};
        boolean atLeastOneSkull1 = dice.atLeastOneSkull(dice1, reRollPosition1);
        assertEquals(false,  atLeastOneSkull1);

        String[] dice2 = {Constants.SKULL, Constants.PARROT, Constants.DIAMOND, Constants.SWORD, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.MONKEY};
        int[] reRollPosition2 = {0, 1};
        boolean atLeastOneSkull2 = dice.atLeastOneSkull(dice2, reRollPosition2);
        assertEquals(true,  atLeastOneSkull2);

        String[] dice3 = {Constants.SKULL, Constants.SKULL, Constants.PARROT, Constants.DIAMOND, Constants.SWORD, Constants.SWORD, Constants.COIN, Constants.MONKEY};
        int[] reRollPosition3 = {0, 1};
        boolean atLeastOneSkull3 = dice.atLeastOneSkull(dice3, reRollPosition3);
        assertEquals(true,  atLeastOneSkull3);
    }

    // Test putDice function
    @Test
    public void testTakeDice() {
        Dice dice = new Dice();
        String[] currentDice1 = {Constants.SKULL, Constants.DIAMOND, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int[] dicePosition1 = {1, 3};
        String[] newDice1 = dice.takeDice(currentDice1, dicePosition1);
        String[] expectedDice1 = {Constants.SKULL, Constants.SKULL, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        assertTrue(Arrays.equals(expectedDice1, newDice1));

        String[] currentDice2 = {Constants.DIAMOND, Constants.SWORD, Constants.COIN};
        int[] dicePosition2 = {0};
        String[] newDice2 = dice.takeDice(currentDice2, dicePosition2);
        String[] expectedDice2 = {Constants.SWORD, Constants.COIN};
        assertTrue(Arrays.equals(expectedDice2, newDice2));

        String[] currentDice3 = {Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.SWORD, Constants.COIN};
        int[] dicePosition3 = {0, 1, 2, 3, 4};
        String[] newDice3 = dice.takeDice(currentDice3, dicePosition3);
        String[] expectedDice3 = {};
        assertTrue(Arrays.equals(expectedDice3, newDice3));
    }

    // Test putDice function
    @Test
    public void testPutDice() {
        Dice dice = new Dice();
        String[] currentDice1 = {Constants.COIN, Constants.DIAMOND, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String[] targetDice1 = {};
        int[] dicePosition1 = {0, 1};
        String[] newDice1 = dice.putDice(currentDice1, dicePosition1, targetDice1);
        String[] expectedDice1 = {Constants.COIN, Constants.DIAMOND};
        assertTrue(Arrays.equals(expectedDice1, newDice1));

        String[] currentDice2 = {Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String[] targetDice2 = {Constants.COIN, Constants.DIAMOND, Constants.PARROT};
        int[] dicePosition2 = {2, 3};
        String[] newDice2 = dice.putDice(currentDice2, dicePosition2, targetDice2);
        String[] expectedDice2 = {Constants.COIN, Constants.DIAMOND, Constants.PARROT, Constants.COIN, Constants.MONKEY};
        assertTrue(Arrays.equals(expectedDice2, newDice2));
    }

    // Test calculateRemainingSkullReRoll function
    @Test
    public void testRemainingSkullReRoll() {
        Dice dice = new Dice();
        String[] dice1 = {Constants.COIN, Constants.SKULL, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int numReRollSkull = 1;
        int[] reRollPosition1 = {0, 1};
        int remainingSkullReRoll = dice.calculateRemainingSkullReRoll(reRollPosition1, dice1, numReRollSkull);
        assertEquals(0, remainingSkullReRoll);

        String[] dice2 = {Constants.PARROT, Constants.PARROT, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        numReRollSkull = 1;
        int[] reRollPosition2 = {3, 4, 5};
        remainingSkullReRoll = dice.calculateRemainingSkullReRoll(reRollPosition2, dice2, numReRollSkull);
        assertEquals(1, remainingSkullReRoll);
    }

    // Test getDiceName function
    @Test
    public void testGetDiceName() {
        Dice dice = new Dice();
        String diceName1 = dice.getDiceName(2);
        String diceName2 = dice.getDiceName(1);
        String diceName3 = dice.getDiceName(3);
        String diceName4 = dice.getDiceName(5);
        String diceName5 = dice.getDiceName(6);
        String diceName6 = dice.getDiceName(4);
        String diceName7 = dice.getDiceName(0);
        String[] diceName = {diceName1, diceName2, diceName3, diceName4, diceName5, diceName6, diceName7};
        String[] expectedDiceName = {Constants.PARROT, Constants.MONKEY, Constants.SWORD, Constants.COIN, Constants.DIAMOND, Constants.SKULL, ""};
        for (int i = 0; i < diceName.length; i++) {
            assertEquals(expectedDiceName[i], diceName[i]);
        }
    }

    // Test rollAllDice function
    @Test
    public void testRollAllDice() {
        Dice dice = new Dice();
        String[] rolledDice = dice.rollAllDice();
        int monkeyNum = 0;
        int parrotNum = 0;
        int swordNum = 0;
        int skullNum = 0;
        int coinNum = 0;
        int diamondNum = 0;
        for (int i = 0; i < rolledDice.length; i++) {
            if (rolledDice[i].equals(Constants.MONKEY)) {
                monkeyNum += 1;
            } else if (rolledDice[i].equals(Constants.PARROT)) {
                parrotNum++;
            } else if (rolledDice[i].equals(Constants.SWORD)) {
                swordNum++;
            } else if (rolledDice[i].equals(Constants.SKULL)) {
                skullNum++;
            } else if (rolledDice[i].equals(Constants.COIN)) {
                coinNum++;
            } else if (rolledDice[i].equals(Constants.DIAMOND)) {
                diamondNum++;
            }
        }
        int[] diceNum = {monkeyNum, parrotNum, swordNum, skullNum, coinNum, diamondNum};
        int allDiceNum = 0;
        for (int i = 0; i < diceNum.length; i++) {
            allDiceNum += diceNum[i];
        }
        assertEquals(8, allDiceNum);
    }

    // Test reRollDice function
    @Test
    public void testReRollDice() {
        Dice dice = new Dice();
        String[] dice1 = {Constants.SKULL, Constants.COIN, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String[] originalDice = {Constants.SKULL, Constants.COIN, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int[] reRollPosition = {0, 1, 2, 3, 4, 5, 6};
        String[] reRolledDice = dice.reRollDice(dice1, reRollPosition);
        boolean isReRollPositionDifferent = false;
        boolean isRemainingPositionSame = false;
        for (int i = 0; i < reRollPosition.length; i++) {
            if (!(reRolledDice[reRollPosition[i]].equals(originalDice[reRollPosition[i]]))) {
                isReRollPositionDifferent = true;
            }
        }
        if (reRolledDice[7].equals(originalDice[7])) {
            isRemainingPositionSame = true;
        }
        assertEquals(true, isReRollPositionDifferent);
        assertEquals(true, isRemainingPositionSame);
    }

    // Test verifyReRollInput function
    @Test
    public void testReRollInput() {
        Dice dice = new Dice();
        // Test re-roll one die
        String[] currentDice = {Constants.COIN, Constants.SKULL, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String fortuneCard = Constants.COIN;
        int numReRollSkull = 0;
        int[] reRollPosition1 = {1};
        boolean isInValidInput = dice.verifyReRollInput(reRollPosition1, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);

        // Test input is not integers between 1 and 8
        int[] reRollPosition2 = {1, 9};
        isInValidInput = dice.verifyReRollInput(reRollPosition2, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);

        // Test skull cannot be re-rolled
        int[] reRollPosition3 = {0, 1};
        isInValidInput = dice.verifyReRollInput(reRollPosition3, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);

        // Test more than 8 dice cannot be re-rolled
        int[] reRollPosition4 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        isInValidInput = dice.verifyReRollInput(reRollPosition4, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);

        // Test only one skull can be re-rolled with sorceress card
        fortuneCard = Constants.SORCERESS;
        numReRollSkull = 1;
        int[] reRollPosition5 = {0, 1};
        isInValidInput = dice.verifyReRollInput(reRollPosition5, currentDice, fortuneCard, numReRollSkull);
        assertEquals(false, isInValidInput);

        // Test two skulls cannot be re-rolled with sorceress card
        numReRollSkull = 1;
        int[] reRollPosition6 = {1, 2};
        isInValidInput = dice.verifyReRollInput(reRollPosition6, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);

        // Test skull can be rolled once with sorceress card
        numReRollSkull = 0;
        int[] reRollPosition7 = {0, 1};
        isInValidInput = dice.verifyReRollInput(reRollPosition7, currentDice, fortuneCard, numReRollSkull);
        assertEquals(true, isInValidInput);
    }

    // Test verifyDicePosition function
    @Test
    public void testDicePosition() {
        Dice dice = new Dice();
        boolean isPut = false;
        // Test input more than 8
        String[] currentDice = {Constants.DIAMOND, Constants.SKULL, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String fortuneCard = Constants.COIN;
        int[] reRollPosition1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        boolean isInvalidInput = dice.verifyDicePosition(reRollPosition1, currentDice, false);
        assertEquals(true, isInvalidInput);

        // Test input of -1
        int[] reRollPosition2 = {-1};
        isInvalidInput = dice.verifyDicePosition(reRollPosition2, currentDice, false);
        assertEquals(true, isInvalidInput);
    }

    // Test combined dice
    @Test
    public void testCombineDice() {
        Dice dice = new Dice();
        String[] nonProtectedDice1 = {Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String[] protectedDice1 = {Constants.DIAMOND, Constants.SWORD, Constants.PARROT};
        String[] combinedDice1 = dice.combineDice(nonProtectedDice1, protectedDice1);
        String[] expectedResult1 =  {Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN, Constants.DIAMOND, Constants.SWORD, Constants.PARROT};
        assertTrue(Arrays.equals(expectedResult1, combinedDice1));

        String[] nonProtectedDice2 = {Constants.SWORD, Constants.SWORD, Constants.DIAMOND, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.MONKEY, Constants.COIN};
        String[] protectedDice2 = {};
        String[] combinedDice2 = dice.combineDice(nonProtectedDice2, protectedDice2);
        String[] expectedResult2 =  {Constants.SWORD, Constants.SWORD, Constants.DIAMOND, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.MONKEY, Constants.COIN};
        assertTrue(Arrays.equals(expectedResult2, combinedDice2));

        String[] nonProtectedDice3 = {};
        String[] protectedDice3 = {Constants.PARROT, Constants.MONKEY, Constants.SKULL, Constants.SWORD, Constants.SWORD, Constants.COIN, Constants.COIN, Constants.SKULL};
        String[] combinedDice3 = dice.combineDice(nonProtectedDice3, protectedDice3);
        String[] expectedResult3 = {Constants.PARROT, Constants.MONKEY, Constants.SKULL, Constants.SWORD, Constants.SWORD, Constants.COIN, Constants.COIN, Constants.SKULL};
        assertTrue(Arrays.equals(expectedResult3, combinedDice3));
    }

}

