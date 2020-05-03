import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        //        Board board = new Board(10,40);
//        Snake snake = new Snake();
        Pair pos = new Pair();
//        for(int i =0; i<10;i++){
//            snake.add(i,i+10);
//        }
        Pair pair1 = new Pair(1,2);
        Pair pair2 = new Pair(2,3);
        Snake snake = new Snake();

//        System.out.println(snake.toString());
//        snake.takeStep(1,1);
//        System.out.println(snake.toString());

//        board.loadBoard();
//        board.printBoard();
//        System.out.print("A+\nB");
    }
}
