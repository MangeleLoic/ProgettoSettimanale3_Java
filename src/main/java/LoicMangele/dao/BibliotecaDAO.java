package LoicMangele.dao;

import LoicMangele.entities.ElementoBibliografico;
import LoicMangele.entities.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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
       try {
           return query.getSingleResult();
       }
       catch (NoResultException e) {
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
}
