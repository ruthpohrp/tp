package seedu.address.model.event;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Tests that an {@code Event}'s {@code Date} matches today's date.
 */
public class EventContainsTodaysDatePredicate implements Predicate<Event> {
    private final Date today;

    /**
     * Constructs a {@code EventContainsTodaysDatePredicate}
     */
    public EventContainsTodaysDatePredicate() {
        this.today = new Date(LocalDate.now().toString());
    }

    public EventContainsTodaysDatePredicate(Date date) {
        this.today = date;
    }

    @Override
    public boolean test(Event event) {
        return event.getDate().equals(today);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EventContainsTodaysDatePredicate // instanceof handles nulls
                && today.equals(((EventContainsTodaysDatePredicate) other).today)); // state check
    }

}
