package ua.dp.skillsup.practice.organizer.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ua.dp.skillsup.practice.organizer.domain.EventType;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.util.Date;

public class EventDTO {

    @Size(min=4, max=50, message = "Subject should contain from 4 to 50 characters")
    private String subject;

    @Size(max=1000, message = "not more 1000 characters")
    private String description;

    private String type;

    @Future(message = "Start date should be a future date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDate;

    @Future(message = "End date should be a future date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endDate;

    @Future(message = "Deadline date should be a future date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date deadline;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
