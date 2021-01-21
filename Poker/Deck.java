public class Deck {

     private Card[] cards; // an array of cards
     private int top; // the index of the top of the deck
     private int numberCards = 0;

     // construct an instance of the Deck
     public Deck() {
          // make a 52 card deck here
          cards = new Card[52];
          top = 0;
          createDeck();
     }

     // create the actual deck of cards object
     private void createDeck() {
          // define an instance variable card of the Card class, to generate the cards
          Card card;

          // loop over the cards array to populate it with objects card of Card class
          for (int suit = 1; suit < 5; suit++) { // there are only 4 suits
              for (int rank = 1; rank < 14; rank++) { // altogether there are 13 ranks
                   card = new Card(suit, rank);
                   cards[numberCards] = card;
                   numberCards = numberCards + 1;
              }
          }
     }

     // "Everyday I'm shufflin'" - LMFAO
     public void shuffle() {
          // make a place holder card to store cards while shuffling
          Card tempCard;

          // loop over the deck to shuffle it up to 250 times (to make sure it's properly shuffled)
          for (int i = 1; i < 250; i++) {
              int rand = (int) (Math.random() * 52);
                tempCard = cards[0];
                cards[0] = cards[rand];
                cards[rand] = tempCard;
          }
     }

     public Card deal() {

          // see if the card on top is greater than 51
          // if it is, set 'top' and 'card' to 0
          if (top > 51) {
              top = 0;
              return new Card(0, 0);
          }

          // if not, increment the card on top and remove the top card
          else {
              top = top + 1;
              return cards[top - 1];
          }
     }
}
