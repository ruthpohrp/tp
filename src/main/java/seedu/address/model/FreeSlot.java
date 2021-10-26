package seedu.address.model;

import seedu.address.model.event.Date;
import seedu.address.model.event.TimeSlot;

public class FreeSlot {
    public Date date;
    public TimeSlot timeSlot;

    public FreeSlot(Date date, TimeSlot timeSlot) {
        this.date = date;
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString(){
        return date + ": " + timeSlot;
    }
}
