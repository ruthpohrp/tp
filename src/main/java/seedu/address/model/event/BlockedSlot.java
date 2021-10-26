package seedu.address.model.event;

import static java.util.Objects.requireNonNull;

/**
 * Represents a blocked period of time which an Event should not overlap with.
 */
public class BlockedSlot implements Overlappable {

    public static final String SLOT_BLOCKED = "This slot coincides with a blocked period.";

    private final Date date;
    private final TimeSlot timeSlot;

    /**
     * Constructs a BlockedSlot.
     * @param date Date to block.
     * @param timeSlot TimeSlot to block.
     */
    public BlockedSlot(Date date, TimeSlot timeSlot) {
        requireNonNull(date);
        requireNonNull(timeSlot);
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public Date getDate() {
        return date;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
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
     * @return a positive integer if this BlockedSlot's Date and TimeSlot are chronologically before other BlockedSlot,
     * a negative integer if this BlockedSlot's Date and TimeSlot are chronologically after other BlockedSlot,
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

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Date: ")
                .append(getDate())
                .append("; TimeSlot: ")
                .append(getTimeSlot())
                .append(";");

        return builder.toString();
    }
}
