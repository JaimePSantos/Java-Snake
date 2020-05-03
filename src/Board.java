import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int height;
    private int width;
    private String[][] board;
    private Snake snake;
    private List<Pair<Integer, Integer>> snake2;

    public Board() {
        this.height = 0;
        this.width = 0;
        this.board = new String[this.height][this.width];
        this.snake = new Snake();
        this.snake2 = null;

    }

    public void setBoard(int newHeight, int newWidth) {
        this.height = newHeight;
        this.width = newWidth;
        this.board = new String[this.height][this.width];
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
        this.setSnake();
        System.out.println(this.snake.toString());
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
                        if ( this.snake.contains(i, j) ) {
                            if ( this.snake.head().getX().equals(i) && this.snake.head().getY().equals(j) ) {
                                this.board[i][j] = "X";
                            } else {
                                this.board[i][j] = "0";
                            }
                        } else {
                            this.board[i][j] = " ";

                        }
                    }
                }
            }

        }
        return this.board;
    }

    public void printBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.board[i][j]);
            }
        }
    }

}
