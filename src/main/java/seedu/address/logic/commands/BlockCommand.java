package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMESLOT;

/**
 * Blocks out a time slot in the schedule.
 */
public class BlockCommand extends Command {

    public static final String COMMAND_WORD = "block";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Blocks a specified time slot in the schedule. "
            + "\n"
            + "Parameters: "
            + PREFIX_TIMESLOT + "TIMESLOT ";

    public static final String MESSAGE_SUCCESS = "New time slot blocked out: %1$s-%2$s";

    private final String startTimeToBlock;
    private final String endTimeToBlock;

    /**
     * Creates a BlockCommand to block the specified TimeSlot.
     * @param startTime start time of time slot to block.
     * @param endTime end time of time slot to block.
     */
    public BlockCommand(String startTime, String endTime) {
        requireNonNull(startTime);
        requireNonNull(endTime);
        this.startTimeToBlock = startTime;
        this.endTimeToBlock = endTime;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.blockTimeSlot(startTimeToBlock, endTimeToBlock);
        return new CommandResult(String.format(MESSAGE_SUCCESS, startTimeToBlock, endTimeToBlock));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BlockCommand // instanceof handles nulls
                && startTimeToBlock.equals(((BlockCommand) other).startTimeToBlock)
                && endTimeToBlock.equals(((BlockCommand) other).endTimeToBlock));
    }
}
