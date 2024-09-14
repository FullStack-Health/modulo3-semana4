package br.com.fullstack.postit.controllers;

import br.com.fullstack.postit.dtos.ReminderFilter;
import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.services.ReminderService;
import br.com.fullstack.postit.utils.JsonUtility;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Tag(name = "Reminders", description = "Create/Read/Update/Delete")
@RestController
@RequiredArgsConstructor
@RequestMapping("reminders")
public class ReminderController {
//    private final Logger log = LoggerFactory.getLogger(ReminderController.class);

    private final ReminderService service;

    @GetMapping
    @Operation(description = "Find all reminders", summary = "Find reminders")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success") })
    public Page<ReminderResponse> get(
            @ParameterObject() ReminderFilter filter,
            @ParameterObject() @PageableDefault() Pageable pageable
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
    @Operation(summary = "Find reminder by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success") })
    public ReminderResponse getById(
            @Parameter(example = "1", description = "Reminder id")
            @PathVariable Long id
    ) {
        log.info("GET /reminders/{} -> Begin", id);
        ReminderResponse response = service.findById(id);

        log.info("GET /reminders/{} -> End", id);
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create reminder")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Success") })
    public ReminderResponse post(@RequestBody ReminderRequest reminder) {
        log.info("POST /reminders -> Begin");
        ReminderResponse response = service.create(reminder);

        log.info("POST /reminders -> End");
        return response;
    }

    @PutMapping("{id}")
    @Operation(summary = "Update reminder by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success") })
    public ReminderResponse put(
            @Parameter(example = "1", description = "Reminder id")
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
    @Operation(summary = "Delete reminder by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Success") })
    public void delete(
            @Parameter(example = "1", description = "Reminder id")
            @PathVariable Long id
    ) {
        log.info("DELETE /reminders/{} -> Begin", id);
        service.delete(id);
        log.info("DELETE /reminders/{} -> End", id);
    }
}
