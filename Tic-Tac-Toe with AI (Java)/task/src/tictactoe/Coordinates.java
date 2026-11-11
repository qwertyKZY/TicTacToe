package tictactoe;

public class Coordinates {

    private final int row;
    private final int col;

    public Coordinates(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }
}
