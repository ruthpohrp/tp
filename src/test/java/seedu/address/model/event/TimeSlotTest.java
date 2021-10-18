package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TimeSlotTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeSlot(null, null));
    }

    @Test
    public void constructor_invalidTime_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new TimeSlot(invalidTime, invalidTime));
    }

    @Test
    public void isValidTimeSlot() {
        // null startTime
        assertThrows(NullPointerException.class, () -> TimeSlot.isValidTimeSlot(null, "1300"));
        // null endTime
        assertThrows(NullPointerException.class, () -> TimeSlot.isValidTimeSlot("1300", null));

        // blank startTime
        assertFalse(TimeSlot.isValidTimeSlot("", "1300")); // empty string
        assertFalse(TimeSlot.isValidTimeSlot(" ", "1300")); // spaces only
        // blank endTime
        assertFalse(TimeSlot.isValidTimeSlot("1300", "")); // empty string
        assertFalse(TimeSlot.isValidTimeSlot("1300", " ")); // spaces only

        // invalid startTime
        assertFalse(TimeSlot.isValidTimeSlot("15", "1600")); // missing minutes
        assertFalse(TimeSlot.isValidTimeSlot("04:30", "0500")); // ':' not allowed in time

        // invalid endTime
        assertFalse(TimeSlot.isValidTimeSlot("1400", "15")); // missing minutes
        assertFalse(TimeSlot.isValidTimeSlot("0400", "04:30")); // ':' not allowed in time

        // invalid startTime endTime combo (endTime comes before startTime)
        assertFalse(TimeSlot.isValidTimeSlot("1300", "1200"));

        // valid TimeSlot
        assertTrue(TimeSlot.isValidTimeSlot("2030", "2130"));
        assertTrue(TimeSlot.isValidTimeSlot("0715", "0815"));

    }
}
