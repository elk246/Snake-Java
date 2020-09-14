import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

public class Gameboard {


    protected static int[][] gameboard1 = new int[20][20];
    protected static int[][] gameboard2 = new int[20][20];



    public void setFruits(int x, int y) {
        gameboard1[x][y] = 2;
    }

    public void setSnake(int x, int y) {
        gameboard1[x][y] = 1;
    }

    public void printGameboard() throws InterruptedException {

        Thread.sleep(400);

        for (int row = 0; row < gameboard1.length; row++) {
            System.out.println("");
            for (int column = 0; column < gameboard1[row].length; column++) {

                if (gameboard1[row][column] == 0) {
                    System.out.print(" . ");
                } else {
                    if (gameboard1[row][column] == 1) {
                        System.out.print(" \uD83D\uDC0D");
                    } else {
                        if (gameboard1[row][column] == 2) {
                            System.out.print("\uD83C\uDF4E ");
                        }
                    }
                }

            }
        }
    }

    public void checkGameRight() {
        int count = 0;
        int nothing = 0;

        for (int row = 0; row < gameboard1.length; row++) {

            for (int column = 0; column < gameboard1[row].length; column++) {


                // check neighbours right
                try {
                    if (gameboard1[row][column] == 0 && gameboard1[row][column - 1] == 1) {
                        count++;
                    }
                } catch (Exception e) {
                    if (row == 0 && column >= 0 && column <= gameboard1[0].length - 1) {
                    }
                }
                if (count == 1) {
                    gameboard1[row][column] = 1;
                }
                try {
                    if (gameboard1[row][column] == 1 && gameboard1[row][column - 1] == 0) {
                        nothing++;
                    }
                } catch (Exception e) {
                }
                if (nothing == 1) {
                    gameboard1[row][column] = 0;
                }
            }
        }
    }

    public void checkLeft() {
        int count = 0;
        int nothing = 0;

        for (int row = 0; row < gameboard1.length; row++) {

            for (int column = 0; column < gameboard1[row].length; column++) {
                // check neighbours left
                try {
                    if (gameboard1[row][column - 1] == 0 && gameboard1[row][column] == 1) {
                        count++;
                    }
                } catch (Exception e) {
                    try{
                        if (row == 0 && column >= 0 && column <= gameboard1[0].length - 1) {
                        }
                    }catch(Exception e1){

                    }
                }
                if (count == 1) {
                    gameboard1[row][column - 1] = 1;
                }
                try {
                    if (gameboard1[row][column] == 1 && gameboard1[row][column - 1] == 0) {
                        nothing++;
                    }
                } catch (Exception e) {
                }
                if (nothing == 1) {
                    gameboard1[row][column] = 0;
                }
            }
        }
    }
}










