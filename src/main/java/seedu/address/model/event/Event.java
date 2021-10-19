package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents an Event in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Event {

    // Identity fields
    private final Name name;
    private final Date date;
    private final TimeSlot timeSlot;

    // Data fields
    private final Location location;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Event(Name name, Date date, TimeSlot timeSlot, Location location, Set<Tag> tags) {
        requireAllNonNull(name, date, timeSlot, location, tags);
        this.name = name;
        this.date = date;
        this.timeSlot = timeSlot;
        this.location = location;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both events have the same name.
     * This defines a weaker notion of equality between two events.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getName().equals(getName());
    }

    /**
     * Compares this Event instance with another Event instance.
     *
     * @param other other Event to compare to.
     * @return a positive integer if this Event's Date and timeSlot is chronologically before other Event,
     * a negative integer if this Event's Date and timeSlot is chronologically after other Event,
     * zero if both Events are on the same date and start at the same time.
     */
    public int compareTo(Event other) {
        int compareDate = date.compareTo(other.date);
        if (compareDate != 0) {
            return compareDate;
        } else {
            return timeSlot.compareTo(other.timeSlot);
        }
    }

    /**
     * Returns true if both events have the same identity and data fields.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return otherEvent.getName().equals(getName())
                && otherEvent.getDate().equals(getDate())
                && otherEvent.getTimeSlot().equals(getTimeSlot())
                && otherEvent.getLocation().equals(getLocation())
                && otherEvent.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, date, timeSlot, location, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Date: ")
                .append(getDate())
                .append("; TimeSlot: ")
                .append(getTimeSlot())
                .append("; Location: ")
                .append(getLocation());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
