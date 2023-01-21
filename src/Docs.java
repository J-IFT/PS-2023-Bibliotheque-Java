public class Docs implements java.io.Serializable {
    private int id;
    private String title;

    public Docs(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
