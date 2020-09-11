public class Gameboard {


    protected static int[][] gameboard1 = new int[20][20];
    protected static int[][] gameboard2 = new int[20][20];


    public void setFruits(int x, int y) {
        gameboard1[x][y] = 2;
    }
    public void setSnake(int x, int y){
        gameboard1[x][y]= 1;
    }


    public void snake() {
        for (int row = 0; row < gameboard1.length; row++) {
            System.out.println("");
            for (int column = 0; column < gameboard1[row].length; column++) {

                try {
                    if (gameboard1[row][column + 1] == 0) {
                        gameboard1[row][column] = 1;
                    }
                } catch (Exception e) {
                    System.out.println("You lost!");
                }


            }
        }
    }

        public void printGameboard () {

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
    }



