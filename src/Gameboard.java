import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

public class Gameboard{

    private static int count;

    private static Cell[][] gameboard1= new Cell[20][20];

    public static Cell[][] getGameboard1(){
        return gameboard1;
    }

    public void setFruits(int x, int y) {
        gameboard1[x][y].setFruit(true);
    }

    public void setSnake(int x, int y, int counter) {
        gameboard1[x][y].setAlive(true);
    }

    public void setSnake(int x, int y){
        gameboard1[x][y].setAlive(true);
        gameboard1[x][y].setCount(getCount());
    }

    public static int getCount() {
        for (int row = 0; row <= gameboard1.length - 1; row++) {
            for (int column = 0; column <= gameboard1[0].length - 1; column++) {

                if (gameboard1[row][column].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void createGameboard() throws InterruptedException {

        Thread.sleep(400);

        for (int row = 0; row < gameboard1.length; row++) {
            for (int column = 0; column < gameboard1[row].length; column++) {

                gameboard1[row][column]= new Cell();
            }
        }
    }

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
                    if(gameboard1[row][column].isAlive()==false){
                        System.out.print(" . ");
                    }
                }
            }
        }
    }

}











