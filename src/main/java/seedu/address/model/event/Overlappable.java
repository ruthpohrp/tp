package seedu.address.model.event;

/**
 * An Overlappable can overlap with another based on date and time.
 */
public interface Overlappable {

    /**
     * Checks if there is an overlap between the given Overlappable and this instance.
     * @param overlappable other Overlappable to check for overlaps.
     * @return true if there is an overlap, false otherwise.
     */
    boolean overlapsWith(Overlappable overlappable);

}
