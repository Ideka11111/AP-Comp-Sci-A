package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class player {
    private int sum;
    //hand list
    private List<card> Hand;

    //constructor
    public player() {
        Hand = new ArrayList<card> ();



    }

    public boolean checkBust() {
            // System.out.println(sumofCards());
            if (sumofCards() > 21) {
                return true;
            }
            else {
                return false;
            }
        }

    public void addCard(card Card) {
        //adds a card to the player's hand
        Hand.add(Card);
    }

    public int sumofCards() {
        sum = 0;
        //returns the sum of the cards in the hand
        for (int i=0; i < Hand.size(); i++) {
            sum += Hand.get(i).ISwhatnumber();
        }
        return sum;
    }

    public void resetSum() {
        sum = 0;
    }

    public int getcardnumber(int index) {
        //returns the number of a specific card
        //pulls the number of a card in the Hand at the index [index]
        return Hand.get(index).ISwhatnumber();
    }

    public String getcardsuit(int i) {
        //returns the suit of a specific card
        return Hand.get(i).ISwhatsuit();
    }

    public String getcardface(int i) {
        //returns the face of the card
        return Hand.get(i).Cardface();
    }

    public boolean isFaceCard(int i) {
        //returns true if card is face card, returns false otherwise
        return Hand.get(i).IsfaceCard();
    }

    public int printhowmanyCards() {
        //returns how many cards are in the Hand
        return Hand.size();
    }

    
}
