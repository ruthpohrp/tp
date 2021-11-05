package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.AddBlockedSlotCommand;
import seedu.address.logic.commands.AddCommand;
import seedu.address.model.blockedslot.BlockedSlot;
import seedu.address.model.event.Date;
import seedu.address.model.event.Event;
import seedu.address.model.event.Location;
import seedu.address.model.event.Name;
import seedu.address.model.event.TimeSlot;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.BlockedSlotBuilder;
import seedu.address.testutil.EventBuilder;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BLOCKEDSLOTB;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_LOCATION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TIME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.LOCATION_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.LOCATION_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.REMARK_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.REMARK_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.TIMESLOT_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.TIMESLOT_DESC_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.TIMESLOT_DESC_BLOCKEDSLOTB;
import static seedu.address.logic.commands.CommandTestUtil.TIMESLOT_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ENDTIME_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STARTTIME_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMESLOT_BLOCKEDSLOTA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIMESLOT_BOB;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalEvents.AMY;
import static seedu.address.testutil.TypicalEvents.BOB;

public class AddBlockedSlotCommandParserTest {
    private AddBlockedSlotCommandParser parser = new AddBlockedSlotCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        BlockedSlot expectedBlockedSlot = new BlockedSlotBuilder().withDate(VALID_DATE_BLOCKEDSLOTA)
                .withTimeSlot(VALID_STARTTIME_BLOCKEDSLOTA, VALID_ENDTIME_BLOCKEDSLOTA).build();

        // whitespace only preamble
        assertParseSuccess(parser,PREAMBLE_WHITESPACE + DATE_DESC_BLOCKEDSLOTA + TIMESLOT_DESC_BLOCKEDSLOTA,
                new AddBlockedSlotCommand(expectedBlockedSlot));

        // multiple dates - last date accepted
        assertParseSuccess(parser, DATE_DESC_BLOCKEDSLOTB + DATE_DESC_BLOCKEDSLOTA + TIMESLOT_DESC_BLOCKEDSLOTA,
                new AddBlockedSlotCommand(expectedBlockedSlot));

        // multiple time - last time accepted
        assertParseSuccess(parser, DATE_DESC_BLOCKEDSLOTA + TIMESLOT_DESC_BLOCKEDSLOTB
                        + TIMESLOT_DESC_BLOCKEDSLOTA, new AddBlockedSlotCommand(expectedBlockedSlot));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddBlockedSlotCommand.MESSAGE_USAGE);

        // missing date prefix
        assertParseFailure(parser, VALID_DATE_BLOCKEDSLOTA + TIMESLOT_DESC_BLOCKEDSLOTA, expectedMessage);

        // missing time prefix
        assertParseFailure(parser,  DATE_DESC_BLOCKEDSLOTA + VALID_TIMESLOT_BLOCKEDSLOTA, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid date
        assertParseFailure(parser, INVALID_DATE_DESC + TIMESLOT_DESC_BLOCKEDSLOTA, Date.MESSAGE_CONSTRAINTS);

        // invalid time
        assertParseFailure(parser, DATE_DESC_BLOCKEDSLOTA + INVALID_TIME_DESC, TimeSlot.MESSAGE_CONSTRAINTS);

        // both invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_DATE_DESC + INVALID_TIME_DESC, Date.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + DATE_DESC_BLOCKEDSLOTA + TIMESLOT_DESC_BLOCKEDSLOTA,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddBlockedSlotCommand.MESSAGE_USAGE));
    }
}
