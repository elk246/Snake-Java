public class Cell {

    private boolean isAlive= false;
    private boolean isFruit= false;
    private int count = 0;


    public boolean isAlive() {

        return isAlive;
    }

    public void setAlive(boolean alive) {

        isAlive = alive;
    }

    public boolean isFruit() {

        return isFruit;
    }

    public void setFruit(boolean fruit) {
        isFruit = fruit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int counter) {
        this.count = counter;
    }
}
