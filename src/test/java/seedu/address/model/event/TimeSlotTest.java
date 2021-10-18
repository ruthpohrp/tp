package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import java.sql.Time;

public class TimeSlotTest {

    @Test
    public void constructor_startTimeNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeSlot(null, "1500"));
    }

    @Test
    public void constructor_endTimeNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeSlot("1500", null));
    }

    @Test
    public void constructor_invalidStartTime_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new TimeSlot(invalidTime, "1500"));
    }

    @Test
    public void constructor_invalidEndTime_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new TimeSlot("1500", invalidTime));
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

    @Test
    public void compareTo() {
        TimeSlot earlierSlot = new TimeSlot("1300", "1400");
        TimeSlot sameAsEarlierSlot = new TimeSlot("1300", "1400");
        TimeSlot laterSlot = new TimeSlot("1400", "1500");
        assertTrue(earlierSlot.compareTo(laterSlot) < 0);
        assertTrue(earlierSlot.compareTo(sameAsEarlierSlot) == 0);
    }
}
