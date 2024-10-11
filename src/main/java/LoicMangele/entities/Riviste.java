package LoicMangele.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Riviste extends ElementoBibliografico {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Riviste() {
    }

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                ", annoPubblicazione=" + annoPubblicazione +
                ", codiceIsbn=" + codiceIsbn +
                ", numeroPagine=" + numeroPagine +
                ", Titolo='" + titolo + '\'' +
                '}';
    }
}
