package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TimeSlotTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeSlot(null));
    }

    @Test
    public void constructor_invalidTime_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new TimeSlot(invalidTime));
    }

    @Test
    public void isValidTime() {
        // null time
        assertThrows(NullPointerException.class, () -> TimeSlot.isValidTime(null));

        // blank time
        assertFalse(TimeSlot.isValidTime("")); // empty string
        assertFalse(TimeSlot.isValidTime(" ")); // spaces only

        // invalid time
        assertFalse(TimeSlot.isValidTime("15")); // missing minutes
        assertFalse(TimeSlot.isValidTime("04:30")); // ':' not allowed in time


        // valid time
        assertTrue(TimeSlot.isValidTime("2030"));
        assertTrue(TimeSlot.isValidTime("0715"));
        assertTrue(TimeSlot.isValidTime("2359"));

    }
}
