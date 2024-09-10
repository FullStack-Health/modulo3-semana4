package br.com.fullstack.postit.services;

import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.repositories.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository repository;

    @Override
    public Reminder create(Reminder reminder) {
        reminder.setId(null);
        return repository.save(reminder);
    }

    @Override
    public Page<Reminder> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Reminder findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reminder not found with id: " + id));
    }

    @Override
    public Reminder update(Long id, Reminder reminder) {
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
