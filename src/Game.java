import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Board board;
    private Snake snake;
    private int boardHeight;
    private int boardWidth;
    private String[][] loadedBoard;

    public Game() {
        this.board = new Board();
        this.snake = new Snake();
        this.boardHeight = 0;
        this.boardWidth = 0;
        this.loadedBoard = new String[this.boardHeight][this.boardWidth];
    }

    public void init(int boardHeight, int boardWidth) {
        this.board.setBoard(boardHeight, boardWidth);
        int x = ThreadLocalRandom.current().nextInt(1, boardWidth - 2);
        System.out.println("Test1");
        int y = ThreadLocalRandom.current().nextInt(1, boardHeight - 2);
        System.out.println("Test2");
        this.snake.initSnake(y, x);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.loadedBoard = this.board.loadBoard();
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                System.out.print(this.loadedBoard[i][j]);
//                System.out.println("Test3");

            }
        }
    }

    public String[][] render() {
//        int rows = this.board.loadBoard().length;
//        int columns = this.board.loadBoard()[0].length;
        for (int i = 0; i < this.loadedBoard.length; i++) {
            for (int j = 0; j < this.loadedBoard[i].length; j++) {
                if ( j > 0 && j < this.loadedBoard[i].length - 1 ) {
                    if ( this.snake.contains(i, j) ) {
                        if ( this.snake.head().getX().equals(i) && this.snake.head().getY().equals(j) ) {
                            this.loadedBoard[i][j] = "X";
                        } else {
                            this.loadedBoard[i][j] = "0";
                        }
                    }
                }
            }

        }
        return this.loadedBoard;
    }

    public void printGame() {
        this.render();
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                System.out.print(this.loadedBoard[i][j]);

            }
        }
    }

}
