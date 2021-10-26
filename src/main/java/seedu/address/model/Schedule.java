package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.exceptions.SlotBlockedException;
import seedu.address.model.event.BlockedSlot;
import seedu.address.model.event.Event;
import seedu.address.model.event.Overlappable;
import seedu.address.model.event.SortedBlockedSlotList;
import seedu.address.model.event.SortedEventList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameEvent comparison)
 */
public class Schedule implements ReadOnlySchedule {

    private final Logger logger = LogsCenter.getLogger(Schedule.class);

    private final SortedEventList events;
    private final SortedBlockedSlotList blockedSlotList;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        events = new SortedEventList();
        blockedSlotList = new SortedBlockedSlotList();
    }

    public Schedule() {}

    /**
     * Creates a Schedule using the Events in the {@code toBeCopied}
     */
    public Schedule(ReadOnlySchedule toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the event list with {@code events}.
     * {@code events} must not contain duplicate events.
     */
    public void setEvents(List<Event> events) {
        this.events.setEvent(events);
    }

    /**
     * Resets the existing data of this {@code Schedule} with {@code newData}.
     */
    public void resetData(ReadOnlySchedule newData) {
        requireNonNull(newData);

        setEvents(newData.getEventList());
    }

    //// event-level operations

    /**
     * Adds an event to the address book.
     * The event must not already exist in the address book.
     */
    public void addEvent(Event e) {
        if (isBlocked(e)) {
            throw new SlotBlockedException(BlockedSlot.SLOT_BLOCKED);
        }
        events.add(e);
    }

    /**
     * Replaces the given event {@code target} in the list with {@code editedEvent}.
     * {@code target} must exist in the address book.
     * The event identity of {@code editedEvent} must not be the same as another existing event in the address book.
     */
    public void setEvent(Event target, Event editedEvent) {
        requireNonNull(editedEvent);

        events.setEvent(target, editedEvent);
    }

    /**
     * Removes {@code key} from this {@code Schedule}.
     * {@code key} must exist in the address book.
     */
    public void removeEvent(Event key) {
        events.remove(key);
    }

    /**
     * Adds a block with the given BlockedSlot.
     * @param blockedSlot BlockedSlot to be added.
     */
    public void addBlock(BlockedSlot blockedSlot) throws SlotBlockedException {
        //TODO: instead of throwing error, merge with other blocked periods
        if (isBlocked(blockedSlot)) {
            throw new SlotBlockedException(BlockedSlot.SLOT_BLOCKED);
        }
        blockedSlotList.add(blockedSlot);
    }

    /**
     * Checks if the given Overlappable is blocked.
     * @param overlappable the Overlappable to be checked.
     * @return true if the Overlappable is blocked, false otherwise.
     */
    public boolean isBlocked(Overlappable overlappable) {
        return blockedSlotList.isOverlappingWith(overlappable);
    }

    //// util methods

    @Override
    public String toString() {
        return events.asUnmodifiableObservableList().size() + " events";
        // TODO: refine later
    }

    @Override
    public ObservableList<Event> getEventList() {
        return events.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<BlockedSlot> getBlockedSlotList() {
        return blockedSlotList.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Schedule // instanceof handles nulls
                && events.equals(((Schedule) other).events));
    }

    @Override
    public int hashCode() {
        return events.hashCode();
    }
}
