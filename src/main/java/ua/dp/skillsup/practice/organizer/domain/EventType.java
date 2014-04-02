package ua.dp.skillsup.practice.organizer.domain;

/**
 * Created by Shaman on 23.03.2014.
 */
public enum EventType {

    TASK("Task"), EVENT("Event"), DEADLINE_EVENT("Deadline Event");

    private String caption;

    EventType(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public static EventType getTypeByCaption(String caption) {
        for (EventType type: EventType.values()) {
            if (type.getCaption().equals(caption)) {
                return type;
            }
        }
        return null;
    }
}
