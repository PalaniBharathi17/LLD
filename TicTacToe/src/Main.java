import java.util.Scanner;

class Main{
    static Board board;

    static int n ;

    static char currentPlayer ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the grid (n x n) :");
        int n = sc.nextInt();

        board =new Board(n);
        currentPlayer ='X';
        PlayGame game = new PlayGame(board, currentPlayer, sc);
        game.play();

    }


}