public class Card implements Comparable<Card> {

     private int suit; // use integers 1-4 to encode the suit
     private int rank; // use integers 1-13 to encode the rank

     // construct the Card class that will take two integers, s and v.
     // the integers passed through the constructor will be stored in local instance variables.
     public Card(int s, int v) {
          // make a card with suit s and value v
          suit = s;
          rank = v;
     }

     // compare the values of two cards
     // return a positive, negative, or zero depending on the outcome of the comparison
     public int compareTo(Card c) {
          // use this method to compare cards so they
          // may be easily sorted
          if (sameRank(c)) {
              return this.getSuit() - c.getSuit();
          }
          else {
              return differentRank(c);
          }
     }

     // return the card with a value (rank) of a symbol (suit)
     public String toString() {
          // Use this method to easily print a Card object
          String returnedCard;
          String symbolSuit = "0";
          String valueRank = "0";

          // set the suit
          if (suit == 1) {
              symbolSuit = "Spades ♤";
          }

          else if (suit == 2) {
              symbolSuit = "Hearts ♡";
          }

          else if (suit == 3) {
              symbolSuit = "Diamonds ♢";
          }

          else {
              symbolSuit = "Clubs ♧";
          }

          // set the rank
          if (rank > 1 && rank < 11) { // takes care of the numbered ranks
              valueRank = "" + rank;
          }

          else if (rank == 1) {
              valueRank = "Ace";
          }

          else if (rank == 11) {
              valueRank = "Jack";
          }

          else if (rank == 12) {
              valueRank = "Queen";
          }

          else if (rank == 13) {
              valueRank = "King";
          }


          returnedCard = valueRank + " of " + symbolSuit;
          return returnedCard;
     }


     // get the rank
     public int getRank() {
          return rank;
     }

     // get the suit
     public int getSuit() {
          return suit;
     }

     // compare the ranks of the two cards
     // if they are the same, return True
     public boolean sameRank(Card c) {
          return this.getRank() == c.getRank();
     }

     // compare the suits of the two cards
     // if they are the same, return True
     public boolean sameSuit(Card c) {
          return this.getSuit() == c.getSuit();
     }

     // compute the difference between the ranks of the two cards
     public int differentRank(Card c) {
          return this.getRank() - c.getRank();
     }
}
