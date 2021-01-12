/* Game.java
 * Purpose: This class declares all instance variables and defines all methods of the Game class, allowing for the creation and 
 * manipulation of Game objects. This class details most of the functions run in gameplay.
 * Written by: Randy Dang
 */
import java.util.*;
public class Game {
    
    //Instance variables representing essential aspects of a blackjack game.
    private Person player;
    private Person dealer;
    private Deck currentDeck;
    
    //Instance variables representing whether the player or dealer busted.
    private boolean didntBust;
    private boolean dealerDidntBust;
    
    //Constructor that creates the Game object. Sets instance variables based on inputs.
    public Game(Person p, Person d, Deck cd) {
        player = p;
        dealer = d;
        currentDeck = cd;
        didntBust = true;
        dealerDidntBust = true;
    }
    
    //Method called to execute gameplay.
    public String playGame(Person player, Person dealer, double bet) {
        //Creates deck of Cards and shuffles it.
        Deck cardDeck = new Deck();
        cardDeck.ShuffleDeck();
        
        //Uses cards in the deck to determine the player's hand and the dealer's hand. Calculates total and displays 
        //as appropriate.
        int i = 0;
        int total = 0;
        int dealerTotal = 0;
        String[] hand = {cardDeck.getCard(i), cardDeck.getCard(i + 1)};
        String[] dealerHand = {cardDeck.getCard(i + 2)};
        total += (cardDeck.getCardValue(i) + cardDeck.getCardValue(i + 1));
        dealerTotal += cardDeck.getCardValue(i + 2);
        System.out.println("YOUR HAND: " + Arrays.toString(hand));
        System.out.println("DEALER'S SHOWING: " + Arrays.toString(dealerHand));
        i += 3;
        
        //Asks if player wants to hit and executes gameplay as appropriate depending on the total in the player's and 
        //dealer's hand.
        boolean hit = promptHit();
        while (hit && didntBust) {
            //Adds card to player's hand.
            String[] hand2 = {cardDeck.getCard(i)};
            System.out.println("ADD CARD TO YOUR HAND: " + Arrays.toString(hand2));
            total += cardDeck.getCardValue(i);
            
            //If player's total is greater than 21, then the player busted.
            if (total > 21) {
                System.out.println("Bust!");
                didntBust = false;
                break;
            }
            
            //Asks if player wishes to hit again.
            hit = promptHit();
            i += 1;
        }
        
        //Displays dealer's hand and adds the next Card in the deck.
        System.out.println("DEALER'S HAND: " + Arrays.toString(dealerHand));
        while (dealerTotal < 17 && dealerDidntBust) {
            String[] dealerHand2 = {cardDeck.getCard(i)};
            System.out.println("ADD CARD TO DEALER'S HAND: " + Arrays.toString(dealerHand2));
            dealerTotal += cardDeck.getCardValue(i);
            i += 1;
            
            //Checks whether or not the dealer busted and executes gameplay accordingly.
            if (dealerTotal > 21) {
                dealerDidntBust = false;
            }
        }
        
        //Print appropriate message depending on who won the game and adjusts amount of money accordingly.
        if (!(didntBust)) {
            player.setAmountOfMoney(player.getAmountOfMoney() - bet);
            return "Dealer wins. You have " + player.getAmountOfMoney() + " dollars.";
        } else if (!(dealerDidntBust)) {
            player.setAmountOfMoney(player.getAmountOfMoney() + bet);
            return player.getName() + " wins. You have " + player.getAmountOfMoney() + " dollars.";
        } else if (total > dealerTotal) {
            player.setAmountOfMoney(player.getAmountOfMoney() + bet);
            return player.getName() + " wins. You have " + player.getAmountOfMoney() + " dollars.";
        } else if (total < dealerTotal) {
            player.setAmountOfMoney(player.getAmountOfMoney() - bet);
            return "Dealer wins. You have " + player.getAmountOfMoney() + " dollars.";
        } else {
            player.setAmountOfMoney(player.getAmountOfMoney());
            return "It was a tie. You have " + player.getAmountOfMoney() + " dollars.";
        }
    }
    
    //Method called to prompt player if they wish to hit, returning true if the player wishes to hit, false otherwise.
    public boolean promptHit() {
        System.out.println("Hit? (Y/N)");
        Scanner kbReader = new Scanner(System.in);
        String yesOrNo = kbReader.next();
        if (yesOrNo.equals("Y") || yesOrNo.equals("Yes") || yesOrNo.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }
}