package project.unitTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.Constants;
import project.Score;

public class ScoreUnitTest extends TestCase {

    @Test
    // Test deducted points to opponents in skull island
    public void testCalculateDeductedPoints() {
        Score score = new Score();
        String fortuneCard = Constants.COIN_CARD;
        String[] dice1 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int deductedPoints = score.calculateDeductedPoints(fortuneCard, dice1);
        assertEquals(400, deductedPoints);

        fortuneCard = Constants.ONE_SKULL;
        String[] dice2 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        deductedPoints = score.calculateDeductedPoints(fortuneCard, dice2);
        assertEquals(500, deductedPoints);

        fortuneCard = Constants.TWO_SKULLS;
        String[] dice3 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.MONKEY, Constants.COIN};
        deductedPoints = score.calculateDeductedPoints(fortuneCard, dice3);
        assertEquals(700, deductedPoints);

        fortuneCard = Constants.CAPTAIN;
        String[] dice4 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.PARROT, Constants.COIN, Constants.MONKEY, Constants.COIN};
        deductedPoints = score.calculateDeductedPoints(fortuneCard, dice4);
        assertEquals(800, deductedPoints);
    }

    @Test
    // Test full chest card
    public void testFullChest() {
        Score score = new Score();
        String fortuneCard1 = Constants.COIN;
        String[] dice1 = {Constants.DIAMOND, Constants.DIAMOND, Constants.COIN,  Constants.MONKEY, Constants.MONKEY, Constants.MONKEY,  Constants.MONKEY, Constants.SKULL};
        int roundScore = score.calculateScore(fortuneCard1, dice1);
        assertEquals(600,  roundScore);

        String fortuneCard2 = Constants.CAPTAIN;
        String[] dice2 = {Constants.DIAMOND, Constants.DIAMOND, Constants.DIAMOND, Constants.COIN, Constants.MONKEY, Constants.MONKEY,Constants.MONKEY, Constants.MONKEY};
        roundScore = score.calculateScore(fortuneCard2, dice2);
        assertEquals(2400,  roundScore);

        String fortuneCard3 = Constants.DIAMOND;
        String[] dice3 = {Constants.DIAMOND, Constants.DIAMOND, Constants.DIAMOND, Constants.COIN, Constants.MONKEY, Constants.MONKEY,Constants.MONKEY, Constants.MONKEY};
        roundScore = score.calculateScore(fortuneCard3, dice3);
        assertEquals(1400,  roundScore);

        String fortuneCard4 = Constants.MONKEY_AND_PARROT;
        String[] dice4 = {Constants.MONKEY,Constants.MONKEY, Constants.MONKEY, Constants.PARROT, Constants.COIN, Constants.COIN,Constants.COIN, Constants.COIN};
        roundScore = score.calculateScore(fortuneCard4, dice4);
        assertEquals(1300,  roundScore);

        String fortuneCard5 = Constants.TWO_SWORDS;
        String[] dice5 = {Constants.SWORD,Constants.SWORD, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.COIN,Constants.COIN, Constants.COIN};
        roundScore = score.calculateScore(fortuneCard5, dice5);
        assertEquals(1300,  roundScore);
    }

    @Test
    // Test captain card
    public void testCaptainCard() {
        Score score = new Score();
        String fortuneCard = Constants.CAPTAIN;
        String[] dice1 = {Constants.DIAMOND, Constants.DIAMOND, Constants.COIN, Constants.PARROT, Constants.MONKEY, Constants.MONKEY, Constants.SKULL, Constants.SKULL};
        int roundScore = score.calculateScore(fortuneCard, dice1);
        assertEquals(600,  roundScore);

        String[] dice2 = {Constants.DIAMOND, Constants.DIAMOND, Constants.DIAMOND, Constants.COIN, Constants.COIN, Constants.COIN, Constants.SKULL, Constants.SKULL};
        roundScore = score.calculateScore(fortuneCard, dice2);
        assertEquals(1600,  roundScore);
    }

    @Test
    // Test points with three skulls
    public void testThreeSkullsPoints() {
        Score score = new Score();
        String fortuneCard = Constants.COIN_CARD;
        String[] dice1 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        String[] dice2 = {Constants.SWORD, Constants.SWORD, Constants.DIAMOND, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.MONKEY, Constants.COIN};
        String[] dice3 = {Constants.DIAMOND, Constants.SWORD, Constants.PARROT, Constants.MONKEY, Constants.COIN, Constants.SKULL, Constants.SKULL, Constants.SKULL};
        String[][] testCases = {dice1, dice2, dice3};
        for (int i = 0; i < testCases.length; i++) {
            int roundScore = score.calculateScore(fortuneCard, testCases[i]);
            assertEquals(0, roundScore);
        }

        fortuneCard = Constants.ONE_SKULL;
        String[] dice4 = {Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int roundScore = score.calculateScore(fortuneCard, dice4);
        assertEquals(0, roundScore);

        fortuneCard = Constants.TWO_SKULLS;
        String[] dice5 = {Constants.SKULL, Constants.DIAMOND, Constants.COIN, Constants.DIAMOND, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        roundScore = score.calculateScore(fortuneCard, dice5);
        assertEquals(0, roundScore);
    }

    @Test
    // Test Sea Battle card
    public void testSeaBattleCard() {
        Score score = new Score();
        // Test two swords card
        String fortuneCard = Constants.TWO_SWORDS;
        String[] dice1 = {Constants.SWORD, Constants.SWORD, Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.MONKEY, Constants.SKULL, Constants.SKULL};
        int roundScore = score.calculateScore(fortuneCard, dice1);
        assertEquals(300,  roundScore);

        // Test three swords card
        fortuneCard = Constants.THREE_SWORDS;
        String[] dice2 = {Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.MONKEY, Constants.MONKEY, Constants.SKULL, Constants.SKULL};
        roundScore = score.calculateScore(fortuneCard, dice2);
        assertEquals(700,  roundScore);

        // Test four swords card
        fortuneCard = Constants.FOUR_SWORDS;
        String[] dice3 = {Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.MONKEY, Constants.MONKEY, Constants.SKULL, Constants.SKULL};
        roundScore = score.calculateScore(fortuneCard, dice3);
        assertEquals(1200,  roundScore);

        // Test if you fail to roll indicated swords, then you lose the indicated bonus points
        fortuneCard = Constants.FOUR_SWORDS;
        String[] dice4 = {Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.DIAMOND, Constants.COIN};
        roundScore = score.calculateScore(fortuneCard, dice4);
        assertEquals(-1000,  roundScore);

        // Test if you roll three skulls and die, then you lose the indicated bonus points
        fortuneCard = Constants.TWO_SWORDS;
        String[] dice5 = {Constants.SWORD, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.MONKEY, Constants.MONKEY, Constants.DIAMOND, Constants.COIN};
        roundScore = score.calculateScore(fortuneCard, dice5);
        assertEquals(-300,  roundScore);

        // Test if you roll four or more skulls, you cannot go to the Island of Skulls, and you'll lose the indicated bonus points
        fortuneCard = Constants.THREE_SWORDS;
        String[] dice6 = {Constants.SWORD, Constants.SWORD, Constants.PARROT, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.MONKEY};
        roundScore = score.calculateScore(fortuneCard, dice5);
        assertEquals(-500,  roundScore);
    }

    @Test
    // Test Monkey Business card
    public void testMonkeyBusinessCard() {
        Score score = new Score();
        String fortuneCard = Constants.MONKEY_AND_PARROT;
        String[] dice1 = {Constants.PARROT, Constants.MONKEY, Constants.SKULL, Constants.SWORD, Constants.SWORD, Constants.COIN, Constants.COIN, Constants.SKULL};
        String[] dice2 = {Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.COIN, Constants.SWORD, Constants.SWORD, Constants.SKULL, Constants.SKULL};
        String[] dice3 = {Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.SWORD, Constants.SKULL, Constants.SKULL};
        String[][] testCases = {dice1, dice2, dice3};
        int[] expectedScore = {200, 200, 500};
        for (int i = 0; i < testCases.length; i++) {
            int roundScore = score.calculateScore(fortuneCard, testCases[i]);
            assertEquals(expectedScore[i],  roundScore);
        }
    }

    @Test
    // Test scoring for sets of identical objects
    public void testSetsOfIdenticalObjects() {
        Score score = new Score();
        String fortuneCard = Constants.SKULL;
        String[] dice1 = {Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.PARROT, Constants.PARROT, Constants.MONKEY, Constants.MONKEY, Constants.SKULL};
        String[] dice2 = {Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.SWORD, Constants.SWORD, Constants.MONKEY, Constants.SKULL};
        String[] dice3 = {Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.PARROT, Constants.PARROT, Constants.SKULL};
        String[] dice4 = {Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.SWORD, Constants.PARROT, Constants.SKULL};
        String[] dice5 = {Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.PARROT, Constants.SKULL};
        String[][] testCases = {dice1, dice2, dice3, dice4, dice5};
        int[] expectedScore = {100, 200, 500, 1000, 2000};
        for (int i = 0; i < testCases.length; i++) {
            int roundScore = score.calculateScore(fortuneCard, testCases[i]);
            assertEquals(expectedScore[i], roundScore);
        }

        fortuneCard = Constants.COIN_CARD;
        String[] dice7 = {Constants.COIN, Constants.COIN,Constants.MONKEY, Constants.MONKEY, Constants.MONKEY, Constants.PARROT, Constants.PARROT, Constants.PARROT};
        int roundScore = score.calculateScore(fortuneCard, dice7);
        assertEquals(1100, roundScore);

        fortuneCard = Constants.DIAMOND_CARD;
        String[] dice8 = {Constants.DIAMOND, Constants.DIAMOND,Constants.DIAMOND, Constants.MONKEY, Constants.MONKEY, Constants.PARROT, Constants.PARROT, Constants.PARROT};
        roundScore = score.calculateScore(fortuneCard, dice8);
        assertEquals(700, roundScore);
    }

    @Test
    // Test if user has sea battle card
    public void testIsInIslandOfSkulls() {
        Score score = new Score();
        String fortuneCard = Constants.PARROT;
        String[] dice1 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        boolean isInIslandOfSkulls = score.isInIslandOfSkulls(dice1, fortuneCard);
        assertEquals(true, isInIslandOfSkulls);

        fortuneCard = Constants.ONE_SKULL;
        String[] dice2 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isInIslandOfSkulls = score.isInIslandOfSkulls(dice2, fortuneCard);
        assertEquals(true, isInIslandOfSkulls);

        fortuneCard = Constants.TWO_SKULLS;
        String[] dice3 = {Constants.SKULL, Constants.SKULL, Constants.MONKEY, Constants.COIN, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isInIslandOfSkulls = score.isInIslandOfSkulls(dice3, fortuneCard);
        assertEquals(true, isInIslandOfSkulls);

        fortuneCard = Constants.TWO_SKULLS;
        String[] dice4 = {Constants.SKULL, Constants.DIAMOND, Constants.DIAMOND, Constants.COIN, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isInIslandOfSkulls = score.isInIslandOfSkulls(dice4, fortuneCard);
        assertEquals(false, isInIslandOfSkulls);

        fortuneCard = Constants.TWO_SWORDS;
        String[] dice5 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isInIslandOfSkulls = score.isInIslandOfSkulls(dice5, fortuneCard);
        assertEquals(false, isInIslandOfSkulls);
    }

    @Test
    // Test if user has sea battle card
    public void testIsInSeaBattle() {
        Score score = new Score();
        String fortuneCard = Constants.TWO_SWORDS;
        boolean isInSeaBattle = score.isInSeaBattle(fortuneCard);
        assertEquals(true, isInSeaBattle);

        fortuneCard = Constants.THREE_SWORDS;
        isInSeaBattle = score.isInSeaBattle(fortuneCard);
        assertEquals(true, isInSeaBattle);

        fortuneCard = Constants.FOUR_SWORDS;
        isInSeaBattle = score.isInSeaBattle(fortuneCard);
        assertEquals(true, isInSeaBattle);

        fortuneCard = Constants.SKULL;
        isInSeaBattle = score.isInSeaBattle(fortuneCard);
        assertEquals(false, isInSeaBattle);
    }

    @Test
    // Test skull number in dice
    public void testGetSkullNum() {
        Score score = new Score();
        String fortuneCard = Constants.COIN;
        String[] dice1 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.MONKEY, Constants.COIN};
        int skullNum = score.getSkullNum(dice1, fortuneCard);
        assertEquals(5, skullNum);

        fortuneCard = Constants.ONE_SKULL;
        String[] dice2 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.DIAMOND, Constants.PARROT, Constants.COIN, Constants.MONKEY, Constants.COIN};
        skullNum = score.getSkullNum(dice2, fortuneCard);
        assertEquals(4, skullNum);

        fortuneCard = Constants.TWO_SKULLS;
        String[] dice3 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.PARROT, Constants.COIN, Constants.MONKEY, Constants.COIN};
        skullNum = score.getSkullNum(dice3, fortuneCard);
        assertEquals(6, skullNum);
    }

    @Test
    // Test if player is disqualified
    public void testDisqualified() {
        Score score = new Score();
        String fortuneCard = Constants.COIN;

        // Test two skulls in the first turn
        boolean isFirstTurn = true;
        String[] dice1 = {Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.COIN, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        boolean isDied = score.isDisqualified(dice1, fortuneCard, isFirstTurn);
        assertEquals(false, isDied);

        // Test three skulls in the first turn
        isFirstTurn = true;
        String[] dice2 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.COIN, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isDied = score.isDisqualified(dice2, fortuneCard, isFirstTurn);
        assertEquals(true, isDied);

        // Test four skulls in the first turn
        isFirstTurn = true;
        String[] dice3 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isDied = score.isDisqualified(dice3, fortuneCard, isFirstTurn);
        assertEquals(false, isDied);

        // Test four skulls in the second turn
        isFirstTurn = false;
        String[] dice4 = {Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SKULL, Constants.SWORD, Constants.COIN, Constants.MONKEY, Constants.COIN};
        isDied = score.isDisqualified(dice3, fortuneCard, isFirstTurn);
        assertEquals(true, isDied);
    }

}
