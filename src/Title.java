public class Title extends Gameboard{

    private Cell[][] title= new Cell[10][24];


    public void setFont(int x, int y){

    title[x][y].setAlive(true);
    }

    public void createTitle() {
        for (int row = 0; row < title.length; row++) {
            for (int column = 0; column < title[row].length; column++) {
                title[row][column] = new Cell();
            }
        }
    }

    public void printTitle(){
        for (int row = 0; row < title.length; row++) {
            System.out.println(

            );
            for (int column = 0; column < title[0].length; column++) {

                    if (title[row][column].isAlive()) {
                        System.out.print(" \uD83D\uDC0D" );
                    }

                    if (!title[row][column].isAlive()) {
                        System.out.print(" . ");
                    }
                }
            }
        }
    }


