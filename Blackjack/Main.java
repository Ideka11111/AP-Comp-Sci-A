package Blackjack;

public class Main {
    //should i stablish 52 card objects in a (deck) array
    //or should i make a (Deck) class or astablish a method in card that makes a deck
    private static Deck newDeck;

    
    public static void main(String[] args) {
        // blackjack, starts each player with two cards
        
        newDeck = new Deck();

        //this is for testing
        for (int i = 0; i <52; i++) {

            System.out.println(newDeck.getcardnumber(i) + "    " + newDeck.getcardface(i) + " of " + newDeck.getcardsuit(i) + " " + newDeck.isFaceCard(i));
        }
        // printshuffleprint();



    }



    public static void printshuffleprint() {
        //prints deck, shuffles and then prints again, for testing purposes
        for (int i = 0; i <52; i++) {
            System.out.println(newDeck.getcardnumber(i) + "    " + newDeck.getcardface(i) + " of " + newDeck.getcardsuit(i));
        }

        newDeck.shuffleDeck();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");


        for (int i = 0; i <52; i++) {
            System.out.println(newDeck.getcardnumber(i) + "    " + newDeck.getcardface(i) + " of " + newDeck.getcardsuit(i));
        }
    }

} 
