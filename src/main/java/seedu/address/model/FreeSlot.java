package seedu.address.model;

import seedu.address.model.event.Date;
import seedu.address.model.event.TimeSlot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FreeSlot {
    public Date date;
    public TimeSlot timeSlot;

    public FreeSlot(Date date, TimeSlot timeSlot) {
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public FreeSlot(LocalDate date, TimeSlot timeSlot) {
        this.date = new Date(date.format(DateTimeFormatter.ISO_DATE));
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString(){
        return date + ": " + timeSlot;
    }
}
