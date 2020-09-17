public class Cell {

    private boolean isAlive= false;
    private boolean isFruit= false;
    private int count = 0;
    private boolean isLeading= false;
    private boolean bonus= false;


    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    //getter leading
    public boolean isLeading() {
        return isLeading;
    }

    // setter leading
    public void setLeading(boolean leading) {
        isLeading = leading;
    }

    //alive getter
    public boolean isAlive() {

        return isAlive;
    }

    // alive setter
    public void setAlive(boolean alive) {

        isAlive = alive;
    }

    //fruit getter
    public boolean isFruit() {

        return isFruit;
    }

    //fruit setter
    public void setFruit(boolean fruit) {
        isFruit = fruit;
    }

    //count getter
    public int getCount() {
        return count;
    }

    // count setter
    public void setCount(int counter) {
        this.count = counter;
    }
}
