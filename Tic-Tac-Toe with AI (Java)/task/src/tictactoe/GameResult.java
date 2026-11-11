package tictactoe;

public enum GameResult {
    XWIN("X wins"),
    OWIN("O wins"),
    DRAW("Draw"),
    NOT_DONE("Game not finished!");

    private final String message;

    public String getMessage(){
        return message;
    }

    GameResult(String message){
        this.message = message;
    }
}
