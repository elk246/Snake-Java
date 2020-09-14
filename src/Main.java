import java.awt.*;
import java.util.Scanner;
public class Main {



    public static void main(String[] args) throws InterruptedException {

        Scanner scan= new Scanner(System.in);
        String Answer= " d ";





        // add new classes
        Gameboard gameboard= new Gameboard();
        Spawn spawn= new Spawn();

        //set all objects on gameboard
        spawn.setFruits(gameboard);
        spawn.setSnake(gameboard);

        //first gameboard output
        gameboard.printGameboard();
        System.out.println("");

        while(true) {

        Answer=scan.next();

        if(Answer.equals("d")){
            gameboard.checkGameRight();
            System.out.println("");
            gameboard.printGameboard();
        }


            if(Answer.equals(("a"))){
                gameboard.checkLeft();
                System.out.println("");
                gameboard.printGameboard();
            }

        }

    }
}
