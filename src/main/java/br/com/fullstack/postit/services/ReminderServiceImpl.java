package br.com.fullstack.postit.services;

import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.exceptions.notfound.ReminderNotFound;
import br.com.fullstack.postit.repositories.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository repository;

    @Override
    public ReminderResponse create(ReminderRequest request) {
        Reminder reminder = new Reminder(request);
        repository.save(reminder);
        return new ReminderResponse(reminder);
    }

    @Override
    public Page<ReminderResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ReminderResponse findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ReminderNotFound(id));
    }

    @Override
    public ReminderResponse update(Long id, ReminderRequest reminder) {
        findById(id);
        reminder.setId(id);
        return repository.save(reminder);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
