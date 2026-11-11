package tictactoe;

public class EasyAi extends AiPlayer {

    @Override
    public void makeMove(Field field, char turn) {
        System.out.println("Making move level \"easy\"");
        makeRandomMove(field, turn);
    }

}
