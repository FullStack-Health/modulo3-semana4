package br.com.fullstack.postit.repositories;

import br.com.fullstack.postit.entities.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    Page<Reminder> findAllByRemindAtBetweenOrderByRemindAt(LocalDateTime dateTimeInitial,
                                                           LocalDateTime dateTimeFinal,
                                                           Pageable pageable);

}
