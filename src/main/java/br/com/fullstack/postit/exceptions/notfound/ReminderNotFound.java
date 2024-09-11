package br.com.fullstack.postit.exceptions.notfound;

public class ReminderNotFound extends NotFoundException {
    public ReminderNotFound(Long id) {
        super("Reminder", id);
    }
}
