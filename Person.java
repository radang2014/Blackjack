/* Person.java
 * Purpose: This class declares all instance variables and defines all methods of the Person class, allowing for the 
 * creation and manipulation of Person objects. In the context of Blackjack, the player and the dealer are both Person 
 * objects.
 * Written by: Randy Dang
 */
public class Person {
    
    //Instance variables characterizing the Person.
    private String name;
    private double amountOfMoney;
    private int numGamesWon;
    
    //Constructor creating Person object. Sets instance variables based on inputs.
    public Person(String s, double d, int n) {
        name = s;
        amountOfMoney = d;
        numGamesWon = n;
    }
    
    //Mutator for instance variable representing number of games the Person won.
    public void setGamesWon(int n) {
        numGamesWon = n;
    }
    
    //Mutator for instance variable representing the amount of money the Person has.
    public void setAmountOfMoney(double d) {
        amountOfMoney = d;
    }
    
    //Accessor for instance variable representing the amount of money the Person has.
    public double getAmountOfMoney() {
        return amountOfMoney;
    }
    
    //Accessor for instance variable representing the name of the Person.
    public String getName() {
        return name;
    }
    
    //Prints the values of the instance variables of the Person in a readable format.
    public String toString() {
        return name + " has " + amountOfMoney + " dollars and has won " + numGamesWon + " games.";
    }
}