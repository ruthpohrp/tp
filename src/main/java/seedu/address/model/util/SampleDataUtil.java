package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Date;
import seedu.address.model.person.Email;
import seedu.address.model.person.Event;
import seedu.address.model.person.Location;
import seedu.address.model.person.Name;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Event[] getSampleEvents() {
        return new Event[] {
            new Event(new Name("Alex Yeoh"), new Date("2020-01-01"), new Email("alexyeoh@example.com"),
                new Location("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Event(new Name("Bernice Yu"), new Date("2020-01-02"), new Email("berniceyu@example.com"),
                new Location("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Event(new Name("Charlotte Oliveiro"), new Date("2020-01-03"), new Email("charlotte@example"
                    + ".com"),
                new Location("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Event(new Name("David Li"), new Date("2020-01-04"), new Email("lidavid@example.com"),
                new Location("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Event(new Name("Irfan Ibrahim"), new Date("2020-01-05"), new Email("irfan@example.com"),
                new Location("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Event(new Name("Roy Balakrishnan"), new Date("2020-01-06"), new Email("royb@example.com"),
                new Location("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Event sampleEvent : getSampleEvents()) {
            sampleAb.addEvent(sampleEvent);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
