import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Board board;
    private Snake snake;
    private int boardHeight;
    private int boardWidth;
    private String[][] loadedBoard;
    private int[][] colBoard;
    private boolean gameOver;

    public Game() {
        this.board = new Board();
        this.snake = new Snake();
        this.boardHeight = 0;
        this.boardWidth = 0;
        this.loadedBoard = new String[this.boardHeight][this.boardWidth];
        this.colBoard = new int[this.boardHeight][this.boardWidth];
        this.gameOver = false;
    }

    public void init(int boardHeight, int boardWidth) {
        this.board.setBoard(boardHeight, boardWidth);
        int x = ThreadLocalRandom.current().nextInt(1, boardWidth - 2);
        int y = ThreadLocalRandom.current().nextInt(1, boardHeight - 2);
        this.snake.initSnake(y, x);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.loadedBoard = this.board.loadBoard();
        this.colBoard = this.board.colBoard();
        this.gameOver = false;

    }

//    Implemented better method - Remove later
//    public String[][] render() {
//        for (int i = 0; i < this.loadedBoard.length; i++) {
//            for (int j = 0; j < this.loadedBoard[i].length; j++) {
//                if ( j > 0 && j < this.loadedBoard[i].length - 1 ) {
//                    if ( this.snake.contains(i, j) ) {
//                        if ( this.snake.head().getX().equals(i) && this.snake.head().getY().equals(j) ) {
//                            this.loadedBoard[i][j] = "X";
//                        } else {
//                            this.loadedBoard[i][j] = "0";
//                        }
//                    }
//                }
//            }
//
//        }
//        return this.loadedBoard;
//    }

    public int[][] colSnake(int i, int j) {
//      4 = Head("X") ; 5 = Body("O")
        if ( this.snake.contains(i, j) ) {
            if ( this.colBoard[i][j] == 0 ) {
                if ( this.snake.head().getX().equals(i) && this.snake.head().getY().equals(j) ) {
                    this.colBoard[i][j] = 4;
                } else {
                    this.colBoard[i][j] = 5;
                }
            } else if ( this.colBoard[i][j] == 1 || this.colBoard[i][j] == 2 || this.colBoard[i][j] == 3 ) {
                this.gameOver = true;
            }
        }
        return this.colBoard;
    }

    public int[][] gameOver() {

        this.colBoard[0][0] = 99;
        return this.colBoard;
    }

    public int[][] colBoard() {
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                this.colSnake(i, j);
                if ( this.gameOver == true ) {
                    return this.gameOver();
                }
            }
        }
        return this.colBoard;
    }

    public String[][] colRender() {
        this.colBoard();
        if ( this.colBoard[0][0] == 99 ) {
            this.loadedBoard[0][0] = "GameOver";
        }
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {

                if ( this.colBoard[i][j] == 0 ) {
                    this.loadedBoard[i][j] = " ";
                } else if ( this.colBoard[i][j] == 1 ) {
                    this.loadedBoard[i][j] = "+";
                } else if ( this.colBoard[i][j] == 2 ) {
                    this.loadedBoard[i][j] = "-";
                } else if ( this.colBoard[i][j] == 3 ) {
                    this.loadedBoard[i][j] = "|";
                } else if ( this.colBoard[i][j] == 4 ) {
                    this.loadedBoard[i][j] = "X";
                } else if ( this.colBoard[i][j] == 5 ) {
                    this.loadedBoard[i][j] = "O";
                }
            }
        }
        return this.loadedBoard;
    }

    public void clear() {
        this.board.loadBoard();
    }

    public void moveTest(String input) {
//        this.render();
        this.colRender();
        this.printGame();
        this.snake.move(input);
        this.clear();
        this.colRender();
        this.printGame();
    }

    public void printColBoard() {
        this.colBoard();
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {

                System.out.print(this.colBoard[i][j]);
            }
            System.out.println("");
        }
    }

    public void printGame() {
        this.colRender();
        if ( this.loadedBoard[0][0].equals("GameOver") ) {
            System.out.println("Game Over!");
            return;
        }else{
            for (int i = 0; i < this.boardHeight; i++) {
                for (int j = 0; j < this.boardWidth; j++) {
                    System.out.print(this.loadedBoard[i][j]);
                }
                System.out.println("");
            }
        }

    }

}
