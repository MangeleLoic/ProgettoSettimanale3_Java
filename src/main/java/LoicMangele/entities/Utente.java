package LoicMangele.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tessera", nullable = false, unique = true)
    private long numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
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

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "cognome='" + cognome + '\'' +
                ", numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", prestiti=" + prestiti +
                '}';
    }
}
