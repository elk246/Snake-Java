import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws InterruptedException, IOException {


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
        System.out.println("\u001B[36m");
        System.out.println(" _____                          _____    _                _                _   \n" +
                "|  __ \\                        / ____|  | |              | |              | |  \n" +
                "| |__) |_ __  ___  ___  ___   | (___    | |_  ___    ___ | |_  __ _  _ __ | |_ \n" +
                "|  ___/| '__|/ _ \\/ __|/ __|   \\___ \\   | __|/ _ \\  / __|| __|/ _` || '__|| __|\n" +
                "| |    | |  |  __/\\__ \\\\__ \\   ____) |  | |_| (_) | \\__ \\| |_| (_| || |   | |_ \n" +
                "|_|    |_|   \\___||___/|___/  |_____/    \\__|\\___/  |___/ \\__|\\__,_||_|    \\__|");
        System.out.println("\u001B[0m");
        answer = scan.next();


        if (answer.equals("S") || answer.equals("s")) {

            // create the gameboard
            gameboard.createGameboard();

            //set all objects on gameboard

            spawn.setFruits(gameboard);
            spawn.setSnake(gameboard);
            spawn.setBonus(gameboard);

            gameboard.checkInput(500);
            while (true) {
                System.out.println("");
                gameboard.printGameboard();


                gameboard.checkIfAlive();
            }
        }
    }
}

