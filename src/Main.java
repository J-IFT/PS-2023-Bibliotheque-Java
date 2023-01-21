import java.sql.*;
import java.util.ArrayList;


public class Main {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dmjava_juliette_jeremy_brice_flavien";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            //Register the JDBC driver
            Class.forName(DB_DRIVER);

            //Open the connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (connection != null) {
                System.out.println("Successfully connected.");
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<Livre> getLivres(Connection connection) {
        PreparedStatement preparedStatement;
        ArrayList<Livre> livres = new ArrayList<Livre>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM livre");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int publication_year = resultSet.getInt("publication_year");

                Livre livre = new Livre(id, title, author, publication_year);
                livres.add(livre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return livres;
    }

    public static void setLivres(ArrayList<Livre> livres) {
        PreparedStatement preparedStatement;
        Connection connection;
        String query = "INSERT INTO livres VALUES(NULL, %d, '%s', '%s', %d, %d)";
        try {
            connection = getConnection();
            for (Livre livre : livres) {
                preparedStatement = connection.prepareStatement(query.formatted(
                        livre.getID(),
                        livre.getTitle(),
                        livre.getAuthor(),
                        livre.getPublicationYear(),
                        livre.isBorrowed() ? 1 : 0
                ));
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<CD> getCDs(Connection connection) {
        PreparedStatement preparedStatement;
        ArrayList<CD> cds = new ArrayList<CD>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cd");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                int numberOfTracks = resultSet.getInt("number_of_tracks");

                CD cd = new CD(id, title, artist, numberOfTracks);
                cds.add(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cds;
    }

    public static void setCDs(ArrayList<CD> cds) {
        PreparedStatement preparedStatement;
        Connection connection;
        String query = "INSERT INTO cd VALUES(NULL, %d, '%s', '%s', %d, %d)";
        try {
            connection = getConnection();
            for (CD cd : cds) {
                preparedStatement = connection.prepareStatement(query.formatted(
                        cd.getID(),
                        cd.getTitle(),
                        cd.getArtist(),
                        cd.getNumberOfTracks(),
                        cd.isBorrowed() ? 1 : 0
                ));
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<DVD> getDVDs(Connection connection) {
        PreparedStatement preparedStatement;
        ArrayList<DVD> dvds = new ArrayList<DVD>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM dvd");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                String studio = resultSet.getString("studio");

                DVD dvd = new DVD(id, title, director, studio);
                dvds.add(dvd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dvds;
    }

    public static void setDVDs(ArrayList<DVD> dvds) {
        PreparedStatement preparedStatement;
        Connection connection;
        String query = "INSERT INTO dvd VALUES(NULL, %d, '%s', '%s', '%s', %d)";
        try {
            connection = getConnection();
            for (DVD dvd : dvds) {
                preparedStatement = connection.prepareStatement(query.formatted(
                        dvd.getID(),
                        dvd.getTitle(),
                        dvd.getDirector(),
                        dvd.getStudio(),
                        dvd.isBorrowed() ? 1 : 0
                ));
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Magazine> getMagazines(Connection connection) {
        PreparedStatement preparedStatement;
        ArrayList<Magazine> magazines = new ArrayList<Magazine>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM magazine");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int issueNumber = resultSet.getInt("issue_number");
                String publicationDate = resultSet.getString("publication_date");

                Magazine magazine = new Magazine(id, title, issueNumber, publicationDate);
                magazines.add(magazine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return magazines;
    }

    public static void setMagazines(ArrayList<Magazine> magazines) {
        PreparedStatement preparedStatement;
        Connection connection;
        String query = "INSERT INTO magazine VALUES(NULL, %d, '%s', %d, '%s')";
        try {
            connection = getConnection();
            for (Magazine magazine : magazines) {
                preparedStatement = connection.prepareStatement(query.formatted(
                        magazine.getID(),
                        magazine.getTitle(),
                        magazine.getIssueNumber(),
                        magazine.getPublicationDate()
                ));
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
