package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import seedu.address.model.event.exceptions.EventNotFoundException;

/**
 * A list of events is sorted chronologically and does not allow nulls.
 * Duplicate Events are allowed in this Event list to accomodate repeated events with same person.
 *
 * Supports a minimal set of list operations.
 *
 */
public class SortedEventList implements Iterable<Event>, EventList {
    private class EventSorter implements Comparator<Event> {
        @Override
        public int compare(Event o1, Event o2) {
            return o1.compareTo(o2);
        }
    }

    private final ObservableList<Event> internalList = FXCollections.observableArrayList();
    private final ObservableList<Event> internalUnmodifiableList =
            new SortedList<>(FXCollections.unmodifiableObservableList(internalList),
                    new EventSorter());

    @Override
    public boolean contains(Event toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameEvent);
    }

    @Override
    public void add(Event toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    @Override
    public void remove(Event toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new EventNotFoundException();
        }
    }

    /**
     * Replaces the event {@code target} in the list with {@code editedEvent}.
     * {@code target} must exist in the list.
     */
    public void setEvent(Event target, Event editedEvent) {
        requireAllNonNull(target, editedEvent);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new EventNotFoundException();
        }

        internalList.set(index, editedEvent);
    }

    public void setEvent(SortedEventList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code events}.
     */
    public void setEvent(List<Event> events) {
        requireAllNonNull(events);
        internalList.setAll(events);
    }

    @Override
    public ObservableList<Event> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Event> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortedEventList // instanceof handles nulls
                && internalUnmodifiableList.equals(((SortedEventList) other).internalUnmodifiableList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public boolean isOverlapped(Event toCheck) {
        //TODO: For Ruth to implement
        return false;
    }
}
