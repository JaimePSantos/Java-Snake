import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.init(10, 10);
        game.play();
//        Board board = new Board();
//        board.setBoard(10,10);
//        board.colBoard();
//        board.printColBoard();

    }
}
