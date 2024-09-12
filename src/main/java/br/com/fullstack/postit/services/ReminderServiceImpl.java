package br.com.fullstack.postit.services;

import br.com.fullstack.postit.dtos.ReminderFilter;
import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.dtos.ReminderResponse;
import br.com.fullstack.postit.entities.Reminder;
import br.com.fullstack.postit.exceptions.notfound.ReminderNotFound;
import br.com.fullstack.postit.repositories.ReminderRepository;
import br.com.fullstack.postit.utils.DateUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {
//    private final Logger log = LoggerFactory.getLogger(ReminderServiceImpl.class);

    private final ReminderRepository repository;

    @Override
    public ReminderResponse create(ReminderRequest request) {
        log.info("Creating reminder: {}", request.getTitle());
        Reminder reminder = new Reminder(request);

        ReminderResponse response = save(reminder);
        log.info("Created reminder: {}", response.getTitle());

        return response;
    }

    @Override
    public Page<ReminderResponse> findAll(ReminderFilter filter, Pageable pageable) {
        log.info("Finding all reminders");

        Page<Reminder> reminders;
        if (filter != null && filter.getDateTimeInitial() != null) {
            if (filter.getDateTimeFinal() == null)
                filter.setDateTimeFinal(
                        DateUtility.lastHourOfTheDay(filter.getDateTimeInitial())
                );

            reminders = repository.findAllByRemindAtBetweenOrderByRemindAt(
                    filter.getDateTimeInitial(),
                    filter.getDateTimeFinal(),
                    pageable
            );
        } else {
            pageable.getSortOr(Sort.by("remindAt").ascending());
            reminders = repository.findAll(pageable);
        }

        log.info("{} Reminders found", reminders.getNumberOfElements());
        return reminders.map(ReminderResponse::new);
    }

    @Override
    public ReminderResponse findById(Long id) {
        log.info("Finding reminder with id {}", id);
        Reminder reminder = findEntityById(id);

        log.info("Reminder found with id {}", id);
        return new ReminderResponse(reminder);
    }

    @Override
    public ReminderResponse update(Long id, ReminderRequest request) {
        log.info("Updating reminder with id {}", id);
        Reminder reminder = findEntityById(id);
        BeanUtils.copyProperties(request, reminder);

        ReminderResponse response = save(reminder);
        log.info("Reminder updated with id {}", id);
        return response;
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting reminder with id {}", id);
        findEntityById(id);

        repository.deleteById(id);
        log.info("Reminder deleted with id {}", id);
    }

    private Reminder findEntityById(Long id) {
        log.info("Finding reminder with id {} (ENTITY)", id);
        Reminder response = repository.findById(id).orElseThrow(() -> new ReminderNotFound(id));

        log.info("Reminder found with id {} (ENTITY)", id);
        return response;
    }

    private ReminderResponse save(Reminder reminder) {
        log.info("Saving reminder: {}", reminder.getTitle());
        repository.save(reminder);

        log.info("Reminder saved: {} (id: {})", reminder.getTitle(), reminder.getId());
        return new ReminderResponse(reminder);
    }
}
