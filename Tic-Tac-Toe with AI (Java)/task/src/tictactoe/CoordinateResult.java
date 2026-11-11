package tictactoe;

public enum CoordinateResult {
    VALID(""),
    NOT_NUMBER("You should enter numbers!"),
    OUT_OF_RANGE("Coordinates should be from 1 to 3!"),
    WRONG_COUNT("You should enter two coordinates!");

    private final String message;

    CoordinateResult(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
