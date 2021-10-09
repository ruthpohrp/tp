package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ReadOnlySchedule;
import seedu.address.model.Schedule;
import seedu.address.model.person.Person;

/**
 * An Immutable Schedule that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableSchedule {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableSchedule} with the given persons.
     */
    @JsonCreator
    public JsonSerializableSchedule(@JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlySchedule} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableSchedule}.
     */
    public JsonSerializableSchedule(ReadOnlySchedule source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code Schedule} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Schedule toModelType() throws IllegalValueException {
        Schedule schedule = new Schedule();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Person person = jsonAdaptedPerson.toModelType();
            if (schedule.hasPerson(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            schedule.addPerson(person);
        }
        return schedule;
    }

}
