package seedu.address.model.event;

import javafx.collections.ObservableList;

/**
 * Interface for a list of Events.
 */
public interface EventList extends Iterable<Event> {
    /**
     * Returns true if the list contains an equivalent event as the given argument.
     */
    boolean contains(Event toCheck);

    /**
     * Adds an event to the list.
     */
    void add(Event toAdd);

    /**
     * Removes the equivalent event from the list.
     * The event must exist in the list.
     */
    void remove(Event toRemove);

    /**
     * Replaces the event {@code target} in the list with {@code editedEvent}.
     * {@code target} must exist in the list.
     */
    void setEvent(Event target, Event editedEvent);

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    ObservableList<Event> asUnmodifiableObservableList();

    /**
     * Checks if the given Event overlaps with any of the Events in the list.
     * @param toCheck the Event to check.
     * @return true if the Event's TimeSlot overlaps with any other Event in the list, false otherwise.
     */
    boolean isOverlapping(Event toCheck);
}
