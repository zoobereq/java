/*****************************************
 * A template for a computer Nim player
 ****************************************/
import java.util.Random;

 // create the Computer class template
public class Computer {

    // declare instance variables for the Computer class
  private int choice; // stores the number of marbles withdrawn from the pile
  private int mode; // 1 will be dumb, and 2 will be smart
  private Random randomNumber; // generates a random number

    // create a Computer object instance
  public Computer(int m) {
    mode = m;
    choice = -1;
    randomNumber = new Random();
  }

    // declare an accessor method that will return the value store in the choice variable
  public int getChoice() {
    return choice;
  }

    // declare a mutator method that takes the value of marblesLeft
  public void move(int marblesLeft) {
    if (marblesLeft == 1) { // this make sure that a player does't select more marbles than 1 when only 1 marble is left
      choice = 1; // sets the number of marbles withdrawn to 1
    }

    else if (mode == 1) { // play in the dumb mode
      choice = randomNumber.nextInt(marblesLeft / 2) + 1; // computer takes a random legal value from the pile
    }

    else { // smart mode
      int n = 1; // the computer takes off enough marbles to make the size of the pile a power of two minus one.

      // this portion of the code has caused me a lot of trouble, and I'm not sure if it is correct
      while (n <= marblesLeft) {
        n = 2 * n;
      }

      if (marblesLeft + 1 == n) {
        choice = randomNumber.nextInt(marblesLeft / 2) + 1;
      }

      else {
        choice = marblesLeft - n / 2 + 1;
      }
    }

    System.out.println("Your oponent has drawn: " + choice);
  }
}
