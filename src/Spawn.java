public class Spawn extends Gameboard {

    public void setFruits(Gameboard game){

        game.setFruits((int)(Math.random()* getGameboard1().length),(int)(Math.random()* getGameboard1().length));
    }

    public void setSnake(Gameboard game){
        game.setSnake(5,5,1);
        game.setSnake(5,6,2);
        game.setSnake(5,7,3);

        game.leadingCell(5,7);

    }

}
