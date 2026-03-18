package Blackjack;

import java.util.Scanner;

public class Main {
    private static int turn = 1;
    private static boolean bust;
    //
    private static Deck newDeck;
    private static player Dealer;
    private static player player1;

    
    public static void main(String[] args) {
        //creates a new deck for the game to use
        newDeck = new Deck();
        // how mnay times should the deck be shuffled?
        printdeck();


        //asks how many people are playing, makes that amount of player obj
        



        // blackjack, starts each player with two cards from the top of the shuffled deck
        startTheGame();
        

        while (bust == false) {
            hitorStand();
            turn += 1;
            checkbust();
        }
        
        


        
        // printshuffleprint();

    }

    public static void startTheGame() {
        //creates the players and issues each player 2 cards to start
        Dealer = new player();
        player1 = new player();

        player1.addCard(newDeck.TopCard());
        Dealer.addCard(newDeck.TopCard());
        player1.addCard(newDeck.TopCard());
        Dealer.addCard(newDeck.TopCard());

        // printdeck();
        System.out.println(player1.printhowmanyCards());
        System.out.println(Dealer.printhowmanyCards());

    }

    public static void checkbust() {
        if (Dealer.checkBust() == true) {
            bust = true;
            System.out.println("Dealer Busts, you Win.");
        }
        else if (player1.checkBust() == true) {
            bust = true;
            System.out.println("You Bust.");
        }
        else {
            bust = false;
        }
        
    }

    public static void hitorStand() {
        Scanner scan = new Scanner(System.in);
        String text = "";

        //tell the player(s) what each player has
        System.out.println("the dealer has a " + Dealer.sumofCards());
        System.out.println("you have a " + player1.sumofCards());

        //player to the laft of the dealer goes first

        //if dealer's turn
        if (turn % 2 == 0) {
            //if wants to hit
            if (text.equalsIgnoreCase("hit") || text.equalsIgnoreCase("yes") || text.equalsIgnoreCase("y")) {
                //add a card to dealer's hand
                Dealer.addCard(newDeck.TopCard());
            }
            //if doesn't hit
            else {
                //do nothing
            }
        }
        //if player's turn
        else {
            System.out.println("Would you like to hit?");
            text = scan.nextLine();
            //if wants to hit
            if (text.equalsIgnoreCase("hit") || text.equalsIgnoreCase("yes") || text.equalsIgnoreCase("y")) {
                //add a card to the player's hand
                player1.addCard(newDeck.TopCard());
            }
            //if doesn't hit
            else {
                //do nothing
            }
        }

    }

    public static void printdeck() {
        //this is for testing
        for (int i = 0; i < newDeck.printhowmanyCards(); i++) {

            System.out.println(newDeck.getcardnumber(i) + "    " + newDeck.getcardface(i) + " of " + newDeck.getcardsuit(i) + " " + newDeck.isFaceCard(i));   
        }
        System.out.println(newDeck.printhowmanyCards());
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
