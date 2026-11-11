package tictactoe;

import java.time.temporal.ValueRange;
import java.util.*;

import static tictactoe.GameResult.*;

class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Field field = new Field();

        while (true) {
            System.out.println("Input command: ");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            String[] input = command.split(" ");
            if (input.length != 3 || !input[0].equals("start")) {
                System.out.println("Bad parameters!");
                continue;
            }
            Player playerX;
            Player playerO;
            try{
                playerX = createPlayer(input[1], scanner);
                playerO = createPlayer(input[2], scanner);
            }catch (IllegalArgumentException e){
                System.out.println("Bad parameters!");
                continue;
            }
            field.playGame(playerX, playerO);
        }
    }

    private static Player createPlayer(String type, Scanner scanner) {
        if (type.equals("user")) {
            return new HumanPlayer(scanner);
        }else if(type.equals("easy")){
            return new EasyAi();
        }else if(type.equals("medium")){
            return new MediumAi();
        } else if(type.equals("hard")){
            return new HardAi();
        }
        else{
            throw new IllegalArgumentException("Unknown player type: " + type);
        }
    }
}

