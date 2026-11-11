package tictactoe;

import java.util.Random;

abstract class AiPlayer implements Player {
    private final Random rand = new Random();

    public abstract void makeMove(Field field, char turn);

    protected void makeRandomMove(Field field, char symbol){
        while(true){
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            Coordinates gameCoordinates = new Coordinates(row, col);
            if(field.placeSymbol(gameCoordinates,symbol)){
                break;
            }
        }
    }

    protected char opponentOf(char symbol){
        return (symbol == 'X') ? 'O' : 'X';
    }
}
