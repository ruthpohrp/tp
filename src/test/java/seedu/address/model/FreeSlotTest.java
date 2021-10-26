package seedu.address.model;

import org.junit.jupiter.api.Test;
import seedu.address.model.event.Date;
import seedu.address.model.event.TimeSlot;

import static seedu.address.testutil.Assert.assertThrows;

public class FreeSlotTest {
    @Test
    public void constructor_startTimeNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new FreeSlot(null, new TimeSlot("0000", "2359")));
    }

    @Test
    public void constructor_endTimeNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new FreeSlot(new Date("2021-10-31"), null));
    }
}
