public class Title extends Gameboard{

    //Cells for title
    private Cell[][] title= new Cell[10][24];

    //Font for title
    public void setFont(int x, int y){

    title[x][y].setAlive(true);
    }

    //create title field
    public void createTitle() {
        for (int row = 0; row < title.length; row++) {
            for (int column = 0; column < title[row].length; column++) {
                title[row][column] = new Cell();
            }
        }
    }

    //print title field
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


