package br.com.fullstack.postit.exceptions.notfound;

public abstract class NotFoundException extends RuntimeException {
    public NotFoundException(String entityName, Long id) {
        super(entityName + " not found with id: " + id);
    }
}
