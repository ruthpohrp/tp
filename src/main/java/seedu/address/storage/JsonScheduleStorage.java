package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlySchedule;

/**
 * A class to access Schedule data stored as a json file on the hard disk.
 */
public class JsonScheduleStorage implements ScheduleStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonScheduleStorage.class);

    private Path filePath;

    public JsonScheduleStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getScheduleFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlySchedule> readSchedule() throws DataConversionException {
        return readSchedule(filePath);
    }

    /**
     * Similar to {@link #readSchedule()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlySchedule> readSchedule(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableSchedule> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableSchedule.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveSchedule(ReadOnlySchedule addressBook) throws IOException {
        saveSchedule(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveSchedule(ReadOnlySchedule)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveSchedule(ReadOnlySchedule addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableSchedule(addressBook), filePath);
    }

}
