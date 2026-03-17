package Blackjack;

import java.util.*;



public class Deck {
    private String [] suits = {"Hearts","Diamonds","Clubs","Spades"};
    private int [] numbers = {1,2,3,4,5,6,7,8,9,10,10,10,10};
                            //1,2,3,4,5,6,7,8,9,10,11,12,13
    private String [] face = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    //ArrayList<Type> arrayListName = new ArrayList<Type>();
    //List<Object> stuff = new ArrayList<Object>();
    private List<card> Deck;



    public Deck() {
        Deck = new ArrayList<card> ();

        //for loop for looping through suits (1-4) [0-3]
        for (int s = 0; s < 4; s++) {
            //looping through numbers (1-13) [0-12] 
            for (int n = 0; n < 13; n++) {
                //
                Deck.add(new card(suits[s],numbers[n],face[n]));
            }
        }

        
    }

    public void shuffleDeck() {
        //shuffles the deck of 52
        //shuffle method uses a list so we use an array list for our deck
        Collections.shuffle(Deck);
    }

    public int getcardnumber(int index) {
        //returns the number of a specific card
        //pulls the number of a card in the deck at the index [index]
        return Deck.get(index).ISwhatnumber();
    }

    public String getcardsuit(int i) {
        //returns the suit of a specific card
        return Deck.get(i).ISwhatsuit();
    }

    public String getcardface(int i) {
        //returns the face of the card
        return Deck.get(i).Cardface();
    }

    public boolean isFaceCard(int i) {
        //returns true if card is face card, returns false otherwise
        return Deck.get(i).IsfaceCard();
    }
}
