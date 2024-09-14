package br.com.fullstack.postit.services;

import br.com.fullstack.postit.dtos.ReminderFilter;
import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ReminderService {
    // CREATE
    ReminderResponse create(ReminderRequest reminder);

    // READ
    Page<ReminderResponse> findAll(ReminderFilter filter, Pageable pageable);
    Page<ReminderResponse> findAllCurrent(Pageable pageable);
    Page<ReminderResponse> findAllNext(Pageable pageable);
    ReminderResponse findById(Long id);

    // UPDATE
    ReminderResponse update(Long id, ReminderRequest reminder);

    // DELETE
    void delete(Long id);

    // CHANGE STATUS
    ReminderResponse pending(Long id);
    ReminderResponse done(Long id);
    ReminderResponse changeStatus(Long id, Status status);
}
