package Blackjack;

import java.util.Scanner;

public class Main {
    private static boolean GameStarted = false;
    private static int turn = 1;
    private static boolean bust;
    //
    private static Deck newDeck;
    private static player Dealer;
    private static player player1;
    private static player player2;
    private static player player3;
    private static player player4;
    private static String name1 = "player1";
    
    public static void main(String[] args) {
        
        //asks how many people are playing, makes that amount of player obj

    

        while (bust == false) {
            if (GameStarted == false) {
                //creates a new deck for the game to use and shuffles it
                makeNewDeck(4);
                //prints the deck for testing
                // printdeck();
                //starts each player with two cards from the top of the shuffled deck
                startTheGame();
            }
            hitorStand();
            System.out.println("");
            //for testing 
            // System.out.println(turn + "nd turn");
            // System.out.println("dealer has " + Dealer.printhowmanyCards() + " cards");
            // System.out.println("player1 has " + player1.printhowmanyCards() + " cards");
            checkbust();
            

            //how do i say if bust == true, then bust = false, but only after the game has ended
        }

        //
    }

    //makes a new deck and shuffles it [n] times
    public static void makeNewDeck(int n) {
        //creates a new deck
        newDeck = new Deck();
        // how mnay times should the deck be shuffled?
        for (int i = 0; i < n; i++) {
            newDeck.shuffleDeck();
        }
    }

    //creates the dealer and player and adds two cards into their hands in the correct order
    public static void startTheGame() {
        //creates the players and issues each player 2 cards to start
        Dealer = new player();
        player1 = new player();

        player1.addCard(newDeck.TopCard());
        Dealer.addCard(newDeck.TopCard());
        player1.addCard(newDeck.TopCard());
        Dealer.addCard(newDeck.TopCard());

        //was for testing
        // printdeck();
        // System.out.println(player1.printhowmanyCards());
        // System.out.println(Dealer.printhowmanyCards());

        //declare that the game is started
        GameStarted = true;
    }

    //if want to let more players play, add more startgame methods with parameters and hardcode each senario
    //connect the startgame method to makeNewDeck

    //checks if draw or bust
    public static void checkbust() {
        if (Dealer.checkBust() == true) {
            bust = true;
            System.out.println("the dealer has a " + Dealer.sumofCards());
            System.out.println("you have a " + player1.sumofCards());
            System.out.println("Dealer Busts, you Win.");
        }
        else if (player1.checkBust() == true) {
            bust = true;
            System.out.println("the dealer has a " + Dealer.sumofCards());
            System.out.println("you have a " + player1.sumofCards());
            System.out.println("You Bust.");
        }
        //if win for player is in hitorstand method

        //if draw is also in hitorstand method

        // else {
        //     bust = false;
        // }
        
    }

    //if player's turn, asks if they wanna hit & adds a card if yes
    //if dealer's turn, hits on a 16 or less, stands on a 17 or more
    public static void hitorStand() {
        Scanner scan = new Scanner(System.in);
        String text = "";

        //tell the player(s) what each player has
        System.out.println("the dealer has a " + Dealer.sumofCards());
        System.out.println("you have a " + player1.sumofCards());

        //player to the laft of the dealer goes first


        //if dealer's turn
        if (turn % 2 == 0) {
            //dealer hits on a 16 or less and stands on a 17 or more 
            if (Dealer.sumofCards() < 17) {
                //hit - (add a card to dealer's hand)
                //also if dealer drew a card last turn, say which card he drew
                System.out.println("It's the Dealer's turn, he hits.");
                scan.nextLine();
                Dealer.addCard(newDeck.TopCard("Dealer"));
            }
            //if a 17 or more, don't hit
            else {
                if (bust == false) {
                    //if draw
                    if (player1.sumofCards() == Dealer.sumofCards()) {
                        bust = true;
                        // System.out.println("the dealer has a " + Dealer.sumofCards());
                        // System.out.println("you have a " + player1.sumofCards());
                        System.out.println("You Draw."); 
                    }
                    //if win
                    else if (player1.sumofCards() > Dealer.sumofCards()) {
                        if (Dealer.sumofCards() >= 17 && Dealer.sumofCards() <= 21) {
                            bust = true;
                            // System.out.println("the dealer has a " + Dealer.sumofCards());
                            // System.out.println("you have a " + player1.sumofCards());
                            System.out.println("You Win.");
                        }
                    }
                    else {
                        turn +=1;
                        System.out.println("Dealer's turn, he stands.");
                    }
                
                }
                
            }
        }
        //if player's turn
        else {
            System.out.println("It is your turn, Would you like to hit?");
            text = scan.nextLine();
            //if wants to hit
            if (text.equalsIgnoreCase("hit") || text.equalsIgnoreCase("yes") || text.equalsIgnoreCase("y")) {
                //add a card to the player's hand
                player1.addCard(newDeck.TopCard(name1));

            }
            //if forfeit
            else if (text.equalsIgnoreCase("forfeit") || text.equalsIgnoreCase("fold") || text.equalsIgnoreCase("surrender")) {
                System.out.println("you " + text + ", Dealer Wins");
                bust = true;
            }
            //if doesn't hit
            else {
                //if dealer's win
                if (Dealer.sumofCards() == 21) {
                    bust = true;
                    // System.out.println("the dealer has a " + Dealer.sumofCards());
                    // System.out.println("you have a " + player1.sumofCards());
                    System.out.println("Dealer Wins.");
                }
                else {
                turn += 1;
                }
            }
        }

    }

    //prints the deck, used for testing
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
