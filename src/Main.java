import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws InterruptedException {


        // add new classes
        Gameboard gameboard = new Gameboard();
        Spawn spawn = new Spawn();


        // create the gameboard
        gameboard.createGameboard();

        //set all objects on gameboard
        spawn.setFruits(gameboard);
        spawn.setSnake(gameboard);


    while(true) {
        System.out.println("");
        gameboard.printGameboard();

        gameboard.SnakeMove(1000);
        gameboard.checkIfAlive();

}


    }

}

