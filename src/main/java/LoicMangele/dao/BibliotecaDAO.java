package LoicMangele.dao;

import LoicMangele.entities.ElementoBibliografico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BibliotecaDAO {
    private final EntityManager entityManager;

    public BibliotecaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  void save(ElementoBibliografico elementoBibliografico) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoBibliografico);
        transaction.commit();

        System.out.println("L'elemento bibliografico " + elementoBibliografico.getTitolo() + " è stato saòvato con successo");
    }

    public ElementoBibliografico findByISBN(long codiceIsbn) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT e FROM ElementoBibliografico e WHERE e.codiceIsbn = :isbn", ElementoBibliografico.class);
        query.setParameter("isbn", codiceIsbn);
        return query.getSingleResult();


    }

    public List<ElementoBibliografico> findByYear(int annoPubblicazione) {
        TypedQuery<ElementoBibliografico> query = entityManager.createQuery("SELECT e FROM ElementoBibliografico e WHERE e.annoPubblicazione = :annoPubblicazione", ElementoBibliografico.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();


    }
}
