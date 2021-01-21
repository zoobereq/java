import java.util.ArrayList;

public class Player {
     private ArrayList<Card> hand; // the player's cards
     private double bankroll;
     private double bet;

     // create a player here
     public Player() {
          bankroll = 0;
          hand = new ArrayList<Card>();
     }

     // add the card c to the player's hand
     public void addCard(Card c) {
          hand.add(c);
          bankroll = bankroll + 1;
     }

     // remove the card c from the player's hand
     public void removeCard(Card c) {
          if (bankroll > 0) {
              hand.remove(c);
              bankroll = bankroll - 1;
          }
     }

     // player makes a bet
     public void bets(double amount) {
          bankroll = amount;
     }

     //	adjust bankroll if player wins
     public void winnings(double odds) {
          bankroll = bankroll + odds;
     }

     // return current balance of bankroll
     public double getBankroll() {
          return bankroll;
     }

     // determine the cards in the hand
     public ArrayList<Card> getHand() {
          return hand;
     }
}
