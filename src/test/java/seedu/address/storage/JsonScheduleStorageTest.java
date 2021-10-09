package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.HOON;
import static seedu.address.testutil.TypicalPersons.IDA;
import static seedu.address.testutil.TypicalPersons.getTypicalSchedule;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlySchedule;
import seedu.address.model.Schedule;

public class JsonScheduleStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonScheduleStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readSchedule_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readSchedule(null));
    }

    private java.util.Optional<ReadOnlySchedule> readSchedule(String filePath) throws Exception {
        return new JsonScheduleStorage(Paths.get(filePath)).readSchedule(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readSchedule("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readSchedule("notJsonFormatSchedule.json"));
    }

    @Test
    public void readSchedule_invalidPersonSchedule_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readSchedule("invalidPersonSchedule.json"));
    }

    @Test
    public void readSchedule_invalidAndValidPersonSchedule_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readSchedule("invalidAndValidPersonSchedule.json"));
    }

    @Test
    public void readAndSaveSchedule_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempAddressBook.json");
        Schedule original = getTypicalSchedule();
        JsonScheduleStorage jsonAddressBookStorage = new JsonScheduleStorage(filePath);

        // Save in new file and read back
        jsonAddressBookStorage.saveSchedule(original, filePath);
        ReadOnlySchedule readBack = jsonAddressBookStorage.readSchedule(filePath).get();
        assertEquals(original, new Schedule(readBack));

        // Modify data, overwrite exiting file, and read back
        original.addPerson(HOON);
        original.removePerson(ALICE);
        jsonAddressBookStorage.saveSchedule(original, filePath);
        readBack = jsonAddressBookStorage.readSchedule(filePath).get();
        assertEquals(original, new Schedule(readBack));

        // Save and read without specifying file path
        original.addPerson(IDA);
        jsonAddressBookStorage.saveSchedule(original); // file path not specified
        readBack = jsonAddressBookStorage.readSchedule().get(); // file path not specified
        assertEquals(original, new Schedule(readBack));

    }

    @Test
    public void saveSchedule_nullSchedule_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveSchedule(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveSchedule(ReadOnlySchedule addressBook, String filePath) {
        try {
            new JsonScheduleStorage(Paths.get(filePath))
                    .saveSchedule(addressBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveSchedule_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveSchedule(new Schedule(), null));
    }
}
