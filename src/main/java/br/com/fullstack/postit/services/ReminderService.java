package br.com.fullstack.postit.services;

import br.com.fullstack.postit.entities.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReminderService {
    // CREATE
    Reminder create(Reminder reminder);

    // READ
    Page<Reminder> findAll(Pageable pageable);
    Reminder findById(Long id);

    // UPDATE
    Reminder update(Long id, Reminder reminder);

    // DELETE
    void delete(Long id);
}
