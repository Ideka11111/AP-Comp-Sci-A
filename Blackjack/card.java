package Blackjack;

public class card {
    private String suit;
    private int number;
    private boolean face;

    //you have 52 cards in a deck, choose one randomely but not too random because counting cards exists
    //deck should not include jokers, as that would be 53-54 cards and there are no jokers in blackjack

    //constructor for making each card
    //each card has a suit and a number varible attatched to it
    public card(String Suit, int Number) {
        suit = Suit;
        number = Number;

    }
    

    public boolean IsfaceCard() {
        //returns true if the specified card is a face card, returns false otherwise
        if (number >= 10) {
            face = true;
        }
        else {
            face = false;
        }

        return face;
    }

    public String Iswhatsuit() {
        
        return suit;
    }

    

}
