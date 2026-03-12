package ticTacToe;

import java.util.Scanner;

public class Main {
    private int rowInt;
    private int colInt;
    //putting tictactoe variable here so i can use it in methods and real main
    private static TicTacToe newGame;
    
    
    public static void main(String[] args) {
       
        
        //establish a new TicTacToe instance as the global variable so that this specific game can be used outside the real* main
        newGame = new TicTacToe();
        //etablish Main as an object so i can use the class i created
        Main enigma = new Main();
        while (newGame.checkWin() == false) {
            

            enigma.AskandInput();
        
        }
        if (newGame.checkWin() == true) {
            newGame = new TicTacToe();
        }
        //
        
        
        
    }
    
    public void AskandInput() {
    //asks the player where they want to put their letter
        //scanner
        Scanner scan = new Scanner(System.in);
        // show board and quesiton
        newGame.printBoard();
        System.out.println(newGame.turnQuestion());
        System.out.println("Please input the row and the column you'd like to put your letter in.");
        //asking for the row and column and assigning each to a variable
        System.out.println("row:");
        rowInt = scan.nextInt();
        System.out.println("column:");
        colInt = scan.nextInt(); 
        
        //input the user's chosen point if it is free
        if (newGame.pickLocation(rowInt, colInt) == true) {
            newGame.takeTurn(rowInt,colInt);
        }
        else {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("that space is not available, please choose another space to put your letter in.");
        }

    }
    
}
