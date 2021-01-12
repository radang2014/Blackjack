/* Card.java
 * Purpose: This class declares all instance variables and defines all methods of the Card class, allowing for the 
 * creation and manipulation of Card objects. In the context of the Blackjack game, Cards are used by both the 
 * player and the dealer to try to get a total as close to 21 as possible without busting.
 * Written by: Randy Dang
 */
public class Card {
    
    //Instance variables representing aspects of a Card.
    private String suit;
    private String name;
    private int number;
    
    //Constructor that creates Card object and sets instance variables to inputted values.
    public Card(String s, String n, int nm) {
        suit = s;
        name = n;
        number = nm;
    }
    
    //Accessor for the name of the card, which is the Card's number or letter followed by its suit.
    public String getCardName() {
        return name;
    }
    
    //Accessor for the value of the card in terms of the Person's progress toward 21.
    public int getCardValue() {
        return number;
    }
    
    //Prints the values of the instance variables of the Card in a readable format.
    public String toString() {
        return name + " is under the suit " + suit + " and has value " + number;
    }
    
}