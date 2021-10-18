package seedu.address.model.event;


import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * Represents an Event's timeslot in the schedule.
 * Guarantees: immutable; is valid as declared in {@link #isValidTimeSlot(String)}
 */
public class TimeSlot {
    public static final String MESSAGE_CONSTRAINTS = "TimeSlot should be of the format HHmm e.g 1300. ";
    public static final String VALIDATION_REGEX = "^([0-1]?[0-9]|2[0-3])[0-5][0-9]$";
    // TODO: should be changed to: "^([0-1]?[0-9]|2[0-3])[0-5][0-9]$-^([0-1]?[0-9]|2[0-3])[0-5][0-9]$" I THINK

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
    public final LocalTime startTime;
    public final LocalTime endTime;

    /**
     * Constructs a {@code TimeSlot}.
     *
     * @param startTime A valid time for the event.
     */
    public TimeSlot(String startTime, String endTime) {
        requireNonNull(startTime);
        checkArgument(isValidTimeSlot(startTime), MESSAGE_CONSTRAINTS);
        this.startTime = LocalTime.parse(startTime, timeFormatter);
        this.endTime = LocalTime.parse(endTime, timeFormatter);
    }

    /**
     * Returns if a given string is a valid time.
     */
    public static boolean isValidTimeSlot(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getValue() {
        return startTime.format(timeFormatter);
    }

    @Override
    public String toString() {
        return startTime.format(timeFormatter);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TimeSlot // instanceof handles nulls
                && startTime.equals(((TimeSlot) other).startTime)); // state check
    }

    @Override
    public int hashCode() {
        return startTime.hashCode();
    }

}
