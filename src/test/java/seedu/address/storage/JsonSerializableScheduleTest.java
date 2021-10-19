package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.Schedule;
import seedu.address.testutil.TypicalEvents;

public class JsonSerializableScheduleTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableScheduleTest");
    private static final Path TYPICAL_EVENTS_FILE = TEST_DATA_FOLDER.resolve("typicalEventSchedule.json");
    private static final Path INVALID_EVENT_FILE = TEST_DATA_FOLDER.resolve("invalidEventSchedule.json");

    @Test
    public void toModelType_typicalEventsFile_success() throws Exception {
        JsonSerializableSchedule dataFromFile = JsonUtil.readJsonFile(TYPICAL_EVENTS_FILE,
                JsonSerializableSchedule.class).get();
        Schedule addressBookFromFile = dataFromFile.toModelType();
        Schedule typicalEventsSchedule = TypicalEvents.getTypicalSchedule();
        assertEquals(addressBookFromFile, typicalEventsSchedule);
    }

    @Test
    public void toModelType_invalidEventFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSchedule dataFromFile = JsonUtil.readJsonFile(INVALID_EVENT_FILE,
                JsonSerializableSchedule.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

}
