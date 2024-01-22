package project.acceptanceTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.*;

public class Part2AcceptanceTest extends TestCase {

    // Test Sorceress
    @Test
    public void testRow77() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int numReRollSkull = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.SORCERESS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.DIAMOND;
        diceRoll[1] = Constants.DIAMOND;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {5, 6, 7};
        if (fortuneCard.equals(Constants.SORCERESS)) {
            numReRollSkull = 1;
        }
        boolean isInputInvalid = dice.verifyReRollInput(reRollPosition1, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition1, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[5] = Constants.SKULL;
            diceRoll[6] = Constants.MONKEY;
            diceRoll[7] = Constants.MONKEY;
        }
        int[] reRollPosition2 = {5};
        isInputInvalid = dice.verifyReRollInput(reRollPosition2, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition2, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
            diceRoll[5] = Constants.MONKEY;
        }
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow78() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int numReRollSkull = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.SORCERESS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {0};
        if (fortuneCard.equals(Constants.SORCERESS)) {
            numReRollSkull = 1;
        }
        boolean isInputInvalid = dice.verifyReRollInput(reRollPosition1, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition1, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[0] = Constants.PARROT;
        }
        int[] reRollPosition2 = {6, 7};
        isInputInvalid = dice.verifyReRollInput(reRollPosition2, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition2, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
            diceRoll[6] = Constants.PARROT;
            diceRoll[7] = Constants.PARROT;
        }
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1000, roundScore);
    }

    @Test
    public void testRow79() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int numReRollSkull = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.SORCERESS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.MONKEY;
        int[] reRollPosition1 = {5, 6, 7};
        if (fortuneCard.equals(Constants.SORCERESS)) {
            numReRollSkull = 1;
        }
        boolean isInputInvalid = dice.verifyReRollInput(reRollPosition1, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition1, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[5] = Constants.SKULL;
            diceRoll[6] = Constants.PARROT;
            diceRoll[7] = Constants.PARROT;
        }
        int[] reRollPosition2 = {0};
        isInputInvalid = dice.verifyReRollInput(reRollPosition2, diceRoll, fortuneCard, numReRollSkull);
        if (fortuneCard.equals(Constants.SORCERESS) && !isInputInvalid) {
            numReRollSkull = dice.calculateRemainingSkullReRoll(reRollPosition2, diceRoll, numReRollSkull);
        }
        if (!isInputInvalid) {
            diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
            diceRoll[0] = Constants.PARROT;
        }
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(2000, roundScore);
    }

    // Test Monkey Business
    @Test
    public void testRow82() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.MONKEY_AND_PARROT;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1100, roundScore);
    }

    @Test
    public void testRow83() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.MONKEY_AND_PARROT;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        int[] reRollPosition1 = {2, 3};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1700, roundScore);
    }

    @Test
    public void testRow84() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.MONKEY_AND_PARROT;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.MONKEY;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(0, roundScore);
    }

    @Test
    // Test Treasure Chest
    public void testRow90() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        PlayerServer ps = new PlayerServer(" ");
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CHEST;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.PARROT;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.DIAMOND;
        diceRoll[6] = Constants.DIAMOND;
        diceRoll[7] = Constants.COIN;
        String[] protectedDice = new String[0];
        int[] putPosition1 = {5, 6, 7};
        protectedDice = dice.putDice(diceRoll, putPosition1, protectedDice);
        diceRoll = dice.takeDice(diceRoll, putPosition1);
        int[] reRollPosition1 = {3, 4};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        int[] putPosition2 = {0, 1, 2, 3, 4};
        protectedDice = dice.putDice(diceRoll, putPosition2, protectedDice);
        diceRoll = dice.takeDice(diceRoll, putPosition2);
        int[] takePosition1 = {0, 1, 2};
        diceRoll = dice.putDice(protectedDice, takePosition1, diceRoll);
        protectedDice = dice.takeDice(protectedDice, takePosition1);
        int[] reRollPosition2 = {0, 1, 2};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.PARROT;
        roundScore = ps.endRound(diceRoll, protectedDice, fortuneCard, false);
        assertEquals(1100, roundScore);
    }

    @Test
    // Test Treasure Chest
    public void testRow94() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        PlayerServer ps = new PlayerServer(" ");
        String deathMessage = "";
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CHEST;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        String[] protectedDice = new String[0];
        int[] putPosition1 = {5, 6, 7};
        protectedDice = dice.putDice(diceRoll, putPosition1, protectedDice);
        diceRoll = dice.takeDice(diceRoll, putPosition1);
        int[] reRollPosition1 = {2, 3, 4};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[2] = Constants.DIAMOND;
        diceRoll[3] = Constants.DIAMOND;
        diceRoll[4] = Constants.COIN;
        int[] putPosition2 = {4};
        protectedDice = dice.putDice(diceRoll, putPosition2, protectedDice);
        diceRoll = dice.takeDice(diceRoll, putPosition2);
        int[] reRollPosition2 = {2, 3};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.COIN;
        boolean isDied = score.isDisqualified(diceRoll, fortuneCard, false);
        if (isDied) {
            deathMessage = ps.reportDeath();
        }
        roundScore = ps.endRound(diceRoll, protectedDice, fortuneCard, false);
        assertEquals("You're died", deathMessage);
        assertEquals(600, roundScore);
    }

    @Test
    // Test Full Chest
    public void testRow97() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.DIAMOND;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(400, roundScore);
    }

    @Test
    public void testRow98() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CAPTAIN;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1800, roundScore);
    }

    @Test
    public void testRow99() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.DIAMOND;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1000, roundScore);
    }

    @Test
    public void testRow102() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.COIN;
        int[] reRollPosition1 = {5, 6};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1200, roundScore);
    }

    @Test
    public void testRow103() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.MONKEY_AND_PARROT;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.DIAMOND;
        diceRoll[6] = Constants.DIAMOND;
        diceRoll[7] = Constants.DIAMOND;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1200, roundScore);
    }

    @Test
    public void testRow106() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SKULLS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SWORD;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        boolean isDied = score.isDisqualified(diceRoll, fortuneCard, true);
        assertEquals(0, roundScore);
        assertEquals(true, isDied);
    }

    @Test
    public void testRow107() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.ONE_SKULL;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        boolean isDied = score.isDisqualified(diceRoll, fortuneCard, true);
        assertEquals(0, roundScore);
        assertEquals(true, isDied);
    }

    @Test
    public void testRow109() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int deductedPointsFromOpponents = 0;
        boolean canContinue = false;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SKULLS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.MONKEY;
        boolean isInIslandOfSkulls = score.isInIslandOfSkulls(diceRoll, fortuneCard);
        if (isInIslandOfSkulls) {
            roundScore = 0;
            int[] reRollPosition1 = {2, 3, 4};
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[2] = Constants.SKULL;
            diceRoll[3] = Constants.SKULL;
            diceRoll[4] = Constants.SWORD;
            canContinue = dice.atLeastOneSkull(diceRoll, reRollPosition1);
            if (canContinue) {
                int[] reRollPosition2 = {4, 5, 6, 7};
                diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
                diceRoll[4] = Constants.SKULL;
                diceRoll[5] = Constants.SKULL;
                diceRoll[6] = Constants.SKULL;
                diceRoll[7] = Constants.SWORD;
            }
            deductedPointsFromOpponents = -1 * score.calculateDeductedPoints(fortuneCard, diceRoll);
        }
        assertEquals(0, roundScore);
        assertEquals(-900, deductedPointsFromOpponents);
    }

    @Test
    public void testRow110() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int deductedPointsFromOpponents = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CAPTAIN;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.MONKEY;
        boolean isInIslandOfSkulls = score.isInIslandOfSkulls(diceRoll, fortuneCard);
        if (isInIslandOfSkulls) {
            roundScore = 0;
            int[] reRollPosition1 = {5, 6, 7};
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[5] = Constants.SKULL;
            diceRoll[6] = Constants.SKULL;
            diceRoll[7] = Constants.COIN;
            deductedPointsFromOpponents = -1 * score.calculateDeductedPoints(fortuneCard, diceRoll);
        }
        assertEquals(0, roundScore);
        assertEquals(-1400, deductedPointsFromOpponents);
    }

    @Test
    public void testRow111() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int deductedPointsFromOpponents = 0;
        boolean canContinue = false;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SKULLS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        boolean isInIslandOfSkulls = score.isInIslandOfSkulls(diceRoll, fortuneCard);
        if (isInIslandOfSkulls) {
            roundScore = 0;
            int[] reRollPosition1 = {3, 4, 5, 6, 7};
            diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
            diceRoll[3] = Constants.COIN;
            diceRoll[4] = Constants.COIN;
            diceRoll[5] = Constants.COIN;
            diceRoll[6] = Constants.COIN;
            diceRoll[7] = Constants.COIN;
            canContinue = dice.atLeastOneSkull(diceRoll, reRollPosition1);
            if (!canContinue) {
                deductedPointsFromOpponents = -1 * score.calculateDeductedPoints(fortuneCard, diceRoll);
            }
        }
        assertEquals(0, roundScore);
        assertEquals(-500, deductedPointsFromOpponents);
        assertEquals(false, canContinue);
    }

    // Test Sea Battles
    @Test
    public void testRow114() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int totalScore = 0;
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SWORD;
        boolean isDisqualified = score.isDisqualified(diceRoll, fortuneCard, true);
        if (isDisqualified) {
            roundScore = score.calculateScore(fortuneCard, diceRoll);
            totalScore += roundScore;
            if (roundScore < 0) {
                System.out.println("You suffered a deduction of " + roundScore);
            }
            if (totalScore < 0) {
                totalScore = 0;
            }
        }
        assertEquals(-300, roundScore);
        assertEquals(0, totalScore);
        assertEquals(true, isDisqualified);
    }

    @Test
    public void testRow115() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int totalScore = 0;
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.THREE_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SWORD;
        diceRoll[1] = Constants.SWORD;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {4, 5, 6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SKULL;
        boolean isDisqualified = score.isDisqualified(diceRoll, fortuneCard, false);
        if (isDisqualified) {
            roundScore = score.calculateScore(fortuneCard, diceRoll);
            totalScore += roundScore;
            if (roundScore < 0) {
                System.out.println("You suffered a deduction of " + roundScore);
            }
            if (totalScore < 0) {
                totalScore = 0;
            }
        }
        assertEquals(-500, roundScore);
        assertEquals(0, totalScore);
        assertEquals(true, isDisqualified);
    }

    @Test
    public void testRow116() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int totalScore = 0;
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.FOUR_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        boolean isDied = score.isDisqualified(diceRoll, fortuneCard, false);
        if (isDied) {
            roundScore = score.calculateScore(fortuneCard, diceRoll);
            totalScore += roundScore;
            if (roundScore < 0) {
                System.out.println("You suffered a deduction of " + roundScore);
            }
            if (totalScore < 0) {
                totalScore = 0;
            }
        }
        assertEquals(-1000, roundScore);
        assertEquals(0, totalScore);
        assertEquals(true, isDied);
    }

    @Test
    public void testRow117() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow119() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.TWO_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow120() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.THREE_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(800, roundScore);
    }

    @Test
    public void testRow122() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        int totalScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.THREE_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SKULL;
        int[] reRollPosition1 = {0, 1, 2, 3};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.SWORD;
        boolean isDied = score.isDisqualified(diceRoll, fortuneCard, false);
        if (isDied) {
            roundScore = score.calculateScore(fortuneCard, diceRoll);
            totalScore += roundScore;
            if (roundScore < 0) {
                System.out.println("You suffered a deduction of " + roundScore);
            }
            if (totalScore < 0) {
                totalScore = 0;
            }
        }
        assertEquals(-500, roundScore);
        assertEquals(0, totalScore);
        assertEquals(true, isDied);
    }

    @Test
    public void testRow123() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.FOUR_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1300, roundScore);
    }

    @Test
    public void testRow126() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.FOUR_SWORDS;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.DIAMOND;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition2 = {0, 1, 2};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[0] = Constants.SWORD;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1300, roundScore);
    }

}
