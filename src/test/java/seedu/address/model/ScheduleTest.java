package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEvents.ALICE;
import static seedu.address.testutil.TypicalEvents.getTypicalSchedule;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.event.Event;
import seedu.address.testutil.EventBuilder;

public class ScheduleTest {

    private final Schedule schedule = new Schedule();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), schedule.getEventList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlySchedule_replacesData() {
        Schedule newData = getTypicalSchedule();
        schedule.resetData(newData);
        assertEquals(newData, schedule);
    }

    @Test
    public void hasEvent_nullEvent_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.hasEvent(null));
    }

    @Test
    public void hasEvent_eventNotInSchedule_returnsFalse() {
        assertFalse(schedule.hasEvent(ALICE));
    }

    @Test
    public void hasEvent_eventInSchedule_returnsTrue() {
        schedule.addEvent(ALICE);
        assertTrue(schedule.hasEvent(ALICE));
    }

    @Test
    public void hasEvent_eventWithSameIdentityFieldsInSchedule_returnsTrue() {
        schedule.addEvent(ALICE);
        Event editedAlice = new EventBuilder(ALICE).withLocation(VALID_LOCATION_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(schedule.hasEvent(editedAlice));
    }

    @Test
    public void getEventList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> schedule.getEventList().remove(0));
    }

    /**
     * A stub ReadOnlySchedule whose events list can violate interface constraints.
     */
    private static class ScheduleStub implements ReadOnlySchedule {
        private final ObservableList<Event> events = FXCollections.observableArrayList();

        ScheduleStub(Collection<Event> events) {
            this.events.setAll(events);
        }

        @Override
        public ObservableList<Event> getEventList() {
            return events;
        }
    }

}
