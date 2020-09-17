import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Gameboard {



    // count the snake length
    private  int count;
    private int moves;
    private int score;
    private boolean isASnake;

    //create gameboard array
    private  Cell[][] gameboard1 = new Cell[20][20];

    //gameboard getter
    public  Cell[][] getGameboard1() {
        return gameboard1;
    }

    //set fruits
    public void setFruits(int x, int y) {

        gameboard1[x][y].setFruit(true);
    }

    public void leadingCell(int x, int y) {
        gameboard1[x][y].setLeading(true);
    }

    public void setSnake(int x, int y, int count) {
        gameboard1[x][y].setAlive(true);
        gameboard1[x][y].setCount(count);
    }
    public void reduceCounter() {
        for (int row = 0; row <= gameboard1.length - 1; row++) {
            for (int column = 0; column <= gameboard1[0].length - 1; column++) {
                if (gameboard1[row][column].getCount() > 0) {
                    gameboard1[row][column].setCount(gameboard1[row][column].getCount() - 1);
                }
            }
        }
    }

    // create new gameboard
    public void createGameboard() throws InterruptedException {

        Thread.sleep(400);

        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {

                gameboard1[row][column] = new Cell();
            }
        }
    }
    //check input
    public String[] checkInput() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] player = new String[2];
        char a = 0;
        try {
            a = bufferedReader.readLine().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = String.valueOf(a);

        for (int i = 0; i < input.length(); i++) {
            if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
                char userOne = input.charAt(i);
                player[0] = String.valueOf(userOne);
                break;
            }
            return player;
        }
        return player;

    }

    //check input for movement
    public void SnakeMove(int speed) {


        TimerTask task= new TimerTask() {
            public void run() {
                try {
                    Robot robot = new Robot();

                    // Simulate a key press

                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);

                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer= new Timer();
        timer.schedule( task, speed);


        try{
            String[] player=checkInput();
            timer.cancel();


            if(player[0].equals("w")){

                snakeUp();
                checkIfAlive();
                printGameboard();


            }
            if(player[0].equals("s")){
                snakeDown();
                checkIfAlive();
                printGameboard();
            }
            if(player[0].equals("a")){
                snakeLeft();
                checkIfAlive();
                printGameboard();
            }
            if(player[0].equals("d")){
                snakeRight();
                checkIfAlive();
                printGameboard();

            }
        }catch(Exception e){
        }
    }

    //print gameboard
    public void printGameboard() {
        for (int row = 0; row < gameboard1.length; row++) {

            System.out.println("");

            for (int column = 0; column < gameboard1[row].length; column++) {

                if (gameboard1[row][column].isFruit()) {
                    System.out.print(" \uD83C\uDF4E");

                } else {
                    if (gameboard1[row][column].isAlive()) {
                        System.out.print(" \uD83D\uDC0D");
                    }


                    if (!gameboard1[row][column].isAlive()) {
                        System.out.print(" . ");
                    }


                }

            }
        }
    }
    public void checkIfAlive() {
        for (int row = 0; row < gameboard1.length; row++) {

            for (int column = 0; column < gameboard1[row].length; column++) {
                if (gameboard1[row][column].getCount() == 0) {
                    gameboard1[row][column].setAlive(false);

                }
            }
        }
    }

    public void snakeRight() {
        moves++;
        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {
                if (gameboard1[row][column].isLeading()) {
                    try {
                        if (!gameboard1[row][column + 1].isAlive() && !gameboard1[row][column + 1].isFruit()) {
                            gameboard1[row][column + 1].setAlive(true);
                            gameboard1[row][column + 1].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row][column + 1].setLeading(true);
                            gameboard1[row][column].setLeading(false);
                            reduceCounter();
                        } else if (gameboard1[row][column + 1].isFruit()) {
                            score++;
                            gameboard1[row][column].setLeading(false);
                            gameboard1[row][column + 1].setAlive(true);
                            gameboard1[row][column + 1].setFruit(false);
                            setFruits((int) (Math.random() * getGameboard1().length), (int) (Math.random() * getGameboard1().length));
                            gameboard1[row][column + 1].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row][column + 1].setLeading(true);
                        }
                        if(gameboard1[row][column +1].isAlive() && gameboard1[row][column].isLeading()){
                            System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                            System.out.println("\uD83D\uDD01 Moves: " + moves);
                            System.out.println("\uD83C\uDFC6 Score: "+score);
                            System.exit(0);
                        }
                        return;

                    }catch(Exception e){
                        System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                        System.out.println("\uD83D\uDD01 Moves: " + moves);
                        System.out.println("\uD83C\uDFC6 Score: "+score);
                        System.exit(0);
                    }
                }
            }
        }
    }

    public void snakeLeft() {
        moves++;
        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {
                if (gameboard1[row][column].isLeading()) {
                    try {
                        if (!gameboard1[row][column - 1].isAlive() && !gameboard1[row][column - 1].isFruit()) {
                            gameboard1[row][column - 1].setAlive(true);
                            gameboard1[row][column - 1].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row][column - 1].setLeading(true);
                            gameboard1[row][column].setLeading(false);
                            reduceCounter();
                        } else if (gameboard1[row][column - 1].isFruit()) {
                            score++;
                            gameboard1[row][column].setLeading(false);
                            gameboard1[row][column - 1].setAlive(true);
                            gameboard1[row][column - 1].setFruit(false);
                            setFruits((int) (Math.random() * getGameboard1().length), (int) (Math.random() * getGameboard1().length));
                            gameboard1[row][column - 1].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row][column - 1].setLeading(true);
                        }
                        if(gameboard1[row][column -1].isAlive() && gameboard1[row][column].isLeading()){
                            System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                            System.out.println("\uD83D\uDD01 Moves: " + moves);
                            System.out.println("\uD83C\uDFC6 Score: "+score);
                            System.exit(0);
                        }
                        return;


                    }catch ( Exception e){
                        System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                        System.out.println("\uD83D\uDD01 Moves: " + moves);
                        System.out.println("\uD83C\uDFC6 Score: "+score);
                        System.exit(0);
                    }

                }
            }
        }
    }
    public void snakeUp() {
        moves++;
        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {

                if (gameboard1[row][column].isLeading()) {
                    try {
                        if (!gameboard1[row - 1][column].isAlive() && !gameboard1[row -1][column].isFruit()) {
                            gameboard1[row - 1][column].setAlive(true);
                            gameboard1[row - 1][column].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row - 1][column].setLeading(true);
                            gameboard1[row][column].setLeading(false);
                            reduceCounter();
                        } else if (gameboard1[row - 1][column].isFruit()) {
                            score++;
                            gameboard1[row][column].setLeading(false);
                            gameboard1[row -1][column].setAlive(true);
                            gameboard1[row-1][column].setFruit(false);
                            setFruits((int) (Math.random() * getGameboard1().length), (int) (Math.random() * getGameboard1().length));
                            gameboard1[row-1][column].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row-1][column].setLeading(true);
                        }
                        if(gameboard1[row -1][column].isAlive() && gameboard1[row][column].isLeading()){
                            System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                            System.out.println("\uD83D\uDD01 Moves: " + moves);
                            System.out.println("\uD83C\uDFC6 Score: "+score);
                            System.exit(0);
                        }

                        return;

                    } catch (Exception e) {
                        System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                        System.out.println("\uD83D\uDD01 Moves: " + moves);
                        System.out.println("\uD83C\uDFC6 Score: "+score);
                        System.exit(0);
                    }
                }
            }
        }
    }

    public void snakeDown(){
        moves++;
        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length ; column++) {
                if (gameboard1[row][column].isLeading()) {
                    try {
                        if (!gameboard1[row + 1][column].isAlive() && !gameboard1[row +1][column].isFruit()) {
                            gameboard1[row + 1][column].setAlive(true);
                            gameboard1[row + 1][column].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row + 1][column].setLeading(true);
                            gameboard1[row][column].setLeading(false);
                            reduceCounter();
                        } else if (gameboard1[row + 1][column].isFruit()) {
                            score++;
                            gameboard1[row][column].setLeading(false);
                            gameboard1[row + 1][column].setAlive(true);
                            gameboard1[row + 1][column].setFruit(false);
                            setFruits((int) (Math.random() * getGameboard1().length), (int) (Math.random() * getGameboard1().length));
                            gameboard1[row + 1][column].setCount(gameboard1[row][column].getCount() + 1);
                            gameboard1[row + 1][column].setLeading(true);
                        }
                        if(gameboard1[row+1][column].isAlive() && gameboard1[row][column].isLeading()){
                            System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                            System.out.println("\uD83D\uDD01 Moves: " + moves);
                            System.out.println("\uD83C\uDFC6 Score: "+score);
                            System.exit(0);
                        }
                            return;

                    }catch(Exception e){
                        System.out.println("\uD83D\uDC80 GAME OVER! \uD83D\uDC80");
                        System.out.println("\uD83D\uDD01 Moves: " + moves);
                        System.out.println("\uD83C\uDFC6 Score: "+score);
                        System.exit(0);
                    }
                }
            }
        }
    }
}






















