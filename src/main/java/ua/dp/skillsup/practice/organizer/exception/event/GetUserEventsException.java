package ua.dp.skillsup.practice.organizer.exception.event;

import ua.dp.skillsup.practice.organizer.exception.OrganizerException;

public class GetUserEventsException extends OrganizerException {
    public GetUserEventsException() {
    }

    public GetUserEventsException(String message) {
        super(message);
    }

    public GetUserEventsException(Throwable exception) {
        super(exception);
    }
}
