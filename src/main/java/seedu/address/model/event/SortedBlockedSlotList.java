package seedu.address.model.event;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import seedu.address.model.event.exceptions.BlockedSlotNotFoundException;

import java.util.Comparator;
import java.util.Iterator;

import static java.util.Objects.requireNonNull;

/**
 * A list of blocked slots is sorted chronogically and does not allow nulls.
 */
public class SortedBlockedSlotList implements SortedOverlappableList<BlockedSlot> {
    private class BlockedSlotSorter implements Comparator<BlockedSlot> {
        @Override
        public int compare(BlockedSlot o1, BlockedSlot o2) {
            return o1.compareTo(o2);
        }
    }

    private final ObservableList<BlockedSlot> internalList = FXCollections.observableArrayList();
    private final ObservableList<BlockedSlot> internalUnmodifiableList =
            new SortedList<>(FXCollections.unmodifiableObservableList(internalList),
                    new BlockedSlotSorter());

    @Override
    public void add(BlockedSlot toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    @Override
    public void remove(BlockedSlot toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new BlockedSlotNotFoundException();
        }
    }

    @Override
    public ObservableList<BlockedSlot> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public boolean isOverlappingWith(Overlappable overlappable) {
        //TODO: For Ruth to implement
        return false;
    }

    @Override
    public Iterator<BlockedSlot> iterator() {
        return internalList.iterator();
    }
}
