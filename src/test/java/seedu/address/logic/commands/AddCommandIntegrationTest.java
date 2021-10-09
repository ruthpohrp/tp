package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalEvents.getTypicalSchedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Event;
import seedu.address.testutil.EventBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalSchedule(), new UserPrefs());
    }

    @Test
    public void execute_newEvent_success() {
        Event validEvent = new EventBuilder().build();

        Model expectedModel = new ModelManager(model.getSchedule(), new UserPrefs());
        expectedModel.addEvent(validEvent);

        assertCommandSuccess(new AddCommand(validEvent), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validEvent), expectedModel);
    }

    @Test
    public void execute_duplicateEvent_throwsCommandException() {
        Event eventInList = model.getSchedule().getEventList().get(0);
        assertCommandFailure(new AddCommand(eventInList), model, AddCommand.MESSAGE_DUPLICATE_EVENT);
    }

}
