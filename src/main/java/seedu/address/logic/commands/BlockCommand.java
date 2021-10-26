package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMESLOT;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.BlockedSlot;

/**
 * Blocks out a time slot in the schedule.
 */
public class BlockCommand extends Command {

    public static final String COMMAND_WORD = "block";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Blocks a specified time slot in the schedule. "
            + "\n"
            + "Parameters: "
            + PREFIX_TIMESLOT + "TIMESLOT ";

    public static final String MESSAGE_SUCCESS = "New slot blocked out: %1$s\n";

    private final BlockedSlot blockedSlot;

    /**
     * Creates a BlockCommand to block the specified BlockedSlot.
     * @param blockedSlot
     */
    public BlockCommand(BlockedSlot blockedSlot) {
        requireNonNull(blockedSlot);
        this.blockedSlot = blockedSlot;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addBlock(blockedSlot);
        return new CommandResult(String.format(MESSAGE_SUCCESS, blockedSlot));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BlockCommand // instanceof handles nulls
                && blockedSlot.equals(((BlockCommand) other).blockedSlot));
    }
}
