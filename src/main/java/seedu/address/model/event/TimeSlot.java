package seedu.address.model.event;


import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * Represents an Event's timeslot in the schedule.
 * Guarantees: immutable; is valid as declared in {@link #isValidTimeSlot(String, String)}
 */
public class TimeSlot {
    public static final String MESSAGE_CONSTRAINTS = "TimeSlot should be of the format HHmm e.g 1300-1400. ";
    public static final String VALIDATION_REGEX = "^([0-1]?[0-9]|2[0-3])[0-5][0-9]$";

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
    private static final ArrayList<TimeSlot> blockedTimeSlots = new ArrayList<>();
    public final LocalTime startTime;
    public final LocalTime endTime;

    /**
     * Constructs a {@code TimeSlot}.
     *
     * @param startTime A valid time for the event.
     */
    public TimeSlot(String startTime, String endTime) {
        requireNonNull(startTime);
        requireNonNull(endTime);
        checkArgument(isValidTimeSlot(startTime, endTime), MESSAGE_CONSTRAINTS);
        this.startTime = LocalTime.parse(startTime, timeFormatter);
        this.endTime = LocalTime.parse(endTime, timeFormatter);
    }

    /**
     * Returns if a given string is a valid TimeSlot. For a TimeSlot to be valid, its endTime must come after
     * its startTime.
     */
    public static boolean isValidTimeSlot(String testStartTime, String testEndTime) {
        return testStartTime.matches(VALIDATION_REGEX) && testEndTime.matches(VALIDATION_REGEX)
                && Integer.parseInt(testEndTime) > Integer.parseInt(testStartTime);
    }

    /**
     * Checks if given TimeSlot is blocked.
     * @param timeSlot TimeSlot to be checked.
     * @return true if the given TimeSlot is blocked, false otherwise.
     */
    //TODO: write tests
    public static boolean isBlocked(TimeSlot timeSlot) {
        for (TimeSlot blockedTimeSlot : blockedTimeSlots) {
            if (timeSlot.overlaps(blockedTimeSlot)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if other TimeSlot has an overlap with this instance of TimeSlot.
     * @param other another TimeSlot.
     * @return true if there is an overlap, false otherwise.
     */
    //TODO: write tests
    public boolean overlaps(TimeSlot other) {
        return other.startTime.compareTo(this.endTime) < 0
                && this.startTime.compareTo(other.endTime) < 0;
    }

    public String startTimeToString() {
        return startTime.format(timeFormatter);
    }

    public String endTimeToString() {
        return endTime.format(timeFormatter);
    }

    /**
     * Compares a TimeSlot's startTime with another.
     * @param other other TimeSlot to compare to.
     * @return a positive integer if this TimeSlot started earlier than the other, a negative integer if this TimeSlot
     * started later than the other and zero if the 2 TimeSlots started at the same time.
     */
    public int compareTo(TimeSlot other) {
        return startTime.compareTo(other.startTime);
    }

    @Override
    public String toString() {
        return startTime.format(timeFormatter) + "-" + endTime.format(timeFormatter);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TimeSlot // instanceof handles nulls
                && startTime.equals(((TimeSlot) other).startTime)
                && endTime.equals(((TimeSlot) other).endTime)); // state check for both time fields
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Add a new TimeSlot to blockedTimeSlots.
     * @param timeSlot a new TimeSlot to block.
     */
    public void block(TimeSlot timeSlot) {
        //TODO: create isBlockable(TimeSlot timeSlot) to check if given timeslot can be blocked. (For now assume correct
        //inputs)
        blockedTimeSlots.add(timeSlot);
    }
}
