public class Magazine extends Borrowable {
    private final String publicationDate;
    private final int issueNumber;


    public Magazine(int id, String title, int issueNumber, String publicationDate) {
        super(id, title);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "bibliotheque.Magazine{" +
                "title='" + getTitle() + '\'' +
                ", publicationData='" + publicationDate + '\'' +
                ", issueNumber=" + issueNumber +
                '}';
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}
