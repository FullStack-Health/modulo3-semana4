package br.com.fullstack.postit.entities;

import br.com.fullstack.postit.dtos.ReminderRequest;
import br.com.fullstack.postit.enums.Priority;
import br.com.fullstack.postit.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    private String description;

    @Column(nullable = false /*, columnDefinition = "VARCHAR(120) NOT NULL DEFAULT 'Hoje'" */) // remind_at VARCHAR(120) NOT NULL
    private LocalDateTime remindAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Status status = Status.PENDING;

    public Reminder(ReminderRequest request) {
        BeanUtils.copyProperties(request, this);
    }
}
