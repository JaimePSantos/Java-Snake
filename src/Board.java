public class Board {
    private int height;
    private int width;
    private int[][] colBoard;

    public Board() {
        this.height = 0;
        this.width = 0;
        this.colBoard = new int[this.height][this.width];
    }

    public void setBoard(int newHeight, int newWidth) {
        this.height = newHeight;
        this.width = newWidth;
        this.colBoard = new int[this.height][this.width];
    }

    //    1 = "+"; 2 = "-" ; 3 = "|"
    public int[][] colBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if ( i == 0 || i == this.height - 1 ) {
                    if ( j == 0 || j == this.width - 1 ) {
                        this.colBoard[i][j] = 1;

                    } else {
                        this.colBoard[i][j] = 2;
                    }
                } else if ( i > 0 && i < this.height - 1 ) {
                    if ( j == 0 || j == this.width - 1 ) {
                        this.colBoard[i][j] = 3;
                    }
                    if ( j > 0 && j < this.width - 1 ) {
                        this.colBoard[i][j] = 0;
                    }
                }
            }
        }
        return this.colBoard;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.getWidth();
    }

    public void printColBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.colBoard[i][j]);
            }
            System.out.println("");
        }
    }

}
