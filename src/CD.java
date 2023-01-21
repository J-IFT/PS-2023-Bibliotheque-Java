public class CD extends Borrowable{
    private final String artist;
    private final int numberOfTracks;

    public CD(int id, String title, String artist, int numberOfTracks) {
        super(id, title);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "library.CD{" +
                "title='" + getTitle() + '\'' +
                ", borrowed=" + isBorrowed() +
                ", artist='" + artist + '\'' +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }


    public String getArtist() {
        return artist;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }
}
