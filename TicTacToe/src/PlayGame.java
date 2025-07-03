import java.util.Scanner;

public class PlayGame {
    private Board board;
    private char currentPlayer;
    private Scanner sc;
    public PlayGame(Board board, char currentPlayer, Scanner sc) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.sc = sc;
    }

    public  void play(){
        while (true){
            board.displayBoard();
            System.out.print("Player "+ currentPlayer +"'s turn.");

            int row,col;
            while (true) {
                System.out.print("Enter row and column(0 to " + (board.getSize() - 1) + "): ");
                row = sc.nextInt();
                col = sc.nextInt();

                if (row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) {
                    if (board.isCellEmpty(row, col)) {
                        break;
                    } else {
                        System.out.println("Cell already Occupied !");
                    }
                } else {
                    System.out.println("Invalid Input ! ");
                }
            }

                 board.placeMove(row,col,currentPlayer);
                 //board.displayBoard();

                 if(board.checkWin(row,col,currentPlayer)){
                    board.displayBoard();
                     System.out.println("Player : "+ currentPlayer + "Won !");
                     break;
                 }
                 if(board.isFull()){
                     board.displayBoard();
                     System.out.println("Its a DRAW ! ");
                     break;
                 }
                 switchPlayer();

        }
    }
    public void switchPlayer(){
        currentPlayer = (currentPlayer == 'X')?'O':'X';
    }


}
