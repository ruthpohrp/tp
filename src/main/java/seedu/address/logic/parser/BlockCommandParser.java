package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMESLOT;

import seedu.address.logic.commands.BlockCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.BlockedSlot;
import seedu.address.model.event.Date;
import seedu.address.model.event.TimeSlot;

import java.util.stream.Stream;

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
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DATE, PREFIX_TIMESLOT);

        if (!arePrefixesPresent(argMultimap, PREFIX_DATE, PREFIX_TIMESLOT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, BlockCommand.MESSAGE_USAGE));
        }

        Date date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        TimeSlot timeSlot = ParserUtil.parseTimeSlot(argMultimap.getValue(PREFIX_TIMESLOT).get());

        BlockedSlot blockedSlot = new BlockedSlot(date, timeSlot);

        return new BlockCommand(blockedSlot);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
