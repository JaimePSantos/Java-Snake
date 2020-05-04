import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.setBoard(10,40);
//        board.loadBoard();
//        board.printBoard();
        Game game = new Game();
        System.out.println("Test4");
        game.init(10,10);
        System.out.println("Test5");
        game.printGame();
    }
}
