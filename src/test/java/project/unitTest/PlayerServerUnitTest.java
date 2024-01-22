package project.unitTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.Constants;
import project.PlayerServer;

import java.util.Arrays;

public class PlayerServerUnitTest extends TestCase {

    // Test endRound function
    @Test
    public void testEndRound() {
        PlayerServer ps = new PlayerServer(" ");
        String fortuneCard = Constants.COIN;
        String[] currentDice1 = {Constants.COIN, Constants.COIN, Constants.SWORD, Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.MONKEY, Constants.SKULL};
        String[] protectedDice1 = {};
        boolean isFirstRound = true;
        int score = ps.endRound(currentDice1, protectedDice1, fortuneCard, isFirstRound);
        assertEquals(400, score);

        fortuneCard = Constants.CHEST;
        String[] currentDice2 = {Constants.SKULL, Constants.SKULL, Constants.SWORD, Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.MONKEY};
        String[] protectedDice2 = {Constants.SKULL};
        isFirstRound = false;
        score = ps.endRound(currentDice2, protectedDice2, fortuneCard, isFirstRound);
        assertEquals(0, score);

        String[] currentDice3 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.PARROT};
        String[] protectedDice3 = {Constants.COIN, Constants.COIN, Constants.COIN, Constants.PARROT};
        isFirstRound = false;
        score = ps.endRound(currentDice3, protectedDice3, fortuneCard, isFirstRound);
        assertEquals(400, score);

        String[] currentDice4 = {Constants.SKULL, Constants.DIAMOND, Constants.SKULL, Constants.PARROT};
        String[] protectedDice4 = {Constants.COIN, Constants.COIN, Constants.COIN, Constants.PARROT};
        isFirstRound = false;
        score = ps.endRound(currentDice4, protectedDice4, fortuneCard, isFirstRound);
        assertEquals(500, score);
    }

    // Test convertUserInput function
    @Test
    public void testConvertUserInput() {
        PlayerServer ps = new PlayerServer(" ");

        // Test normal input
        String userInput = "1, 2, 3";
        int[] reRollPosition1 = ps.convertUserInput(userInput);
        int[] expectedResult1 = {0, 1, 2};
        assertTrue(Arrays.equals(expectedResult1, reRollPosition1));

        // Test string input
        userInput = "ggsdkf";
        int[] reRollPosition2 = ps.convertUserInput(userInput);
        int[] expectedResult2 = {-1};
        assertTrue(Arrays.equals(expectedResult2, reRollPosition2));

        // Test empty input
        userInput = "";
        int[] reRollPosition3 = ps.convertUserInput(userInput);
        int[] expectedResult3 = {-1};
        assertTrue(Arrays.equals(expectedResult3, reRollPosition3));

        // Test special character input
        userInput = "1;2";
        int[] reRollPosition4 = ps.convertUserInput(userInput);
        int[] expectedResult4 = {-1};
        assertTrue(Arrays.equals(expectedResult4, reRollPosition4));
    }

}
