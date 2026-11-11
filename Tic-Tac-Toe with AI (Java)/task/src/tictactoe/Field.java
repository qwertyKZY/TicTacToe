package tictactoe;

import static tictactoe.GameResult.*;

public class Field {

    private char[][] matrix = new char[3][3];

    public void playGame(Player playerX, Player playerO) {
        char turn = 'X';
        GameResult result = NOT_DONE;
        emptyMatrix();
        printMatrix();
        while(result == NOT_DONE){
            Player currentPlayer = (turn =='X') ? playerX : playerO;
            currentPlayer.makeMove(this,turn);
            printMatrix();
            result = getState();
            if (result != NOT_DONE) {
                System.out.println(result.getMessage());
            } else {
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }
    }

    public void emptyMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    public void printMatrix() {
        System.out.println("---------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isOccupied(Coordinates coordinate) {
        return matrix[coordinate.getRow()][coordinate.getCol()] != ' ';
    }

    public boolean placeSymbol(Coordinates coordinate, char turn){
        if (!isOccupied(coordinate)) {
            matrix[coordinate.getRow()][coordinate.getCol()] = turn;
            return true;
        }
        return false;
    }

    public void undoSymbol(Coordinates coordinate){
        matrix[coordinate.getRow()][coordinate.getCol()] = ' ';
    }

    public GameResult getState() {
        if (hasWon('X')) {
            return XWIN;
        }
        if (hasWon('O')) {
            return OWIN;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    return NOT_DONE;
                }
            }
        }
        return DRAW;
    }

    private boolean hasWon(char symbol) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == symbol && matrix[i][1] == symbol && matrix[i][2] == symbol) {
                return true;
            }
            if (matrix[0][i] == symbol && matrix[1][i] == symbol && matrix[2][i] == symbol) {
                return true;
            }
        }
        if (matrix[0][0] == symbol && matrix[1][1] == symbol && matrix[2][2] == symbol) {
            return true;
        }
        if (matrix[0][2] == symbol && matrix[1][1] == symbol && matrix[2][0] == symbol) {
            return true;
        }
        return false;
    }
}
