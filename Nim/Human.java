/*****************************************
 * A template for a Human Nim player
 ****************************************/
import java.util.Scanner;

// create the Human class template
public class Human {
  
  // declare instance variables and their types
 private int choice;
 private Scanner input;

  // construct a Human object instance
 public Human() {
   input = new Scanner(System.in);
   choice = -1;
 }

  // declare the 'move' mutator method accepting user input and storing it in the variable 'choice'
 public void move() {
   System.out.println("How many marbles do you wager? Choose wisely: ");
   choice = input.nextInt();
 }

  // declare the getChoice accessor method returning the value stored in the choice variable
 public int getChoice() {
   return choice;
 }

}
