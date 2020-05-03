import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.setBoard(10,40);
        board.loadBoard();
        board.printBoard();
    }
}
