package seedu.address.model.event;

/**
 * An Overlappable is an object that can overlap with another based on date and time.
 */
public interface Overlappable {

    boolean overlaps(Overlappable overlappable);

}
