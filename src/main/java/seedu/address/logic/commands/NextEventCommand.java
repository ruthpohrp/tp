package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventContainsCurrentTimePredicate;
import seedu.address.model.event.IsEventPredicate;


/**
 * Displays the next event in the Schedule based on the current time.
 */
public class NextEventCommand extends Command {

    public static final String COMMAND_WORD = "next_event";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":Displays the next event scheduled for the day\n"
            + "Example: " + COMMAND_WORD;

    private final EventContainsCurrentTimePredicate timePredicate;

    public NextEventCommand() {
        this.timePredicate = new EventContainsCurrentTimePredicate();
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredEventList(timePredicate);
        Event firstEvent = model.nextEventInTheList();
        model.updateFilteredEventList(new IsEventPredicate(firstEvent));
        return new CommandResult(
                String.format(Messages.MESSAGE_EVENT_LISTED_OVERVIEW, model.getFilteredEventList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NextEventCommand // instanceof handles nulls
                && timePredicate.equals(((NextEventCommand) other).timePredicate)); // state check
    }
}
