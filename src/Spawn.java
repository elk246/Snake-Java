public class Spawn extends Gameboard {

    public void setFruits(Gameboard game){

        game.setFruits((int)(Math.random()* gameboard1.length),(int)(Math.random()* gameboard1[0].length));
        game.setFruits((int)(Math.random()* gameboard1.length),(int)(Math.random()* gameboard1[0].length));
        game.setFruits((int)(Math.random()* gameboard1.length),(int)(Math.random()* gameboard1[0].length));
    }

    public void setSnake(Gameboard game){
        game.setSnake(5,5);
        game.setSnake(5,6);
    }

}
