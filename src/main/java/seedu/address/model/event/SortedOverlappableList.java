package seedu.address.model.event;

import javafx.collections.ObservableList;

/**
 * Interface for a list of Overlappables.
 * Must be maintained in a sorted state.
 */
public interface SortedOverlappableList extends Iterable<Overlappable> {

    /**
     * Adds an event to the list.
     * @param overlappable Overlappable to be added.
     */
    void add(Overlappable overlappable);

    /**
     * Removes the equivalent Overlappable form the list.
     * The event must exist in the list.
     * @param overlappable Overlappable to be removed.
     */
    void remove(Overlappable overlappable);

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     * @return an ObservableList.
     */
    ObservableList<Overlappable> asUnmodifiableObservableList();

    /**
     * Checks if the given Overlappable overlaps with any other in the list.
     * @param overlappable Overlappable to check.
     * @return true if the given Overlappable overlaps with an Overlappable in the list, false otherwise.
     */
    boolean overlapsWith(Overlappable overlappable);

}
