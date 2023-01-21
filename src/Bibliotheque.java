import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotheque implements java.io.Serializable {
    private final ArrayList<CD> CDs;
    private final ArrayList<DVD> DVDs;
    private final ArrayList<Livre> livres;
    private final ArrayList<Magazine> magazines;

    public Bibliotheque() {
        CDs = new ArrayList<CD>();
        DVDs = new ArrayList<DVD>();
        livres = new ArrayList<Livre>();
        magazines = new ArrayList<Magazine>();
    }

    public void addCD(CD cd) {
        CDs.add(cd);
    }

    public ArrayList<CD> getCDs() {
        return CDs;
    }

    public void addDVD(DVD dvd) {
        DVDs.add(dvd);
    }

    public ArrayList<DVD> getDVDs() {
        return DVDs;
    }

    public void addLivre(Livre livre) {
        livres.add(livre);
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }

    public CD borrowCD(int id) {
        for (CD cd : CDs) {
            if (cd.getID() == id && cd.isBorrowed()) {
                cd.setBorrowed(true);
                return cd;
            }
        }
        return null;
    }

    public DVD borrowDVD(int id) {
        for (DVD dvd : DVDs) {
            if (dvd.getID() == id && dvd.isBorrowed()) {
                dvd.setBorrowed(true);
                return dvd;
            }
        }
        return null;
    }

    public Livre borrowLivre(int id) {
        for (Livre livre : livres) {
            if (livre.getID() == id && livre.isBorrowed()) {
                livre.setBorrowed(true);
                return livre;
            }
        }
        return null;
    }

    public static Bibliotheque getBibliothequeFromDB() {
        Connection connection;
        Bibliotheque bibliotheque = new Bibliotheque();

        try {
            connection = Main.getConnection();

            for (Livre livre : Main.getLivres(connection)) {
                bibliotheque.addLivre(livre);
            }

            for (CD cd : Main.getCDs(connection)) {
                bibliotheque.addCD(cd);
            }

            for (DVD dvd : Main.getDVDs(connection)) {
                bibliotheque.addDVD(dvd);
            }

            for (Magazine magazine : Main.getMagazines(connection)) {
                bibliotheque.addMagazine(magazine);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibliotheque;
    }

    public static void dbToFile(String fileName) {
        Bibliotheque bibliotheque = getBibliothequeFromDB();

        try {
            FileOutputStream fileOut = new FileOutputStream("./serialization/" + fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(bibliotheque);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void fileToDB(String fileName) {
        try {
            FileInputStream file = new FileInputStream("./serialization/" + fileName + ".ser");
            ObjectInputStream in = new ObjectInputStream(file);

            Bibliotheque bibliotheque = (Bibliotheque) in.readObject();

            in.close();
            file.close();

            Main.setLivres(bibliotheque.livres);
            Main.setCDs(bibliotheque.CDs);
            Main.setDVDs(bibliotheque.DVDs);
            Main.setMagazines(bibliotheque.magazines);

            System.out.println("Object has been deserialized and added to db");
            System.out.println(bibliotheque);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int action = input.nextInt();
        String fileName = input.nextLine();

        switch (action) {
            case 1 -> fileToDB(fileName);
            case 2 -> dbToFile(fileName);
            default -> System.out.println("Choisissez une action valide");
        }
    }
}
