public class Spawn extends Gameboard{



    public void setFruits(Gameboard game){

        game.setFruits((int)(Math.random()* getGameboard1().length),(int)(Math.random()* getGameboard1().length));
    }

    public void setSnake(Gameboard game){
        game.setSnake(5,5,1);
        game.setSnake(5,6,2);
        game.setSnake(5,7,3);

        game.leadingCell(5,7);

    }
    public void setFont(Title title){
        title.setFont(2, 1);
        title.setFont(2, 2);
        title.setFont(2, 3);
        title.setFont(3, 1);
        title.setFont(4, 1);
        title.setFont(4, 2);
        title.setFont(4, 3);
        title.setFont(5, 3);
        title.setFont(6, 3);
        title.setFont(6, 2);
        title.setFont(6, 1);
        title.setFont(2, 5);
        title.setFont(3, 5);
        title.setFont(4, 5);
        title.setFont(5, 5);
        title.setFont(6, 5);
        title.setFont(3, 6);
        title.setFont(5, 7);
        title.setFont(4, 7);
        title.setFont(6, 8);
        title.setFont(5, 8);
        title.setFont(4, 8);
        title.setFont(3, 8);
        title.setFont(2, 8);
        title.setFont(2, 10);
        title.setFont(3, 10);
        title.setFont(4, 10);
        title.setFont(5, 10);
        title.setFont(6, 10);
        title.setFont(2, 11);
        title.setFont(2, 12);
        title.setFont(3, 12);
        title.setFont(4, 12);
        title.setFont(5, 12);
        title.setFont(6, 12);
        title.setFont(4, 11);
        title.setFont(2, 14);
        title.setFont(3, 14);
        title.setFont(4, 14);
        title.setFont(5, 14);
        title.setFont(6, 14);
        title.setFont(4, 15);
        title.setFont(3, 16);
        title.setFont(2, 17);
        title.setFont(5, 16);
        title.setFont(6, 17);
        title.setFont(2, 19);
        title.setFont(3, 19);
        title.setFont(4, 19);
        title.setFont(5, 19);
        title.setFont(6, 19);
        title.setFont(2, 20);
        title.setFont(2, 21);
        title.setFont(4, 20);
        title.setFont(4, 21);
        title.setFont(6, 20);
        title.setFont(6, 21);
    }

    public void setBonus(Gameboard game){
        int random= (int)(Math.random()* 80);



    }



}
