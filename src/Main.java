import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        String answer;

        // add new classes
        Gameboard gameboard = new Gameboard();
        Spawn spawn = new Spawn();
        Title title = new Title();

        title.createTitle();
        spawn.setFont(title);
        title.printTitle();


        System.out.println("");
        System.out.println("Press S to start snake");
        answer = scan.next();


        if (answer.equals("S") || answer.equals("s")) {

            // create the gameboard
            gameboard.createGameboard();

            //set all objects on gameboard

            spawn.setFruits(gameboard);
            spawn.setSnake(gameboard);


            while (true) {
                System.out.println("");
                gameboard.printGameboard();

                gameboard.checkInput(500);
                gameboard.checkIfAlive();
            }
        }
    }
}

