package LoicMangele.entities;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long codiceIsbn) {
        super("L'elemento con isbn " + codiceIsbn + " non è stato trovato");
    }
}