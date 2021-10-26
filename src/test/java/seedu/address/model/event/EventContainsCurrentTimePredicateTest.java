package seedu.address.model.event;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.NextEventCommandTest.timeFormatter;

public class EventContainsCurrentTimePredicateTest {

    @Test
    public void equals() {
        EventContainsCurrentTimePredicate firstPredicate = new  EventContainsCurrentTimePredicate();
        EventContainsCurrentTimePredicate secondPredicate = new  EventContainsCurrentTimePredicate();
        EventContainsCurrentTimePredicate thirdPredicate = new  EventContainsCurrentTimePredicate(LocalTime.parse("0730", timeFormatter),
                new Date("2020-01-01"));
        EventContainsCurrentTimePredicate fourthPredicate = new  EventContainsCurrentTimePredicate(LocalTime.parse("0830", timeFormatter),
                new Date("2020-01-02"));

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

//        // two objects containing same date -> returns true
//        assertTrue(firstPredicate.equals(secondPredicate));


        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different dates -> returns false
        assertFalse(thirdPredicate.equals(fourthPredicate));
    }
}
