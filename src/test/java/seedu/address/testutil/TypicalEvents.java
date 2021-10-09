package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.Schedule;
import seedu.address.model.person.Event;

/**
 * A utility class containing a list of {@code Event} objects to be used in tests.
 */
public class TypicalEvents {

    public static final Event ALICE = new EventBuilder().withName("Alice Pauline")
            .withLocation("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withDate("2020-01-01")
            .withTags("friends").build();
    public static final Event BENSON = new EventBuilder().withName("Benson Meier")
            .withLocation("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withDate("2020-01-02")
            .withTags("owesMoney", "friends").build();
    public static final Event CARL = new EventBuilder().withName("Carl Kurz").withDate("2020-01-03")
            .withEmail("heinz@example.com").withLocation("wall street").build();
    public static final Event DANIEL = new EventBuilder().withName("Daniel Meier").withDate("2020-01-04")
            .withEmail("cornelia@example.com").withLocation("10th street").withTags("friends").build();
    public static final Event ELLE = new EventBuilder().withName("Elle Meyer").withDate("2020-01-05")
            .withEmail("werner@example.com").withLocation("michegan ave").build();
    public static final Event FIONA = new EventBuilder().withName("Fiona Kunz").withDate("2020-01-06")
            .withEmail("lydia@example.com").withLocation("little tokyo").build();
    public static final Event GEORGE = new EventBuilder().withName("George Best").withDate("2020-01-07")
            .withEmail("anna@example.com").withLocation("4th street").build();

    // Manually added
    public static final Event HOON = new EventBuilder().withName("Hoon Meier").withDate("2020-01-08")
            .withEmail("stefan@example.com").withLocation("little india").build();
    public static final Event IDA = new EventBuilder().withName("Ida Mueller").withDate("2020-01-09")
            .withEmail("hans@example.com").withLocation("chicago ave").build();

    // Manually added - Event's details found in {@code CommandTestUtil}
    public static final Event AMY = new EventBuilder().withName(VALID_NAME_AMY).withDate(VALID_DATE_AMY)
            .withEmail(VALID_EMAIL_AMY).withLocation(VALID_LOCATION_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Event BOB = new EventBuilder().withName(VALID_NAME_BOB).withDate(VALID_DATE_BOB)
            .withEmail(VALID_EMAIL_BOB).withLocation(VALID_LOCATION_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalEvents() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical events.
     */
    public static Schedule getTypicalSchedule() {
        Schedule ab = new Schedule();
        for (Event event : getTypicalEvents()) {
            ab.addEvent(event);
        }
        return ab;
    }

    public static List<Event> getTypicalEvents() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
