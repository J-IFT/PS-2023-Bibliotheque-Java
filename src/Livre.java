public class Livre extends Borrowable {
    private final String author;
    private final int publicationYear;

    public Livre(int id, String title, String author, int publicationYear) {
        super(id, title);
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String toString() {
        return "bibliotheque.Livre{" +
                "title='" + getTitle() + '\'' +
                ", borrowed=" + isBorrowed() +
                ", author='" + author + '\'' +
                ", editionNumber=" + publicationYear +
                '}';
    }
    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
