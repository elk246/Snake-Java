import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws InterruptedException {


        Scanner scan = new Scanner(System.in);
        String Answer = " d ";

        // add new classes
        Gameboard gameboard = new Gameboard();
        Spawn spawn = new Spawn();

        // create the gameboard
        gameboard.createGameboard();

        //set all objects on gameboard
        spawn.setFruits(gameboard);
        spawn.setSnake(gameboard);

        //print gameboard
        gameboard.printGameboard();

        while (true) {
            Answer = scan.next();

            if (Answer.equals("d")) {
                gameboard.snakeRight();
            }
            if(Answer.equals("a")){
                gameboard.snakeLeft();
            }
            if(Answer.equals("w")){
                gameboard.snakeUp();
            }
            if(Answer.equals("s")){
                gameboard.snakeDown();
            }
            gameboard.checkIfAlive();
            gameboard.printGameboard();
        }
    }

}

