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
    public static final String TIMESLOT_BLOCKED = "TimeSlot coincides with a blocked period.";
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
        checkArgument(!isBlocked(startTime, endTime), TIMESLOT_BLOCKED);
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
     * Add a new TimeSlot to blockedTimeSlots.
     * @param startTime start time of blocked period.
     * @param endTime end time of blocked period.
     */
    public static void block(String startTime, String endTime) {
        //TODO: create isBlockable(TimeSlot timeSlot) to check if given timeslot can be blocked
        //(e.g. user has an event 1200-1400 but tries to block 1300-1400)
        TimeSlot timeSlot = new TimeSlot(startTime, endTime);
        blockedTimeSlots.add(timeSlot);
    }

    /**
     * Checks if given TimeSlot is blocked.
     * @param startTime start time to be tested.
     * @param endTime end time to be tested.
     * @return true if the given TimeSlot is blocked, false otherwise.
     */
    public static boolean isBlocked(String startTime, String endTime) {
        for (TimeSlot blockedTimeSlot : blockedTimeSlots) {
            if (blockedTimeSlot.overlaps(startTime, endTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if other TimeSlot has an overlap with this instance of TimeSlot.
     * @param otherStartTimeString start time to be tested.
     * @param otherEndTimeString end time to be tested.
     * @return true if there is an overlap, false otherwise.
     */
    public boolean overlaps(String otherStartTimeString, String otherEndTimeString) {
        LocalTime otherStartTime = LocalTime.parse(otherStartTimeString, timeFormatter);
        LocalTime otherEndTime = LocalTime.parse(otherEndTimeString, timeFormatter);
        return otherStartTime.compareTo(this.endTime) < 0
                && this.startTime.compareTo(otherEndTime) < 0;
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
}
