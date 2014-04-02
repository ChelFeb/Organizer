package ua.dp.skillsup.practice.organizer.exception.event;

import ua.dp.skillsup.practice.organizer.exception.OrganizerException;

public class EventCreationException extends OrganizerException {

    public EventCreationException() {
    }

    public EventCreationException(String message) {
        super(message);
    }

    public EventCreationException(Throwable exception) {
        super(exception);
    }

}
