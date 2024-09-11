package br.com.fullstack.postit.services;

import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.entities.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReminderService {
    // CREATE
    ReminderResponse create(ReminderRequest reminder);

    // READ
    Page<ReminderResponse> findAll(Pageable pageable);
    ReminderResponse findById(Long id);

    // UPDATE
    ReminderResponse update(Long id, ReminderRequest reminder);

    // DELETE
    void delete(Long id);
}
