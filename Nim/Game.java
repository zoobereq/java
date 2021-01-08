/*****************************************
 * A template for a Nim game
 ****************************************/
import java.util.Random;

// create the Game class template
public class Game {

  // declare the instance variables
 private int marbles; // stores the number of marbles
 private Human humanPlayer; // a human player object of the Human class
 private Computer computerPlayer; // a compuer player object of the Computer class
 private Random randomNumber; // a random number

 public Game(int difficulty) {
   randomNumber = new Random(); //create a Random class object
   marbles = randomNumber.nextInt(91)+10; //generate a pile that is at least 10 and at most 100 marbles

   System.out.println("Behold! There are " + marbles + " marbles in the rickle.");
    computerPlayer = new Computer(difficulty); // create the computer player that takes user-defined difficutulty (1 or 2)
    humanPlayer = new Human(); // create a player cotrolled by a human
 }

 // provide the updated size of the pile
 public void currentSize() {
   System.out.println("There are now " + marbles + " marbles left in the rickle.");
 }

 // declare a mutator play method
 public void play() {
   int whosFirst = randomNumber.nextInt(2); // randomly generates an integer (0 or 1).  If 0 is generated, compuer goes first.
   int winner = 0; // tracks the winner. 1 for computer, and 0 for human.  To keep machines in check, humans will win by default.

   System.out.println("If 0 is cast, your opponent will move first. Otherwise you make thy bidding: " + whosFirst); // prints who goes first

   if (whosFirst == 0) { // a scenario where computer gets to go first
     computerPlayer.move(marbles);
     marbles = marbles - computerPlayer.getChoice();
   }

   currentSize();

   while (marbles != 0) { // always make sure that there are marbles left in the pile!
     humanPlayer.move();
     marbles = marbles - humanPlayer.getChoice();

     currentSize();

     if (marbles == 0) {
       winner = 1; // computer wins
     }

     else {
       computerPlayer.move(marbles);
       marbles = marbles - computerPlayer.getChoice();
     }

     currentSize();
   }

   if (winner == 1) {
     System.out.println("Woe unto you! You have failed!");
   }

   else {
     System.out.println("Flawless victory!");
   }
 }
}
