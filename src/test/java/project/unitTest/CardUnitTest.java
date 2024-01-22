package project.unitTest;

import junit.framework.TestCase;
import org.junit.Test;
import project.Card;
import project.Constants;

public class CardUnitTest extends TestCase {

    // test fortune card initialization
    @Test
    public void testInitializeCard() {
        Card card = new Card();
        String[] deck = new String[35];
        String[] initialDeckOfCards = card.initializeCards(deck);
        int chestNum = 0;
        int sorceressNum = 0;
        int captainNum = 0;
        int monkeyParrotNum = 0;
        int diamondNum = 0;
        int coinNum = 0;
        int twoSkullsNum = 0;
        int oneSkullsNum = 0;
        int twoSwordsNum = 0;
        int ThreeSwordsNum = 0;
        int fourSwordsNum = 0;
        for (int i = 0; i < initialDeckOfCards.length; i++) {
            if (initialDeckOfCards[i].equals(Constants.CHEST)) {
                chestNum++;
            } else if (initialDeckOfCards[i].equals(Constants.SORCERESS)) {
                sorceressNum++;
            } else if (initialDeckOfCards[i].equals(Constants.CAPTAIN)) {
                captainNum++;
            } else if (initialDeckOfCards[i].equals(Constants.MONKEY_AND_PARROT)) {
                monkeyParrotNum++;
            } else if (initialDeckOfCards[i].equals(Constants.DIAMOND_CARD)) {
                diamondNum++;
            } else if (initialDeckOfCards[i].equals(Constants.COIN_CARD)) {
                coinNum++;
            } else if (initialDeckOfCards[i].equals(Constants.TWO_SKULLS)) {
                twoSkullsNum++;
            } else if (initialDeckOfCards[i].equals(Constants.ONE_SKULL)) {
                oneSkullsNum++;
            } else if (initialDeckOfCards[i].equals(Constants.TWO_SWORDS)) {
                twoSwordsNum++;
            } else if (initialDeckOfCards[i].equals(Constants.THREE_SWORDS)) {
                ThreeSwordsNum++;
            } else if (initialDeckOfCards[i].equals(Constants.FOUR_SWORDS)) {
                fourSwordsNum++;
            }
        }
        int[] cardsNum = {chestNum, sorceressNum, captainNum, monkeyParrotNum, diamondNum, coinNum, twoSkullsNum, oneSkullsNum, twoSwordsNum, ThreeSwordsNum, fourSwordsNum};
        int[] expectedCardNum = {4, 4, 4, 4, 4, 4, 2, 3, 2, 2, 2};
        for (int i = 0; i < cardsNum.length; i++) {
            assertEquals(expectedCardNum[i], cardsNum[i]);
        }
    }

    // Test shuffleCards function
    @Test
    public void testShuffleCards() {
        Card card = new Card();
        String[] deck = new String[35];
        String[] initialDeckOfCards = card.initializeCards(deck);
        String[] shuffledCards = card.shuffleCards(initialDeckOfCards);
        int chestNum = 0;
        int sorceressNum = 0;
        int captainNum = 0;
        int monkeyParrotNum = 0;
        int diamondNum = 0;
        int coinNum = 0;
        int twoSkullsNum = 0;
        int oneSkullsNum = 0;
        int twoSwordsNum = 0;
        int ThreeSwordsNum = 0;
        int fourSwordsNum = 0;
        for (int i = 0; i < shuffledCards.length; i++) {
            if (shuffledCards[i].equals(Constants.CHEST)) {
                chestNum++;
            } else if (shuffledCards[i].equals(Constants.SORCERESS)) {
                sorceressNum++;
            } else if (shuffledCards[i].equals(Constants.CAPTAIN)) {
                captainNum++;
            } else if (shuffledCards[i].equals(Constants.MONKEY_AND_PARROT)) {
                monkeyParrotNum++;
            } else if (shuffledCards[i].equals(Constants.DIAMOND_CARD)) {
                diamondNum++;
            } else if (shuffledCards[i].equals(Constants.COIN_CARD)) {
                coinNum++;
            } else if (shuffledCards[i].equals(Constants.TWO_SKULLS)) {
                twoSkullsNum++;
            } else if (shuffledCards[i].equals(Constants.ONE_SKULL)) {
                oneSkullsNum++;
            } else if (shuffledCards[i].equals(Constants.TWO_SWORDS)) {
                twoSwordsNum++;
            } else if (shuffledCards[i].equals(Constants.THREE_SWORDS)) {
                ThreeSwordsNum++;
            } else if (shuffledCards[i].equals(Constants.FOUR_SWORDS)) {
                fourSwordsNum++;
            }
        }
        int[] cardsNum = {chestNum, sorceressNum, captainNum, monkeyParrotNum, diamondNum, coinNum, twoSkullsNum, oneSkullsNum, twoSwordsNum, ThreeSwordsNum, fourSwordsNum};
        int[] expectedCardNum = {4, 4, 4, 4, 4, 4, 2, 3, 2, 2, 2};
        for (int i = 0; i < cardsNum.length; i++) {
            assertEquals(expectedCardNum[i], cardsNum[i]);
        }
        assertEquals(35, shuffledCards.length);
    }

    // Test getDeckOfCards function
    @Test
    public void testGetDeckOfCards() {
        Card card = new Card();
        String[] cards = card.getDeckOfCards();
        int chestNum = 0;
        int sorceressNum = 0;
        int captainNum = 0;
        int monkeyParrotNum = 0;
        int diamondNum = 0;
        int coinNum = 0;
        int twoSkullsNum = 0;
        int oneSkullsNum = 0;
        int twoSwordsNum = 0;
        int ThreeSwordsNum = 0;
        int fourSwordsNum = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(Constants.CHEST)) {
                chestNum++;
            } else if (cards[i].equals(Constants.SORCERESS)) {
                sorceressNum++;
            } else if (cards[i].equals(Constants.CAPTAIN)) {
                captainNum++;
            } else if (cards[i].equals(Constants.MONKEY_AND_PARROT)) {
                monkeyParrotNum++;
            } else if (cards[i].equals(Constants.DIAMOND_CARD)) {
                diamondNum++;
            } else if (cards[i].equals(Constants.COIN_CARD)) {
                coinNum++;
            } else if (cards[i].equals(Constants.TWO_SKULLS)) {
                twoSkullsNum++;
            } else if (cards[i].equals(Constants.ONE_SKULL)) {
                oneSkullsNum++;
            } else if (cards[i].equals(Constants.TWO_SWORDS)) {
                twoSwordsNum++;
            } else if (cards[i].equals(Constants.THREE_SWORDS)) {
                ThreeSwordsNum++;
            } else if (cards[i].equals(Constants.FOUR_SWORDS)) {
                fourSwordsNum++;
            }
        }
        int[] cardsNum = {chestNum, sorceressNum, captainNum, monkeyParrotNum, diamondNum, coinNum, twoSkullsNum, oneSkullsNum, twoSwordsNum, ThreeSwordsNum, fourSwordsNum};
        int[] expectedCardNum = {4, 4, 4, 4, 4, 4, 2, 3, 2, 2, 2};
        for (int i = 0; i < cardsNum.length; i++) {
            assertEquals(expectedCardNum[i], cardsNum[i]);
        }
        assertEquals(35, cards.length);
    }

    // Test draw fortune card
    @Test
    public void testDrawFortuneCard() {
        Card card = new Card();
        String[] deckOfCards = card.getDeckOfCards();
        int index = (int) (Math.random() * 34);
        String fortuneCard = card.drawFortuneCard(deckOfCards, index);
        boolean isCardInDeck = false;
        for (int i = 0; i < deckOfCards.length; i++) {
            if (fortuneCard.equals(deckOfCards[i])) {
                isCardInDeck = true;
            }
        }
        assertEquals(true, isCardInDeck);
    }

}
