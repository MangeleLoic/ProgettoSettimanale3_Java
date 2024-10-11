package LoicMangele.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prestitoId;

    @ManyToOne
    @JoinColumn(name = "utente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_bibliografico_id")
    private ElementoBibliografico elementoBibliografico;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, LocalDate dataInizioPrestito, ElementoBibliografico elementoBibliografico) {
        this.utente= utente;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcolaDataRestituzionePrevista(dataInizioPrestito);
        this.dataRestituzioneEffettiva = null;
        this.elementoBibliografico =elementoBibliografico;



    }

    private LocalDate calcolaDataRestituzionePrevista(LocalDate dataInizioPrestito){
        return dataInizioPrestito.plusDays(30);
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcolaDataRestituzionePrevista(dataInizioPrestito);
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public long getPrestitoId() {
        return prestitoId;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoBibliografico getElementoBibliografico() {
        return elementoBibliografico;
    }

    public void setElementoBibliografico(ElementoBibliografico elementoBibliografico) {
        this.elementoBibliografico = elementoBibliografico;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "dataInizioPrestito=" + dataInizioPrestito +
                ", prestitoId=" + prestitoId +
                ", utente=" + utente +
                ", elementoBibliografico=" + elementoBibliografico +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
