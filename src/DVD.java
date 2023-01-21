public class DVD extends Borrowable{
    private final String director;
    private final String studio;

    public DVD(int id, String title, String director, String studio) {
        super(id, title);
        this.director = director;
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "bibliotheque.DVD{" +
                "title='" + getTitle() + '\'' +
                ", borrowed=" + isBorrowed() +
                ", director='" + director + '\'' +
                ", studio='" + studio + '\'' +
                '}';
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }
}
