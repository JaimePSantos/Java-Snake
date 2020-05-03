public class Board {
    private int height;
    private int width;
    private String[][] board;

    public Board(){
        this.height = 0;
        this.width = 0;
        this.board = new String[this.height][this.width];
    }

    public void setBoard(int newHeight, int newWidth){
        this.height = newHeight;
        this.width = newWidth;
        this.board = new String[this.height][this.width];
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
                    if ( j == this.board[i].length-1) {
                        this.board[i][j] = "+\n";
                    }
                    if ( j > 0 && j < this.board[i].length-1) {
                        this.board[i][j] = "-";
                    }
                }
                if ( i > 0 && i < this.board.length - 1 ) {
                    if ( j == 0 ) {
                        this.board[i][j] = "|";
                    }
                    if ( j == this.board[i].length-1) {
                        this.board[i][j] = "|\n";
                    }
                    if ( j > 0 && j < this.board[i].length-1 ) {
                        this.board[i][j] = " ";
                    }
                }
            }

        }
        return this.board;
    }

    public void printBoard(){
        for(int i =0; i<this.height;i++){
            for(int j=0; j<this.width;j++){
                System.out.print(this.board[i][j]);
            }
        }
    }

}
