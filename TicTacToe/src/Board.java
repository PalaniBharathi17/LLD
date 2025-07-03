public class Board {

    private char [][]grid;
    private int n;

    public Board(int n){
        this.n = n;
        grid = new char[n][n];
        initilizeBoard(n);
    }
    public  void  initilizeBoard(int n){
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ;j<n;j++){
                grid[i][j]='-';
            }
        }
    }

    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == '-';
    }
    public void placeMove( int row, int col, char currentPlayer){
        if(row>=0 && row <n && col>=0 && col < n && grid[row][col]=='-') {
            grid[row][col] = currentPlayer;
        }
    }
    public boolean checkWin(int row,int col ,char player){
        return checkRows(row,player) || checkColumns(col,player) || checkDiagonals(player);
    }
    public boolean checkRows(int row,char player){

        for(int col = 0 ;col<n;col++){
            if(grid[row][col]!=player){
                return false;
            }
        }
        return true;
    }
    public boolean checkColumns(int col, char player){

        for(int row = 0;row<n;row++){
            if(grid[row][col]!=player){
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals(char player){
        boolean dig1=true,dig2 = true;
        for(int i= 0;i<n;i++){
            if(grid[i][i]!=player){
                dig1 = false;

            }
            if(grid[i][n-i-1]!=player){
                dig2 = false;
            }
        }
        return dig1||dig2;
    }
    public boolean isFull() {
        for (char[] row : grid)
            for (char cell : row)
                if (cell == '-')
                    return false;
        return true;
    }

    public int getSize(){
        return n;
    }
}
