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
}
