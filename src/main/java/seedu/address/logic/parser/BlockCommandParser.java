package seedu.address.logic.parser;

import seedu.address.logic.commands.BlockCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.TimeSlot;

/**
 * Parses input arguments and creates a new BlockCommand object
 */
public class BlockCommandParser implements Parser<BlockCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of BlockCommand
     * and returns a BlockCommand object for execution.
     * @param args arguments provided by the user.
     * @return a BlockCommand object.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public BlockCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        String[] startTimeAndEndTime = trimmedArgs.split("-");
        try {
            //TODO: check if isBlockable()
            return new BlockCommand(startTimeAndEndTime[0], startTimeAndEndTime[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException(TimeSlot.MESSAGE_CONSTRAINTS_BLOCK);
        }
    }
}
