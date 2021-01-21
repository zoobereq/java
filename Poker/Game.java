import java.util.*;
import java.lang.Integer;

public class Game {
     private Player p;
     private Deck cards;
     private ArrayList<Card> hand;

     public Game(String[] testHand) {

          // This constructor is to help test your code
          // use the contents of testHand to
          // make a hand for the player
          // use the following encoding for cards
          // c = clubs
          // d = diamonds
          // h = hearts
          // s = spades
          // 1-13 correspond to ace - king
          // example: s1 = ace of spades
          // example: testhand = {s1, s13, s12, s11, s10} = royal isFlush


          // instance variables
          p = new Player();
          cards = new Deck();

          // shuffle the cards
          cards.shuffle();
          currentHand(testHand);

          hand = new ArrayList<Card>(p.getHand());

          System.out.println(checkHand(hand));
     }

     public Game() {
          // This no-argument constructor is to actually play a normal game
          // class variables
          p = new Player();
          cards = new Deck();

          cards.shuffle();

          // now deal 5 cards
          for (int i = 1; i < 6; i++) {
              p.addCard(cards.deal());
          }

          hand = new ArrayList<Card>(p.getHand());
     }

     // this method should play the game
     public void play() {
          // local variables
          int choose;
          int select;
          String check;
          int tokens = 0;
          int tokenCost = 20;

          // Create a scanner for human input
          Scanner humanInput = new Scanner(System.in);

          // Welcome user to the game
          System.out.println("Hello!  Ready for some Poker?");

          do {
              System.out.println("You'll need tokens to play.  Each token costs $20.00.");
              System.out.println("How many tokens do you want to bet on? Choose between 1 and 5. ");

              tokens = humanInput.nextInt();
          } while (tokens < 1 || tokens > 5);

          // set the amount of the bet
          p.bets(tokenCost * tokens);
          System.out.println("You are betting: $" + (int) p.getBankroll()); // print out how much the human player is betting

          for (int j = 0; j < tokens; j++) {

              // use the Collections class to sort the cards in hand into ascending order
              // source:  https://www.geeksforgeeks.org/collections-sort-java-examples/

              Collections.sort(hand);
              // show the cards
              System.out.println("Here are the dealt cards:");
              for (Card card : hand) { // enhanced loop over and print the dealt cards
                   System.out.println(card);
              }

              do {
                   // human player decides how many cards to remove from the deck
                   System.out.print("How many cards would you like to remove? Enter a number between 1 and 5: ");

                   // human player inputs the number of cards to remove
                   choose = humanInput.nextInt();
              } while (choose < 1 || choose > 5);


              if (choose > 0) { // checks that human chose correctly
                   for (int i = 0; i < choose; i++) {
                        System.out.print("Which one of the dealt cards do you want to remove?  Enter a number betwene 1 and 5: ");

                        select = humanInput.nextInt();
                        p.removeCard(hand.get(select - 1));
                        p.addCard(cards.deal());
                   }
              }

              // initialize the hand variable to store an array of cards

              hand = new ArrayList<Card>(p.getHand());

              // show the cards that are left in hand
              System.out.println("Current cards in hand: ");

              // an enhanced loop over the array of cards to show the cards in hand
              for (Card card : hand) {
                   System.out.println(card);
              }

              // call checkHand on hand and store the value in the local check variable
              check = checkHand(hand);
              System.out.println("The outcome of the hand: " + check);
          }

          System.out.printf("You have won $ " + (int) p.getBankroll());
     }

     // check the cards in the hand to see if they make up:
     // royal flush, straight flush, four of a kind, full house, straight, three of a kind, two pairs, one pair
     // or if the hand is crappy (none of the above)

     public String checkHand(ArrayList<Card> hand) {
     // this method should take an ArrayList of cards
		 // as input and then determine what evaluates to and
		 // return that as a String

          if (royalFlush(hand)) {
              p.winnings(250);
              return "Royal Flush";
          }

          else if (straightFlush(hand)) {
              p.winnings(50);
              return "Straight Flush";
          }

          else if (fourOfAKind(hand)) {
              p.winnings(25);
              return "Four of a Kind";

          }

          else if (fullHouse(hand)) {
              p.winnings(6);
              return "Full House";
          }

          else if (flush(hand)) {
              p.winnings(5);
              return "Flush";
          }

          else if (straight(hand)) {
              p.winnings(4);
              return "Straight";
          }

          else if (threeOfAKind(hand)) {
              p.winnings(3);
              return "Three of a kind";
          }

          else if (twoPairs(hand)) {
              p.winnings(2);
              return "Two Pairs";
          }

          else if (onePair(hand) == 1) {
              p.winnings(1);
              return "One Pair";
          }

          else {
              return "Not even a pair :(";
          }
     }

     // check if the hand contains three of a kind and return the count of the pairs.
     // If you get 1 in return, you have a pair.

     private int onePair(ArrayList<Card> hand) {
          Card tempCard;
          int i = 1;
          int numberPairs = 0;

          // loops over all elements of the hand
          while (i < hand.size()) {
              tempCard = hand.get(i - 1);
              if (tempCard.sameRank(hand.get(i))) {
                   i++;
                   numberPairs++;
              }
              i++;
          }

          // return how many pairs were found
          return numberPairs;
     }

     // check if the hand contains two pairs.
     // if the above is the case, return True.
     private boolean twoPairs(ArrayList<Card> hand) {
          if (onePair(hand) == 2) { // use the onePair method to see if you have two of those
              return true;
          }

          else {
              return false;
          }
     }

     // check if you have three cards of same kind.
     // return True if you do.
     private boolean threeOfAKind(ArrayList<Card> hand) {
          if (onePair(hand) == 0) { // make sure you don't have any pairs first
              return false;
          }

          else if (hand.get(0).sameRank(hand.get(2)) || hand.get(1).sameRank(hand.get(3)) || hand.get(2).sameRank(hand.get(4))) {
              return true;
          }

          else {
              return false;
          }
     }

     // check for the straight (5 consecutive cards in a row)
     // return True, if you have it

     private boolean straight(ArrayList<Card> hand) {
          // get the values
          Card firstCard = hand.get(0);
          Card secondCard = hand.get(1);
          Card fifthCard = hand.get(4);

          // get the value of one pair
          if (onePair(hand) > 0) {
              return false;
          }

          // get the rank difference between the first and fifth card
          else if (fifthCard.differentRank(firstCard) == 4) {
              return true;
          }

          // check for the rank values
          else if (firstCard.getRank() == 1 && fifthCard.getRank() == 13 && secondCard.getRank() == 10) {
              return true;
          }

          // otherwise return false
          else {
              return false;
          }
     }

     // check if the cards are of same suit.
     // return True if they are

     public boolean flush(ArrayList<Card> hand) {
          // first see if you have a pair
          if (onePair(hand) > 0) {
              return false;
          }

          // if you don't have a pair, check for the flush

          else {
              int i = 1;
              for (Card card : hand) {
                   if (!card.sameSuit(hand.get(i))) {
                        return false;
                   }

                   if (i < hand.size() - 1) {
                        i++;
                   }
              }

              return true;
          }
     }

     // check for a three and a pair
     // if found, return True
     public boolean fullHouse(ArrayList<Card> hand) {
          if (onePair(hand) == 2 && threeOfAKind(hand) == true && fourOfAKind(hand) == false) {
              return true;
          }

          else {
              return false;
          }
     }

     // check for four cards of same kind
     // if found, return True
     public boolean fourOfAKind(ArrayList<Card> hand) {
          if (onePair(hand) == 2 && threeOfAKind(hand) == true) {
              if (hand.get(0).sameRank(hand.get(3)) || hand.get(1).sameRank(hand.get(4))) {
                   return true;
              }
          }
          return false;
     }

     // check for a straight and a flush
     // if found, return True
     public boolean straightFlush(ArrayList<Card> hand) {
          if (flush(hand) && straight(hand)) {
              return true;
          }
          else {
              return false;
          }
     }

     // check for royal flush
     public boolean royalFlush(ArrayList<Card> hand) {
          if (straightFlush(hand) && hand.get(0).getRank() == 1) {
              return true;
          }

          else {
              return false;
          }
     }

     // assemple the cards at hand
     public void currentHand(String[] testHand) {

          char suitCharacter;
          int suit;
          int rank = 1;
          String value;

          for (int i = 0; i < 5; i++) {
              suitCharacter = testHand[i].charAt(0);
              value = testHand[i].substring(1);
              rank = Integer.parseInt(value);
              switch (suitCharacter) {
                  case 'c':
                      suit = 1;
                      break;

                  case 'd':
                      suit = 2;
                      break;

                  case 'h':
                    suit = 3;
                    break;

                  default:
                    suit = 4;
              }

              // add cards to p

              p.addCard(new Card(suit, rank));
          }
     }
}
