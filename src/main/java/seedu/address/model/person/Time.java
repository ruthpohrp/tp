package seedu.address.model.person;


import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an Event's time in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTime(String)}
 */
public class Time {
    public static final String MESSAGE_CONSTRAINTS = "Time should be of the format HHmm e.g 1300. ";
    public static final String VALIDATION_REGEX = "^([0-1]?[0-9]|2[0-3])[0-5][0-9]$";

    public final LocalTime time;
    private static final DateTimeFormatter timeFormatter =  DateTimeFormatter.ofPattern("HHmm");

    /**
     * Constructs an {@code Time}.
     *
     * @param time A valid time for the event.
     */
    public Time(String time) {
        requireNonNull(time);
        checkArgument(isValidTime(time), MESSAGE_CONSTRAINTS);
        this.time = LocalTime.parse(time, timeFormatter);
    }

    /**
     * Returns if a given string is a valid time.
     */
    public static boolean isValidTime(String test) {
//        try {
//            LocalTime.parse(test, timeFormatter);
//            return true;
//        } catch (DateTimeParseException t) {
//            return false;
//        }

        return test.matches(VALIDATION_REGEX);
    }

    public String getTime() {
        return time.format(timeFormatter);
    }

    @Override
    public String toString() {
        return time.format(timeFormatter);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Time // instanceof handles nulls
                && time.equals(((Time) other).time)); // state check
    }

    @Override
    public int hashCode() {
        return time.hashCode();
    }

}
