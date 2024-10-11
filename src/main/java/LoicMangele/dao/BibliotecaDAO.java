package LoicMangele.dao;

import LoicMangele.entities.ElementoBibliografico;
import LoicMangele.entities.NotFoundException;
import LoicMangele.entities.Prestito;
import LoicMangele.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class BibliotecaDAO {
    private final EntityManager entityManager;

    public BibliotecaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ElementoBibliografico elementoBibliografico) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoBibliografico);
        transaction.commit();

        System.out.println("L'elemento bibliografico " + elementoBibliografico.getTitolo() + " è stato saòvato con successo");
    }

    public ElementoBibliografico findByISBN(long codiceIsbn) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT e FROM ElementoBibliografico e WHERE e.codiceIsbn = :isbn", ElementoBibliografico.class);
        query.setParameter("isbn", codiceIsbn);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundException(codiceIsbn);
        }

    }


    public List<ElementoBibliografico> findByYear(int annoPubblicazione) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT e FROM ElementoBibliografico e WHERE e.annoPubblicazione = :annoPubblicazione", ElementoBibliografico.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();


    }

    public List<ElementoBibliografico> findByAuthor(String autore) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT e FROM ElementoBibliografico e WHERE e.autore = :autore", ElementoBibliografico.class);
        query.setParameter("autore", autore);
        return query.getResultList();

    }

    public List<ElementoBibliografico> findByTitleOrPartOF(String partialTitle) {
        TypedQuery<ElementoBibliografico> query = entityManager.createNamedQuery("findByTitleOrPartOF", ElementoBibliografico.class);
        query.setParameter("partialTitle", "%" + partialTitle + "%");
        return query.getResultList();
    }

    public void Delete(long codiceIsbn) {
        ElementoBibliografico found = this.findByISBN(codiceIsbn);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("L'elemento Bibliografico " + found.getTitolo() + " è stato rimosso con successo");
    }

    public void saveUtente(Utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();

        System.out.println("L'utente " + utente.getNome() + " " + utente.getCognome() + " è stato salvato con successo");
    }

    public void savePrestito(Prestito prestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestito);
        transaction.commit();

        System.out.println("Il prestito " + prestito.getPrestitoId() + " è stato salvato con successo");
    }

    public List<ElementoBibliografico> findPrestitiAttiviByNumeroDiTessera(long numeroTessera) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT p.elementoBibliografico FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL", ElementoBibliografico.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public void prestitoRestituito(long prestitoId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Prestito prestito = entityManager.find(Prestito.class, prestitoId);
        if (prestito != null) {
            prestito.setDataRestituzioneEffettiva(LocalDate.now());
            entityManager.merge(prestito);
            System.out.println("Prestito restituito con successo");
        } else {
            System.out.println("prestito non trovato");
        }
        transaction.commit();


    }
}
