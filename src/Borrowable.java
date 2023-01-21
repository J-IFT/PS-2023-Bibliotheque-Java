public class Borrowable extends Docs {
    private boolean borrowed;

    public Borrowable(int id, String title) {
        super(id, title);
        this.borrowed = false;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
