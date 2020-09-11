public class Spawn extends Gameboard {

    public static void setFruits( Gameboard game){

        game.setFruits((int)(Math.random()*10),(int)(Math.random()*10));
        game.setFruits((int)(Math.random()*10),(int)(Math.random()*10));
        game.setFruits((int)(Math.random()*10),(int)(Math.random()*10));

    }

}
