package seedu.address.commons.core.index;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GuiSettingsTest {

    @Test
    public void getWindowWidth() {
        GuiSettings guiSettings = new GuiSettings();
        assertEquals(guiSettings.getWindowWidth(), 740);
    }

    @Test
    public void getWindowHeight() {
        GuiSettings guiSettings = new GuiSettings();
        assertEquals(guiSettings.getWindowHeight(), 600);
    }

    @Test
    public void getWindowCoordinates_null() {
        GuiSettings guiSettings = new GuiSettings();
        assertNull(guiSettings.getWindowCoordinates());
    }

    @Test
    public void getWindowCoordinates_nonNull() {
        GuiSettings guiSettings = new GuiSettings(100, 100, 0, 0);
        assertEquals(guiSettings.getWindowCoordinates(), new Point(0, 0));
    }

    @Test
    public void equalsMethod() {
        GuiSettings guiSettingsA = new GuiSettings();
        GuiSettings sameAsGuiSettingsA = new GuiSettings();
        GuiSettings guiSettingsB = new GuiSettings(100, 100, 0, 0);

        assertFalse(guiSettingsA.equals(null));
        assertFalse(guiSettingsA.equals(5));
        assertFalse(guiSettingsA.equals(guiSettingsB));
        assertTrue(guiSettingsA.equals(guiSettingsA));
        assertTrue(guiSettingsA.equals(sameAsGuiSettingsA));
    }

    @Test
    public void hashCodeMethod() {
        GuiSettings guiSettingsA = new GuiSettings();
        GuiSettings guiSettingsB = new GuiSettings();
        assertEquals(guiSettingsA.hashCode(), guiSettingsB.hashCode());
    }
}
