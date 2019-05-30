package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting TicTacToe game");
        Scanner sc = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initializeBoard();

        do{
            System.out.println(ticTacToe.printBoard());
            int row;
            int col;

            ticTacToe.changePlayer();
            System.out.println(ticTacToe.getPlayerMark() + "'s turn...");

            do {
                System.out.println("Enter a row");
                row = sc.nextInt();
                System.out.println("Enter a column");
                col = sc.nextInt();
            }while(!ticTacToe.placeMark(row, col));

        }while (!ticTacToe.checkForWin() && !ticTacToe.isBoardFull());

        if (ticTacToe.isBoardFull() && !ticTacToe.checkForWin())
        {
            System.out.println("It was a tie!\n" + ticTacToe.printBoard());
        }
        else
        {
            System.out.println("Current board layout:\n" + ticTacToe.printBoard());
            System.out.println("Player " + ticTacToe.getPlayerMark() + " wins!");
        }
    }
}
