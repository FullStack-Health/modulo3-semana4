package br.com.fullstack.postit.repositories;

import br.com.fullstack.postit.entities.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    // DerivedQuery
    Page<Reminder> findAllByRemindAtBetweenOrderByRemindAt(LocalDateTime dateTimeInitial,
                                                           LocalDateTime dateTimeFinal,
                                                           Pageable pageable);

    // JPQL
    @Query("select r from Reminder r where r.remindAt > CURRENT_TIMESTAMP order by r.remindAt")
    Page<Reminder> findAllByRemindAtAfterNowOrderByRemindAt(Pageable pageable);

}
