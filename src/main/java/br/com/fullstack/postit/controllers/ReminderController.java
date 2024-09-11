package br.com.fullstack.postit.controllers;

import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.services.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("reminders")
public class ReminderController {

    private final ReminderService service;

    @GetMapping
    public Page<ReminderResponse> get(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public ReminderResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReminderResponse post(@RequestBody ReminderRequest reminder) {
        return service.create(reminder);
    }

    @PutMapping("{id}")
    public ReminderResponse put(
            @PathVariable Long id,
            @RequestBody ReminderRequest reminder
    ) {
        return service.update(id, reminder);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
