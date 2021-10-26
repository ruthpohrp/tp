package seedu.address.model.event;

import static java.util.Objects.requireNonNull;

/**
 * Represents a blocked period of time which an Event should not overlap with.
 */
public class BlockedSlot implements Overlappable {

    public static final String MESSAGE_CONSTRAINTS = "Blocked time should be of the format HHmm-HHmm e.g 1300-1400. ";

    public final Date date;
    public final TimeSlot timeSlot;

    public BlockedSlot(Date date, TimeSlot timeSlot) {
        requireNonNull(date);
        requireNonNull(timeSlot);
        this.date = date;
        this.timeSlot = timeSlot;
    }

    @Override
    public boolean overlapsWith(Overlappable overlappable) {
        //TODO: For Ruth to implement.
        return false;
    }
}
