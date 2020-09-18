import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class Gameboard {


    // counter for score and moves
    private int moves;
    private int score;


    //create gameboard array
    private Cell[][] gameboard1 = new Cell[15][15];


    //gameboard getter
    public Cell[][] getGameboard1() {

        return gameboard1;
    }

    //set bonus method
    public void setBonus(int x, int y){
        gameboard1[x][y].setBonus(true);
    }

    //set fruit method
    public void setFruits(int x, int y) {
        gameboard1[x][y].setFruit(true);
    }

    //set leading cell method
    public void leadingCell(int x, int y) {
        gameboard1[x][y].setLeading(true);
    }

    //set snake method
    public void setSnake(int x, int y, int count) {
        gameboard1[x][y].setAlive(true);
        gameboard1[x][y].setCount(count);
    }

    //method for reduce snake counter
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
    public void createGameboard() {

        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {

                gameboard1[row][column] = new Cell();
            }
        }
    }


    //check input for snake movement
    public void checkInput(int speed) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //input char
        char move = 'd';
        //char for previous input if no input // save the move char
        char prev_move = 'd';


        while (true) {
            TimerTask timerTask = new TimerTask() {
                @Override
                //set robot for ENTER
                public void run() {
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask, speed);
            try {


                move = bufferedReader.readLine().charAt(0);


                timerTask.cancel();

                if (move == 's' && prev_move == 'w') {
                    move = prev_move;
                } else {
                    prev_move = move;
                }

            } catch (StringIndexOutOfBoundsException e) {
                //set move to prev_move
                move = prev_move;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //check the input for movement
                if (move == 'w') {
                    move = prev_move;
                    snakeUp();
                    checkIfAlive();
                    printGameboard();
                }
                if (move == 's') {
                    move = prev_move;
                    snakeDown();
                    checkIfAlive();
                    printGameboard();
                }
                if (move == 'a') {
                    move = prev_move;
                    snakeLeft();
                    checkIfAlive();
                    printGameboard();
                }
                if (move == 'd') {
                    move = prev_move;
                    snakeRight();
                    checkIfAlive();
                    printGameboard();
                }
            } catch (Exception e) {
            }
        }
    }

    //print gameboard
    public void printGameboard() {
        for (int row = 0; row < gameboard1.length; row++) {
            System.out.println("");
            for (int column = 0; column < gameboard1[row].length; column++) {

                //check alive, dead or fruit
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
    //check the counter if <0= set dead
    public void checkIfAlive() {
        for (int row = 0; row < gameboard1.length; row++) {

            for (int column = 0; column < gameboard1[row].length; column++) {
                if (gameboard1[row][column].getCount() == 0) {
                    gameboard1[row][column].setAlive(false);

                }
            }
        }
    }

    //generate a new random fruit in gameboard
    public void generateFruit(){
        int x= (int)(Math.random()* getGameboard1().length);
        int y= (int)(Math.random()* getGameboard1().length);

        if(!gameboard1[x][y].isAlive()){
            gameboard1[x][y].setFruit(true);
        }else{
            generateFruit();
        }
    }

    //movement method for move right
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
                            generateFruit();
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

    //movement method for move left
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
                            generateFruit();
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

    //movement method for move up
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
                            generateFruit();
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

    //movement method for move down
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
                            generateFruit();
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