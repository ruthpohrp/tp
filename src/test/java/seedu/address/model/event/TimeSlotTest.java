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
    public void isValidTime() {
        // null time
        assertThrows(NullPointerException.class, () -> TimeSlot.isValidTimeSlot(null));

        // blank time
        assertFalse(TimeSlot.isValidTimeSlot("")); // empty string
        assertFalse(TimeSlot.isValidTimeSlot(" ")); // spaces only

        // invalid time
        assertFalse(TimeSlot.isValidTimeSlot("15")); // missing minutes
        assertFalse(TimeSlot.isValidTimeSlot("04:30")); // ':' not allowed in time


        // valid time
        assertTrue(TimeSlot.isValidTimeSlot("2030"));
        assertTrue(TimeSlot.isValidTimeSlot("0715"));
        assertTrue(TimeSlot.isValidTimeSlot("2359"));

    }
}
