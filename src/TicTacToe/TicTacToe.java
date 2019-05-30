package TicTacToe;

public class TicTacToe {

    private String [][] board;
    private String currentPlayerMark;
    private static final int ROWS =3;
    private static final int COLUMNS = 3;

    public TicTacToe(){
        board = new String[ROWS][COLUMNS];
        currentPlayerMark = "O";
        initializeBoard();
    }

    public String getPlayerMark(){
        return currentPlayerMark;
    }

    //board initialization
    public void initializeBoard(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                board[i][j] = "   ";
            }
        }
    }

    //board printing
    public String printBoard(){
        String strBoard = "";
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                if (j < COLUMNS) strBoard += board[i][j] + "|";
            }
            if(i < ROWS-1) strBoard += "\n---+---+---+\n";
        }
        return strBoard;
    }

    //checking if the board is filled with data
    public boolean isBoardFull(){

        boolean isFull = true;
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                if (board[i][j] == "   ")
                    isFull = false;
            }
        }
        return isFull;
    }

    //checking for a win
    public boolean checkForWin(){
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    //checking the rows for a win
    private boolean checkRows(){

        for (int i = 0; i < ROWS; i++){
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;

            }
        }
        return false;
    }

    //checking the columns for a win
    private boolean checkColumns(){

        for (int i = 0; i < COLUMNS; i++){
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
                return true;
        }
        return false;
    }

    //checking for a win in the diagonals
    private boolean checkDiagonals(){
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[0][2]) == true);
    }

    //this method check every box in the board
    private boolean checkRowCol(String s1, String s2, String s3){

        boolean check = false;
        if ((!s1.equals("   ")) && (s1.equals(s2)) && (s2.equals(s3))){
            check = true;
        }
        //could also use -> return ((s1 != "   ") && (s1 == s2) && (s2 ==s3))
        return check;
    }

    //changing players
    public void changePlayer(){
        if( currentPlayerMark == "X")
            currentPlayerMark = "O";
        else
            currentPlayerMark = "X";
    }

    //placing a mark at the specified location
    public boolean placeMark(int row, int col){
        if (row >= 0 && row < ROWS){
            if (col >= 0 && col < COLUMNS){
                if (board[row][col] == "   "){
                    board[row][col] =" " + currentPlayerMark + " ";
                    return true;
                }
            }
        }
        return false;
    }
}
