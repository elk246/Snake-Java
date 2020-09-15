public class Spawn extends Gameboard {

    public void setFruits(Gameboard game){

        game.setFruits((int)(Math.random()* getGameboard1().length),(int)(Math.random()* getGameboard1().length));
    }

    public void setSnake(Gameboard game){
        game.setSnake(5,5,3);
        game.setSnake(5,6,2);
        game.setSnake(5,7,1);
    }

}
