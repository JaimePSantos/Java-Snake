import java.util.Scanner;
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
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.loadedBoard = this.board.loadBoard();
        this.colBoard = this.board.colBoard();
        this.gameOver = false;
        this.setSnake();
    }

    public void setSnake() {
        int x = ThreadLocalRandom.current().nextInt(1, this.boardWidth - 2);
        int y = ThreadLocalRandom.current().nextInt(1, this.boardHeight - 2);
        this.snake.initSnake(y, x);
    }

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
                switch (this.colBoard[i][j]) {
                    case 1:
                        this.loadedBoard[i][j] = "+ ";
                        break;
                    case 2:
                        this.loadedBoard[i][j] = "- ";
                        break;
                    case 3:
                        this.loadedBoard[i][j] = "| ";
                        break;
                    case 4:
                        this.loadedBoard[i][j] = "X ";
                        break;
                    case 5:
                        this.loadedBoard[i][j] = "O ";
                        break;
                    default:
                        this.loadedBoard[i][j] = "  ";
                }
            }
        }
        return this.loadedBoard;
    }

    public void clear() {
        this.board.colBoard();
    }

    public void moveTest(Scanner scan) {
//        this.render();
        this.colRender();
        this.printGame();
        while (true) {
            String input = scan.nextLine();
            if ( input.equals("q") ) {
                break;
            }
            switch (this.checkAhead(input)) {
                case -1:
                    System.out.println("Game Over!");
                    return;
                case 0:
                    this.snake.move(input);

            }
            this.clear();
            this.colRender();
            this.printGame();
        }

    }

    public void printColBoard() {
        this.colBoard();
        this.snake.toString();
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                System.out.print(this.colBoard[i][j]);
            }
            System.out.println("");
        }
    }

    public int checkAhead(String input) {
        int dirX = 0;
        int dirY = 0;
        input = input.toLowerCase();
        switch (input) {
            case "w":
                dirX = -1;
                break;
            case "s":
                dirX = 1;
                break;
            case "a":
                dirY = -1;
                break;
            case "d":
                dirY = 1;
                break;
        }
        int snakeX = (int) this.snake.head().getX();
        int snakeY = (int) this.snake.head().getY();
        switch (this.colBoard[snakeX + dirX][snakeY + dirY]) {
            case 1:
            case 2:
            case 3:
                return -1;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    public void printGame() {
        this.colRender();

        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                System.out.print(this.loadedBoard[i][j]);
            }
            System.out.println("");
        }


    }

}
