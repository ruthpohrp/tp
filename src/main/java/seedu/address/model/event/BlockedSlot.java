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
    public boolean isOverlappingWith(Overlappable overlappable) {
        //TODO: For Ruth to implement.
        return false;
    }

    /**
     * Compares this BlockedSlot instance with another BlockedSlot instance.
     *
     * @param other other BlockedSlot to compare to.
     * @return a positive integer if this BlockedSlot's Date and timeSlot are chronologically before other BlockedSlot,
     * a negative integer if this BlockedSlot's Date and timeSlot are chronologically after other BlockedSlot,
     * zero if both BlockedSlots are on the same date and start at the same time.
     */
    public int compareTo(BlockedSlot other) {
        int compareDate = date.compareTo(other.date);
        if (compareDate != 0) {
            return compareDate;
        } else {
            return timeSlot.compareTo(other.timeSlot);
        }
    }
}
