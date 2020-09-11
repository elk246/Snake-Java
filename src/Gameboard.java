public class Gameboard {


    private static int[][] gameboard1= new int[10][10];
    private static int[][] gameboard2= new int[10][10];



    public void setFruits(int x, int y){
        gameboard1[x][y]=2;
    }


    public void snake() {
        for (int row = 0; row < gameboard1.length; row++) {
            System.out.println("");
            for (int column = 0; column < gameboard1[row].length; column++) {

                if (gameboard1[row][column + 1] == 0) {
                    gameboard1[row][column] = 1;
                }
            }


        }
    }

    public void printGameboard(){

        for(int row= 0 ; row < gameboard1.length; row++){
            System.out.println("");
            for(int column=0; column < gameboard1[row].length; column++){

                if(gameboard1[row][column]==0){
                    System.out.print(" . ");
                }else{
                    if(gameboard1[row][column]==1){
                        System.out.print(" ▢ ");
                    }else{
                        if(gameboard1[row][column]==2){
                            System.out.print(" ◯ ");
                        }
                    }
                }

            }
        }
    }
}
