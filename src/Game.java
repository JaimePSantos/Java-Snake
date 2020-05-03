public class Game {
    private Board board;

    public Game(){
        this.board = new Board();
    }

    public void newBoard(int height, int width){
        this.board.setBoard(height,width);

    }


}
