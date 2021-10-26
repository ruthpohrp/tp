package seedu.address.model;

import seedu.address.model.event.Date;
import seedu.address.model.event.TimeSlot;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class FreeSlot {
    public Date date;
    public TimeSlot timeSlot;

    public FreeSlot(Date date, TimeSlot timeSlot) {
        requireNonNull(date);
        requireNonNull(timeSlot);
        this.date = date;
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString(){
        return date + ": " + timeSlot;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FreeSlot // instanceof handles nulls
                && date.equals(((FreeSlot) other).date)
                && timeSlot.equals(((FreeSlot) other).timeSlot)); // state check for both fields
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, timeSlot);
    }
}
