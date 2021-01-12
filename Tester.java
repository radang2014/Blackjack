/* Tester.java
 * Purpose: This class contains code that simulates the game of Blackjack, creating and using objects of other classes in 
 * doing so. Players begin with an inputted amount of money and place bets for each game. Users should run the main 
 * method of this class to play the game.
 * Written by: Randy Dang
 */
import java.io.*;
import java.util.*;
public class Tester {
    
    public static void main(String args[]) {
        //Prompts user for name, starting amount of money, and user's bet.
        System.out.println("What is your name?");
        Scanner kbReader = new Scanner(System.in);
        String name = kbReader.next();
        System.out.println("How much money are you playing with today?");
        double money = kbReader.nextDouble();
        double bet = money + 1;
        while (bet > money || bet <= 0) {
            System.out.println("Place your bet: ");
            bet = kbReader.nextDouble();
            
            //Error checks on inputted bet.
            if (bet > money) {
                System.out.println("ERROR: Bet cannot be more than money");
            }
            if (bet <= 0) {
                System.out.println("Bet must be a positive number");
            }
        }
        
        //Creates Person objects representing the player and dealer and a Deck of Cards.
        Person player = new Person(name, money, 0);
        Person dealer = new Person("Dealer", 0, 0);
        player.setAmountOfMoney(money);
        Deck deck = new Deck();
        deck.ShuffleDeck();
        
        //Gameplay loop; continues playing Blackjack until the user wishes to stop playing.
        boolean playAgain = true;
        while (playAgain) {
            //Create a Game object and play one game of Blackjack.
            Game currentGame = new Game(player, dealer, deck);
            System.out.println(currentGame.playGame(player, dealer, bet));
            
            //Prompts user for whether or not they wish to play another game and continues accordingly.
            System.out.println("Play again? (Y/N)");
            String s = kbReader.next();
            if (!(s.equals("Y") || s.equals("Yes") || s.equals("yes"))) {
                playAgain = false;
            } 
            else {
                //Prompts user to enter another bet and shuffles Deck.
                bet = money+0.001;
                while (bet>money || bet<0) {
                    System.out.println("Place your bet: ");
                    bet = kbReader.nextDouble();
                    
                    //Error checks on inputted bet.
                    if (bet>money) {
                        System.out.println("ERROR: Bet cannot be more than money");
                    }
                    if (bet<0) {
                        System.out.println("Bet cannot be negative");
                    }
                }
                deck.ShuffleDeck();
            }
        }
    }
}