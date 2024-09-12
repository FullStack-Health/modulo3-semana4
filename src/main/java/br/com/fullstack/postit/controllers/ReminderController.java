package br.com.fullstack.postit.controllers;

import br.com.fullstack.postit.dtos.ReminderFilter;
import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.services.ReminderService;
import br.com.fullstack.postit.utils.JsonUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("reminders")
public class ReminderController {
//    private final Logger log = LoggerFactory.getLogger(ReminderController.class);

    private final ReminderService service;

    @GetMapping
    public Page<ReminderResponse> get(
            ReminderFilter filter,
            Pageable pageable
    ) {
        log.info("GET /reminders -> Begin");
        Page<ReminderResponse> response = service.findAll(
                filter,
                pageable
        );

        log.info("GET /reminders -> End");
        return response;
    }

    @GetMapping("{id}")
    public ReminderResponse getById(@PathVariable Long id) {
        log.info("GET /reminders/{} -> Begin", id);
        ReminderResponse response = service.findById(id);

        log.info("GET /reminders/{} -> End", id);
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReminderResponse post(@RequestBody ReminderRequest reminder) {
        log.info("POST /reminders -> Begin");
        ReminderResponse response = service.create(reminder);

        log.info("POST /reminders -> End");
        return response;
    }

    @PutMapping("{id}")
    public ReminderResponse put(
            @PathVariable Long id,
            @RequestBody ReminderRequest reminder
    ) {
        log.info("PUT /reminders/{} -> Begin", id);

        if (log.isDebugEnabled())
            log.debug("PUT /reminders/{} -> RequestBody: {}", id, JsonUtility.toJson(reminder));

        ReminderResponse response = service.update(id, reminder);

        if (log.isDebugEnabled())
            log.debug("PUT /reminders/{} -> ResponseBody: {}", id, JsonUtility.toJson(response));

        log.info("PUT /reminders/{} -> End", id);
        return response;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.info("DELETE /reminders/{} -> Begin", id);
        service.delete(id);
        log.info("DELETE /reminders/{} -> End", id);
    }
}
