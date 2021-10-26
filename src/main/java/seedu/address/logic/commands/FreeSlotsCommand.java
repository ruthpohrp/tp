package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FreeSlot;
import seedu.address.model.Model;

import java.util.ArrayList;

public class FreeSlotsCommand extends Command{
    public static final String COMMAND_WORD = "free_slots";

    public static final String MESSAGE_SUCCESS = "Here are your free slots:";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        ArrayList<FreeSlot> freeSlots = model.getFreeSlots();
        StringBuilder result = new StringBuilder(MESSAGE_SUCCESS);
        for (FreeSlot f: freeSlots) {
            result.append("\n" + f.toString());
        }
        return new CommandResult(result.toString());
    }
}
