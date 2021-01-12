/* Deck.java
 * Purpose: This class declares a deck of Cards (represented by an array) and defines all methods of the Deck class, 
 * allowing for the creation and manipulation of Deck objects. In the context of Blackjack, the player and dealer would
 * pull from the Deck represented by an instance of this class.
 * Written by: Randy Dang
 */
public class Deck {
    
    //Instance variable representing the deck, which is an array of Cards.
    private Card[] cardDeck;
    
    //Constructor creating the deck of Cards, calling the Card constructor for each Card that is created.
    public Deck() {
        //Sets cardDeck to an array of 52 Cards.
        cardDeck = new Card[52];
        
        //Fills the cardDeck with 52 unique cards.
        for (int i = 0; i < 4; i++) {
            String suit = "";
            if (i == 0) {
                suit = "H";
            }
            else if (i == 1) {
                suit = "S";
            }
            else if (i == 2) {
                suit = "D";
            }
            else if (i == 3) {
                suit = "C";
            }
            for (int j = 0; j < 13; j++) {
                int number = j + 2;
                String cardName = Integer.toString(number);
                if (number == 11) {
                    cardName = "A";
                }
                else if (number == 12) {
                    cardName = "J";
                    number = 10;
                }
                else if (number == 13) {
                    cardName = "Q";
                    number = 10;
                }
                else if (number == 14) {
                    cardName = "K";
                    number = 10;
                }
                
                //Calls the Card constructor for each unique Card in the Deck.
                cardDeck[13 * i + j] = new Card(suit, cardName + suit, number);
            }
        }
    }
    
    //Accessor for the array of Cards representing the Deck.
    public Card[] getCardDeck() {
        return cardDeck;
    }
    
    //Accessor for the name of a specific Card in the array, identified by the inputted index.
    public String getCard(int i) {
        if (i>=52) {
            i-=52;
        }
        return cardDeck[i].getCardName();
    }
    
    //Accessor for the numerical value of a specific Card in the array, identified by the inputted index.
    public int getCardValue(int i) {
        if (i>=52) {
            i-=52;
        }
        return cardDeck[i].getCardValue();
    }
    
    //Method that shuffles the deck of Cards.
    public void ShuffleDeck() {
        //Declares a new, empty array of Cards.
        Card[] result = new Card[cardDeck.length];
        
        //Populates empty array with Cards from the cardDeck array in a random order.
        for (int i = 0; i<cardDeck.length; i+=0) {
            int random = (int)(Math.random()*52);
            if (!(cardDeck[random]==null)) {
                result[i] = cardDeck[random];
                cardDeck[random] = null;
                i++;
            }
        }
        
        //Sets the cardDeck array to the filled result array.
        cardDeck = result;
    }
}