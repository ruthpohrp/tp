package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.exceptions.SlotBlockedException;
import seedu.address.model.event.BlockedSlot;
import seedu.address.model.event.Event;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final Schedule schedule;
    private final UserPrefs userPrefs;
    private final FilteredList<Event> filteredEvents;

    /**
     * Initializes a ModelManager with the given schedule and userPrefs.
     */
    public ModelManager(ReadOnlySchedule addressBook, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.schedule = new Schedule(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredEvents = new FilteredList<>(this.schedule.getEventList());
    }

    public ModelManager() {
        this(new Schedule(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getScheduleFilePath() {
        return userPrefs.getScheduleFilePath();
    }

    @Override
    public void setScheduleFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setScheduleFilePath(addressBookFilePath);
    }

    //=========== Schedule ================================================================================

    @Override
    public void setSchedule(ReadOnlySchedule addressBook) {
        this.schedule.resetData(addressBook);
    }

    @Override
    public ReadOnlySchedule getSchedule() {
        return schedule;
    }

    @Override
    public void deleteEvent(Event target) {
        schedule.removeEvent(target);
    }

    @Override
    public void addEvent(Event event) {
        schedule.addEvent(event);
        updateFilteredEventList(PREDICATE_SHOW_ALL_EVENTS);
    }

    @Override
    public void setEvent(Event target, Event editedEvent) {
        requireAllNonNull(target, editedEvent);

        schedule.setEvent(target, editedEvent);
    }

    @Override
    public void addBlock(BlockedSlot blockedSlot) throws SlotBlockedException {
        requireAllNonNull(blockedSlot);

        schedule.addBlock(blockedSlot);
    }

    //=========== Filtered Event List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Event} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Event> getFilteredEventList() {
        return filteredEvents;
    }

    @Override
    public void updateFilteredEventList(Predicate<Event> predicate) {
        requireNonNull(predicate);
        filteredEvents.setPredicate(predicate);
    }
    @Override
    public Event nextEventInTheList() {
        return filteredEvents.get(0);
    }
    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return schedule.equals(other.schedule)
                && userPrefs.equals(other.userPrefs)
                && filteredEvents.equals(other.filteredEvents);
    }

}
