package br.com.fullstack.postit.repositories;

import br.com.fullstack.postit.entities.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
