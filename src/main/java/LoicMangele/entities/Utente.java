package LoicMangele.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    public Utente() {
    }

    public Utente(String cognome, LocalDate dataDiNascita, String nome) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.nome = nome;

    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "cognome='" + cognome + '\'' +
                ", numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
