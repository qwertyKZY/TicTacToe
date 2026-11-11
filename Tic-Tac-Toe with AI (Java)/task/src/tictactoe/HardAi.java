package tictactoe;

public class HardAi extends AiPlayer{

    @Override
    public void makeMove(Field field, char turn) {
        System.out.println("Making move level \"hard\"");
        Coordinates move = bestMove(field, turn);
        field.placeSymbol(move,turn);
    }

    private Coordinates bestMove(Field field, char symbol){
        int bestScore = Integer.MIN_VALUE;
        Coordinates bestCell = null;

        for(int i =0 ;i <3 ; i ++){
            for(int j = 0; j < 3 ; j++){
                Coordinates cell = new Coordinates(i,j);
                if(field.placeSymbol(cell, symbol)){
                    int score = minimax(field, symbol, false);
                    field.undoSymbol(cell);
                    if (score > bestScore){
                        bestScore = score;
                        bestCell = cell;
                    }
                }
            }
        }
        return bestCell;
    }

    private int minimax(Field field, char symbol, boolean isMaximizing){
        GameResult result = field.getState();
        GameResult aiWin = (symbol == 'X') ? GameResult.XWIN : GameResult.OWIN;
        char opponentTurn = opponentOf(symbol);
        GameResult oppWin = (symbol == 'X') ? GameResult.OWIN : GameResult.XWIN;

        if(result != null){
            if(result == aiWin){
                return 10;
            }
            if(result == oppWin){
                return -10;
            }
            if(result == GameResult.DRAW){
                return 0;
            }
        }

        if(isMaximizing){
            int best = Integer.MIN_VALUE;
            for(int i =0;i<3;i++){
                for(int j = 0 ; j < 3 ; j++){
                    Coordinates cell = new Coordinates(i,j);
                    if(field.placeSymbol(cell, symbol)){
                        int score = minimax(field, symbol, false);
                        field.undoSymbol(cell);
                        best = Math.max(score, best);
                    }
                }
            }
            return best;
        }else{
            int best = Integer.MAX_VALUE;
            for(int i =0;i<3;i++) {
                for (int j = 0; j < 3; j++) {
                    Coordinates cell = new Coordinates(i, j);
                    if (field.placeSymbol(cell, opponentTurn)) {
                        int score = minimax(field, symbol, true);
                        field.undoSymbol(cell);
                        best = Math.min(score, best);
                    }
                }
            }
            return best;
        }
    }
}
