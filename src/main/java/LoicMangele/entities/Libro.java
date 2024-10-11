package LoicMangele.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "libri")
public class Libro extends ElementoBibliografico {

    private String autore;
    @Enumerated(EnumType.STRING)
    private  Genere genere;

    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                ", annoPubblicazione=" + annoPubblicazione +
                ", codiceIsbn=" + codiceIsbn +
                ", numeroPagine=" + numeroPagine +
                ", Titolo='" + Titolo + '\'' +
                '}';
    }
}
