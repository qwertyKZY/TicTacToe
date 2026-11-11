package tictactoe;

import java.time.temporal.ValueRange;
import java.util.Scanner;

import static tictactoe.CoordinateResult.*;

public class HumanPlayer implements Player{
    private final Scanner scanner;

    public HumanPlayer(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Field field, char symbol) {
        String coordinates;
        boolean correctInput = false;
        do {
            System.out.print("Enter the coordinates: ");
            coordinates = scanner.nextLine();
            CoordinateResult result = checkCoordinate(coordinates);
            if (result != VALID) {
                System.out.println(result.getMessage());
                continue;
            }
            String[] splitInput = coordinates.trim().split("\\s+");
            int i = Integer.parseInt(splitInput[0]);
            int j = Integer.parseInt(splitInput[1]);
            Coordinates gameCoordinates = new Coordinates(i - 1, j - 1);
            if(field.placeSymbol(gameCoordinates, symbol)){
                correctInput = true;
            }else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } while (!correctInput);
    }

    private CoordinateResult checkCoordinate(String coordinate) {
        String[] splitCoordinate = coordinate.trim().split("\\s+");
        if (splitCoordinate.length != 2) {
            return WRONG_COUNT;
        }
        String row = splitCoordinate[0];
        String col = splitCoordinate[1];
        int i, j;
        try {
            i = Integer.parseInt(row);
            j = Integer.parseInt(col);
            ValueRange range = ValueRange.of(1, 3);
            if (!range.isValidIntValue(i) || !range.isValidIntValue(j)) {
                return OUT_OF_RANGE;
            }
            return VALID;
        } catch (NumberFormatException e) {
            return NOT_NUMBER;
        }
    }
}
