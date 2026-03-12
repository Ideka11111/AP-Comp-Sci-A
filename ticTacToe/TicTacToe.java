package ticTacToe;

public class TicTacToe {
    private int turn;
    private boolean spotAvailable;
    private int row;
    private int col;
    private String[][] muldArray; //muldArray = multi dimensional array = 2d array
    private String question;
    private boolean gameOver;
    private int count;
    private int rcount;
    private String xoro;

    // public TicTacToe() {
    //     //extra blank constuctor
    // }

    public TicTacToe() {
        turn = 1;
        muldArray = new String[][] {{" - "," - "," - "}, {" - "," - "," - "}, {" - "," - "," - "}};
        //muldArray = new String[][] { row0 ={col,col,col}, row1 ={col,col,col},row2 ={col,col,col} };
        
        //muldArray = new String[][] { row0 ={col,col,col}, 
        //                             row1 ={col,col,col},
        //                             row2 ={col,col,col}};
    }

    public int getTurn() {
        //just return which turn the game is on
        return turn;
    }

    public void printBoard() {
        //prints the tictactoe array onto the console
        //the board should include numbers that show the rows and columns
        System.out.println("  0 1 2");
        System.out.println("0" + muldArray[0][0] + muldArray[0][1] + muldArray[0][2]);
        System.out.println("1" + muldArray[1][0] + muldArray[1][1] + muldArray[1][2]);
        System.out.println("2" + muldArray[2][0] + muldArray[2][1] + muldArray[2][2]);
        
    }

    public boolean pickLocation(int r, int c) {
        //returns a boolean value that determines if the spot a user picks has not been played already (no X or O) & is within the board
        if (r <= 2 && c <= 2) {
            if (muldArray[r][c].equals(" - ")) {
                spotAvailable = true;
            }
            else {
                spotAvailable = false;
            }
        }

        return spotAvailable;
    }

    public void takeTurn(int r, int c) {
        //adds an x or 0 to the array at position row,col depending on whose turn it is
        //if turn is even X should be added to array, if odd then O
        if (turn % 2 == 0) {
            muldArray[r][c] = " X ";
        }
        else {
            muldArray[r][c] = " O ";
        }
    
        turn += 1;

    }

    public String turnQuestion() {
        //returns a string asking the player where they would like to place their X or O
        //String is different based on whos turn it is
        if (turn % 2 == 0) {
            question = "pick a spot to put your X";
        }
        else {
            question = "pick a spot to put your O";
        }

        return question;
    }

    public boolean checkRow() {
        //method to check if the player has three X or O values in a single row
        //returns true of the player does, otherwise returns false
        boolean rboo = false;
        
        //(column loop) runs three times [0-2] every time the row loop runs [0]

        //row loop
        for (int r = 0; r < 3; r++) {
            //resets the count after each row is checked
            rcount = 0;

            //col loop
            for (int c = 0; c < 3; c++) {
                //if col[0-2] on row[0] are not blank, increase count
                if (!muldArray[r][c].equals(" - ")) {
                    rcount += 1;
                //need to reset the count after the each row if count != 3
                }
                else {
                    //do nothing
                }
            }
            //if count == 3 *if a non blank column exists* check whether that column has 3 X's or O's,
            if (rcount == 3) {
                //if the row has 3 *all* X's or O's, return true, else return false
                //for the row the loop is on, checks if first col.equals(second col) and if second col.equals(third col)
                if (muldArray[r][0].equals(muldArray[r][1]) &&  muldArray[r][1].equals(muldArray[r][2])) {
                    //
                    xoro = muldArray[r][1];
                    rboo = true;
                }
                else {
                    rboo = false;
                }
            }
        }
        return rboo;
    }

    public boolean checkCol() {
        //method to check if the player has three X or O values in a single column
        //returns true if player does, otherwise returns false
        boolean cboo = false;
        
        //double for loop - loop one loops through columns and loop two loops through the rows
        //the double for loop works because the (row loop) runs three times [0-2] every time the (column loop) runs once [0],  so it loops through *checks* each column [0-2]
        // column loop
        for (int c = 0; c < 3; c++) {
            //resets the count after each column is checked
            count = 0;

            //row loop
            for (int r = 0; r < 3; r++) {
                //if col[0] on rows [0-2] are not blank, increase count
                if (!muldArray[r][c].equals(" - ")) {
                    count += 1;
                //need to reset the count after each column if count != 3
                }
                else {
                    //do nothing
                }
            }
            //if count == 3 *if a non blank column exists* check whether that column has 3 X's or O's,
            if (count == 3) {
                //if the column has 3 *all* X's or O's, return true, else return false
                //for the column the loop is on, checks if top string.equals(middle string), and if bottom string.equals(middle string),
                if (muldArray[0][c].equals(muldArray[1][c]) &&  muldArray[1][c].equals(muldArray[2][c])) {
                    //
                    xoro = muldArray[1][c];
                    cboo = true;
                }
                else {
                    cboo = false;
                }
            }
        }
        return cboo;
    }

    public boolean checkDiag() {
        //method to check if the player has three X or O values in a diagonal of any direction
        //returns true if player does, otherwise returns false
        boolean dboo = false;

        // muldArray[0][0], muldArray[1][1], muldArray[2][2]
        // muldArray[2][0], muldArray[1][1], muldArray[0][2]

        //if either diagonal has all three spaces equal
        if ( (muldArray[0][0].equals(muldArray[1][1]) && muldArray[1][1].equals(muldArray[2][2])) || (muldArray[2][0].equals(muldArray[1][1]) && muldArray[1][1].equals(muldArray[0][2])) ) {
            //cannot be blank
            if (!muldArray[1][1].equals(" - ")) {
                //
                xoro = muldArray[1][1];
                dboo = true;
            }
            else {
                dboo = false;
            }
        }
        return dboo;
    }

    public String checkwhoWon() {
        //used to check whether X or O won the game
        
        if (xoro.equals(" X ")) {
            return "X Wins!";
        }
        else {
            return "O Wins!";
        }

    }

    public boolean checkWin() {
        //returns a boolean [gameOver] that should return true if the game is won
        //
        if (checkRow() == true || checkCol() == true || checkDiag() == true) {
            gameOver = true;
        }
        else {
            gameOver = false;
        }

        return gameOver;
    }

}
