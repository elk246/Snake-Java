public class Main {



    public static void main(String[] args) throws InterruptedException {
        Gameboard gameboard= new Gameboard();
        Spawn spawn= new Spawn();
        spawn.setFruits(gameboard);
        gameboard.printGameboard();

    }
}
