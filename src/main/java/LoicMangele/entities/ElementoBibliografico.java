package LoicMangele.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "elemento_bibliografico")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoBibliografico {
    @Id
    @GeneratedValue
    @Column(name = "codice_isbn", nullable = false,unique = true)
    protected long codiceIsbn;
    @Column(name = "titolo")
    protected String Titolo;
    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;
    @Column(name = "numero_pagine")
    protected int numeroPagine;

    public ElementoBibliografico() {
    }

    public ElementoBibliografico(String titolo, int annoPubblicazione, int numeroPagine) {
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getCodiceIsbn() {
        return codiceIsbn;
    }


    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    @Override
    public String toString() {
        return "ElementoBibliografico{" +
                "annoPubblicazione=" + annoPubblicazione +
                ", codiceIsbn=" + codiceIsbn +
                ", Titolo='" + Titolo + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
