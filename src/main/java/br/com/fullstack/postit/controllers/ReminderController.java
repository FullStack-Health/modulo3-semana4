package br.com.fullstack.postit.controllers;

import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.services.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("reminders")
public class ReminderController {

    private final ReminderService service;

    @GetMapping
    public Page<Reminder> get(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public Reminder getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Reminder post(@RequestBody Reminder reminder) {
        return service.create(reminder);
    }

    @PutMapping("{id}")
    public Reminder put(@PathVariable Long id, @RequestBody Reminder reminder) {
        return service.update(id, reminder);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
