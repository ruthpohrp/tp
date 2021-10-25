package seedu.address.model.event;

import javafx.collections.ObservableList;

/**
 * Interface for a list of Events.
 */
public interface EventList {
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
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    ObservableList<Event> asUnmodifiableObservableList();

    /**
     * Checks if the given Event overlaps with any of the Events in the list.
     * @param toCheck the Event to check.
     * @return true if the Event's TimeSlot overlaps with any other Event in the list, false otherwise.
     */
    boolean isOverlapped(Event toCheck);
}
