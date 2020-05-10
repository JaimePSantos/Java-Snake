import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int height;
    private int width;
    private String[][] board;
    private int[][] colBoard;
    private Snake snake;
    private List<Pair<Integer, Integer>> snake2;

    public Board() {
        this.height = 0;
        this.width = 0;
        this.board = new String[this.height][this.width];
        this.snake = new Snake();
        this.snake2 = null;
        this.colBoard = new int[this.height][this.width];


    }

    public void setBoard(int newHeight, int newWidth) {
        this.height = newHeight;
        this.width = newWidth;
        this.board = new String[this.height][this.width];
        this.colBoard = new int[this.height][this.width];
    }

    public void setSnake() {
        int x = ThreadLocalRandom.current().nextInt(1, this.width - 2);
        int y = ThreadLocalRandom.current().nextInt(1, this.height - 2);
        this.snake.initSnake(y, x);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.getWidth();
    }

    public String[][] loadBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {

                if ( i == 0 || i == this.board.length - 1 ) {
                    if ( j == 0 ) {
                        this.board[i][j] = "+";
                    }
                    if ( j == this.board[i].length - 1 ) {
                        this.board[i][j] = "+\n";
                    }
                    if ( j > 0 && j < this.board[i].length - 1 ) {
                        this.board[i][j] = "-";
                    }
                }

                if ( i > 0 && i < this.board.length - 1 ) {
                    if ( j == 0 ) {
                        this.board[i][j] = "|";
                    }
                    if ( j == this.board[i].length - 1 ) {
                        this.board[i][j] = "|\n";
                    }
                    if ( j > 0 && j < this.board[i].length - 1 ) {
                        this.board[i][j] = " ";
                    }
                }
            }

        }
        return this.board;
    }

    public int[][] colBoard(){

//        1 = +; 2 = - ; 3 = |
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if(i==0||i==this.height-1){
                    if(j==0||j==this.width-1){
                        this.colBoard[i][j] = 1;

                    } else{
                        this.colBoard[i][j] = 2;
                    }
                }else if(i>0 && i<this.height-1){
                    if(j==0 || j==this.width-1){
                        this.colBoard[i][j]=3;
                    }
                    if(j>0 && j<this.width-1){
                        this.colBoard[i][j]=0;
                    }
                }
            }
        }

        return this.colBoard;
    }

    public void printBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.board[i][j]);
            }
        }
    }

    public void printColBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.colBoard[i][j]);
            }
            System.out.println("");
        }
    }

}
