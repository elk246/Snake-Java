public class Main {



    public static void main(String[] args) throws InterruptedException {
        // add new classes
        Gameboard gameboard= new Gameboard();
        Spawn spawn= new Spawn();

        //set all objects on gameboard
        spawn.setFruits(gameboard);
        spawn.setSnake(gameboard);

        //first gameboard output
        gameboard.printGameboard();
        System.out.println("");

        while(true) {
            gameboard.checkGame();
            System.out.println("");
            gameboard.printGameboard();
        }

    }
}
