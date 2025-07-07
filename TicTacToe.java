
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Let's play Tic-Tac-Toe");
        System.out.print("Y/N - ");
        String interested = s.next();
        if(interested.equals("Y")){
            ticTakToe();
        }
        else{
            System.out.println("Ok!! have a good day");
        }

    }

    public static void ticTakToe(){

        char [][]board = new char[3][3];
        for(int i= 0; i<3; i++){
            for(int j= 0; j<3;j++){
                board[i][j] = ' ';
            }
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter the players name");
        System.out.print("player 1 - ");
        String player1 = sc.next();
        System.out.print("player 2 - ");
        String player2 = sc.next();

        int totalTurns = 0;

        while(totalTurns <9){

            totalTurns++;
            String currPlayer;
            char currSymbol;
            if(totalTurns%2 == 0){
                currPlayer = player2;
                currSymbol = 'O';
            }
            else{
                currPlayer = player1;
                currSymbol = 'X';
            }

            System.out.println(currPlayer + " your turn");
            System.out.println("enter your co-ordinates");
            System.out.print("RowIndex - ");
            int rowIndex = sc.nextInt();
            System.out.print("ColumnIndex - ");
            int columnIndex = sc.nextInt();

            board[rowIndex][columnIndex] = currSymbol;

            printBoard(board);
            if(haveWon(board, rowIndex, columnIndex,currSymbol)){
                System.out.println("Congratulations "+ currPlayer + " won");
                break;

            }

        }
        if(totalTurns==9){
            System.out.println("it's a draw ");
        }

        System.out.println("Do you want to play again ");{
            System.out.print("Y/N - ");
            String playAgain = sc.next();
            if(playAgain.equals("Y")){
                ticTakToe();
            }
            else return;

        }

    }

    public static void printBoard(char[][] board){
        for(int i= 0; i<3; i++){
            for(int j= 0; j<3;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean haveWon(char[][] board,int rowIndex,int columnIndex,char currSymbol){

        if(board[rowIndex][0] ==currSymbol && board[rowIndex][1] == currSymbol && board[rowIndex][2] == currSymbol) return true;
        if(board[0][columnIndex] == currSymbol && board[1][columnIndex] == currSymbol && board[2][columnIndex] ==currSymbol) return true;
        if(board[0][0] == currSymbol && board[1][1] == currSymbol && board[2][2] == currSymbol) return true;

        return false;
    }
}



