package br.com.fullstack.postit.services;

import br.com.fullstack.postit.entities.Reminder;

import java.util.List;

public interface ReminderService {
    // CREATE
    Reminder create(Reminder reminder);

    // READ
    List<Reminder> findAll();
    Reminder findById(Long id);

    // UPDATE
    Reminder update(Long id, Reminder reminder);

    // DELETE
    void delete(Long id);
}
