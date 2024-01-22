package project.acceptanceTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.Card;
import project.Constants;
import project.Dice;
import project.Score;

public class Part1AcceptanceTest extends TestCase {

    @Test
    public void testRow45() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(0, roundScore);
    }

    @Test
    public void testRow46() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {5, 6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(0, roundScore);
    }

    @Test
    public void testRow47() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(0, roundScore);
    }

    @Test
    public void testRow49() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {5, 6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.MONKEY;
        int[] reRollPosition2 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.MONKEY;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(0, roundScore);
    }

    @Test
    public void testRow51() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        int[] reRollPosition1 = {1, 2};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        int[] reRollPosition2 = {3, 4, 5};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(4800, roundScore);
    }

    @Test
    public void testRow52() {
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
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.DIAMOND;
        diceRoll[5] = Constants.DIAMOND;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(800, roundScore);
    }

    @Test
    public void testRow53() {
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
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.MONKEY;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(300, roundScore);
    }

    @Test
    public void testRow54() {
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
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(300, roundScore);
    }

    @Test
    public void testRow55() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.DIAMOND;
        diceRoll[1] = Constants.DIAMOND;
        diceRoll[2] = Constants.DIAMOND;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow56() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.DIAMOND_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.COIN;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.SKULL;
        diceRoll[5] = Constants.SKULL;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(700, roundScore);
    }

    @Test
    public void testRow57() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SWORD;
        diceRoll[1] = Constants.SWORD;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(400, roundScore);
    }

    @Test
    public void testRow58() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {3, 4};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(800, roundScore);
    }

    @Test
    public void testRow59() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CAPTAIN;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {3, 4};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1200, roundScore);
    }

    @Test
    public void testRow61() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.MONKEY;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {1, 2};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[1] = Constants.SKULL;
        diceRoll[2] = Constants.SWORD;
        int[] reRollPosition2 = {3, 4};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition2);
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.MONKEY;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(600, roundScore);
    }

    @Test
    public void testRow62() {
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
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.MONKEY;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(1100, roundScore);
    }

    @Test
    public void testRow63() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.PARROT;
        diceRoll[1] = Constants.PARROT;
        diceRoll[2] = Constants.PARROT;
        diceRoll[3] = Constants.PARROT;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.PARROT;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(2100, roundScore);
    }

    @Test
    public void testRow64() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.COIN;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(5400, roundScore);
    }

    @Test
    public void testRow65() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.DIAMOND_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.COIN;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.COIN;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.COIN;
        diceRoll[7] = Constants.COIN;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(5400, roundScore);
    }

    @Test
    public void testRow66() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.CAPTAIN;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SWORD;
        diceRoll[1] = Constants.SWORD;
        diceRoll[2] = Constants.SWORD;
        diceRoll[3] = Constants.SWORD;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(9000, roundScore);
    }

    @Test
    public void testRow67() {
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
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.MONKEY;
        diceRoll[5] = Constants.MONKEY;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.MONKEY;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(4600, roundScore);
    }

    @Test
    public void testRow68() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.DIAMOND_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.MONKEY;
        diceRoll[1] = Constants.MONKEY;
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.PARROT;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[6] = Constants.DIAMOND;
        diceRoll[7] = Constants.DIAMOND;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(400, roundScore);
    }

    @Test
    public void testRow69() {
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
        diceRoll[2] = Constants.SKULL;
        diceRoll[3] = Constants.SKULL;
        diceRoll[4] = Constants.SWORD;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.DIAMOND;
        diceRoll[7] = Constants.PARROT;
        int[] reRollPosition1 = {0, 1};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[0] = Constants.DIAMOND;
        diceRoll[1] = Constants.DIAMOND;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow70() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.COIN_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {5, 6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(600, roundScore);
    }

    @Test
    public void testRow71() {
        Card card = new Card();
        Dice dice = new Dice();
        Score score = new Score();
        int roundScore = 0;
        String[] deckOfCards = card.getDeckOfCards();
        String fortuneCard = card.drawFortuneCard(deckOfCards, 34);
        fortuneCard = Constants.DIAMOND_CARD;
        String[] diceRoll = dice.rollAllDice();
        diceRoll[0] = Constants.SKULL;
        diceRoll[1] = Constants.COIN;
        diceRoll[2] = Constants.COIN;
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.PARROT;
        diceRoll[5] = Constants.SWORD;
        diceRoll[6] = Constants.SWORD;
        diceRoll[7] = Constants.SWORD;
        int[] reRollPosition1 = {5, 6, 7};
        diceRoll = dice.reRollDice(diceRoll, reRollPosition1);
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.MONKEY;
        diceRoll[7] = Constants.PARROT;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(500, roundScore);
    }

    @Test
    public void testRow72() {
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
        diceRoll[3] = Constants.MONKEY;
        diceRoll[4] = Constants.COIN;
        diceRoll[5] = Constants.COIN;
        diceRoll[6] = Constants.SKULL;
        diceRoll[7] = Constants.SKULL;
        roundScore = score.calculateScore(fortuneCard, diceRoll);
        assertEquals(600, roundScore);
    }

}
