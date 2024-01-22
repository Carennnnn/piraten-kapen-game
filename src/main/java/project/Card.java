package project;

import java.io.Serializable;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    String[] deck;

    // Initialize cards
    public String[] initializeCards(String[] deckOfCards) {
        for (int i = 0; i < 4; i++) {
            deckOfCards[i] = Constants.CHEST;
        }
        for (int i = 4; i < 8; i++) {
            deckOfCards[i] = Constants.SORCERESS;
        }
        for (int i = 8; i < 12; i++) {
            deckOfCards[i] = Constants.CAPTAIN;
        }
        for (int i = 12; i < 16; i++) {
            deckOfCards[i] = Constants.MONKEY_AND_PARROT;
        }
        for (int i = 16; i < 20; i++) {
            deckOfCards[i] = Constants.DIAMOND_CARD;
        }
        for (int i = 20; i < 24; i++) {
            deckOfCards[i] = Constants.COIN_CARD;
        }
        for (int i = 24; i < 26; i++) {
            deckOfCards[i] = Constants.TWO_SKULLS;
        }
        for (int i = 26; i < 29; i++) {
            deckOfCards[i] = Constants.ONE_SKULL;
        }
        for (int i = 29; i < 31; i++) {
            deckOfCards[i] = Constants.TWO_SWORDS;
        }
        for (int i = 31; i < 33; i++) {
            deckOfCards[i] = Constants.THREE_SWORDS;
        }
        for (int i = 33; i < 35; i++) {
            deckOfCards[i] = Constants.FOUR_SWORDS;
        }
        return deckOfCards;
    }

    // Shuffle cards
    public String[] shuffleCards(String[] deckOfCards) {
        for (int i = 0; i < deckOfCards.length; i++) {
            int index = i + (int) (Math.random() * (deckOfCards.length-i));
            String temp = deckOfCards[index];
            deckOfCards[index] = deckOfCards[i];
            deckOfCards[i] = temp;
        }
        return deckOfCards;
    }

    // Get a deck of fortune cards
    public String[] getDeckOfCards() {
        deck = new String[35];
        String[] initialDeck = initializeCards(deck);
        String[] shuffledCards = shuffleCards(initialDeck);
        return shuffledCards;
    }

    // Draw a fortune card from deck
    public String drawFortuneCard(String[] deck, int index) {
        return deck[index];
    }

    // Print current fortune card
    public void printCard(String card) {
        System.out.println("Fortune card: " + card);
    }

}
