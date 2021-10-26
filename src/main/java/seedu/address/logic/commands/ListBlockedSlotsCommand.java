package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class ListBlockedSlotsCommand extends Command {

    public static final String COMMAND_WORD = "list_blocked";

    public static final String MESSAGE_SUCCESS = "Here are all your blocked slots:\n%1$s";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(String.format(MESSAGE_SUCCESS, model.filteredBlockedSlotListToString()));
    }
}
