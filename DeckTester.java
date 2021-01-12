/* DeckTester.java
 * Purpose: This file allows for testing of the Deck class to ensure that methods work properly.
 * Written by: Randy Dang
 */
import java.util.*;
public class DeckTester {
    
    public static void main(String args[]) {
        //Tests several methods of the Deck class.
        Deck cardDeck = new Deck();
        System.out.println(Arrays.toString(cardDeck.getCardDeck()));
        cardDeck.ShuffleDeck();
        System.out.println(Arrays.toString(cardDeck.getCardDeck()));
    }
}