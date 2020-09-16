import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.ArrayList;
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






















