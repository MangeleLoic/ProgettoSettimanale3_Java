package LoicMangele;

import LoicMangele.dao.BibliotecaDAO;
import LoicMangele.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoSettimanale3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BibliotecaDAO eb = new BibliotecaDAO(em);

        Libro harryPotter1 = new Libro("Harry Potter e la pietra filosofale", 1997, 309, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter2 = new Libro("Harry Potter e la camera dei segreti", 1998, 341, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter3 = new Libro("Harry Potter e il prigioniero di Azkaban", 1999, 435, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter4 = new Libro("Harry Potter e il calice di fuoco", 2000, 636, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter5 = new Libro("Harry Potter e l'Ordine della fenice", 2003, 766, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter6 = new Libro("Harry Potter e il principe mezzosangue", 2005, 607, "J. K.Rowling", Genere.FANTASY );
        Libro harryPotter7 = new Libro("Harry Potter e i Doni della Morte", 2007, 607, "J. K.Rowling", Genere.FANTASY );
        Libro ioRobot = new Libro("IO, Robot", 1950, 253, "Isaac Asimov", Genere.FANTASCIENZA);
        Libro ioSonoLeggenda = new Libro("Io sono Leggenda", 1954, 160, "Richard Matheson", Genere.FANTASCIENZA);
        Libro laTeoriaDElTutto = new Libro("laTeoria dEl Tutto", 2002, 176, "Stephen Hawking", Genere.FANTASCIENZA);
        Libro assassinioOrientExpress = new Libro("Assasinio sull'Orient Express", 1934, 256, "Agatha Christie", Genere.GIALLO);
        Libro ilSilenzioDegliInnocenti = new Libro("il silenzio degli innocenti", 1988, 367, "Thomas Harris", Genere.GIALLO);
        Libro ilMastinoDeiBaskerville = new Libro("Il mastino dei Baskerville", 1902, 256, "Arthur Conan Doyle", Genere.GIALLO);
        Libro lePagineDellNostraVita = new Libro("Le pagine della nostra vita", 1996, 214, "Nicholas Sparks", Genere.ROMANTICO);
        Libro ultimoBacio = new Libro("L'ultimo bacio", 2008, 448, "Sveva Casati Modignani", Genere.ROMANTICO);
        Riviste nationalGeographic = new Riviste("National Geographic", 2024, 120, Periodicita.MENSILE);
        Riviste nationalGeographic2 = new Riviste("National Geographic", 2023, 130, Periodicita.MENSILE);
        Riviste nationalGeographic3 = new Riviste("National Geographic", 2022, 115, Periodicita.MENSILE);
        Riviste shonenJump = new Riviste("Shonen Jump", 2024, 215, Periodicita.SETTIMANALE);
        Riviste shonenJump2 = new Riviste("Shonen Jump", 2023, 245, Periodicita.SETTIMANALE);
        Riviste shonenJump3 = new Riviste("Shonen Jump", 2021, 190, Periodicita.SETTIMANALE);
        Riviste mulino = new Riviste("IlMulino", 2010, 160, Periodicita.SEMESTRALE);
        Riviste mulino2 = new Riviste("IlMulino", 2008, 130, Periodicita.SEMESTRALE);

       /* eb.save(harryPotter1);
        eb.save(harryPotter2);
        eb.save(harryPotter3);
        eb.save(harryPotter4);
        eb.save(harryPotter5);
        eb.save(harryPotter6);
        eb.save(harryPotter7);
        eb.save(ioRobot);
        eb.save(ioSonoLeggenda);
        eb.save(laTeoriaDElTutto);
        eb.save(assassinioOrientExpress);
        eb.save(ilSilenzioDegliInnocenti);
        eb.save(ilMastinoDeiBaskerville);
        eb.save(lePagineDellNostraVita);
        eb.save(ultimoBacio);
        eb.save(nationalGeographic);
        eb.save(nationalGeographic2);
        eb.save(nationalGeographic3);
        eb.save(shonenJump);
        eb.save(shonenJump2);
        eb.save(shonenJump3);
        eb.save(mulino);
        eb.save(mulino2); */

        //lascio questi elementi commentati per non duplicare i salvataggi

        try {

            ElementoBibliografico elementoBibliografico4 = eb.findByISBN(86);


            System.out.println(elementoBibliografico4);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            ElementoBibliografico elementoBibliografico = eb.findByISBN(21);


            System.out.println(elementoBibliografico);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {

            ElementoBibliografico elementoBibliografico2 = eb.findByISBN(3);



            System.out.println(elementoBibliografico2);

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<ElementoBibliografico> elementoBibliografico3 = eb.findByYear(2005);
        List<ElementoBibliografico> elementoBibliografico5 = eb.findByYear(2035);
        System.out.println(elementoBibliografico3);
        System.out.println(elementoBibliografico5);

        List<ElementoBibliografico> elementoBibliografico6 = eb.findByAuthor("J. K.Rowling");
        System.out.println(elementoBibliografico6);

        List<ElementoBibliografico> elementoBibliografico7 = eb.findByTitleOrPartOF("Shonen Jump");
        System.out.println(elementoBibliografico7);
        List<ElementoBibliografico> elementoBibliografico8 = eb.findByTitleOrPartOF("Harry");
        System.out.println(elementoBibliografico8);


        em.close();
        emf.close();
    }

}
