package tictactoe;

public class MediumAi extends AiPlayer{

    @Override
    public void makeMove(Field field, char turn) {
        System.out.println("Making move level \"medium\"");
        Coordinates currentWinningField = findWinningMove(field, turn);
        if(currentWinningField != null){
            field.placeSymbol(currentWinningField, turn);
            return;
        }
        char oppTurn = opponentOf(turn);
        Coordinates oppWinningField = findWinningMove(field, oppTurn);
        if(oppWinningField != null){
            field.placeSymbol(oppWinningField, turn);
            return;
        }
        makeRandomMove(field, turn);
    }

    private Coordinates findWinningMove(Field field, char symbol){
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                Coordinates cell = new Coordinates(i,j);
                if(field.placeSymbol(cell,symbol)){
                    GameResult result = field.getState();
                    field.undoSymbol(cell);
                    if(result == GameResult.XWIN || result == GameResult.OWIN){
                        return cell;
                    }
                }

            }
        }
        return null;
    }
}
