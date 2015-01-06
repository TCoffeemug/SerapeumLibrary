package de.iceburner.apps.serapeum.lib;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for LibraryItem
 *
 * <p>
 * <b>Copyright:</b> Copyright (c) 2015
 * </p>
 * <p>
 * <b>Company</b> Iceburner
 * </p>
 *
 * @author ethssce - 2015-01-03 - Initial version
 */
public class LibraryItemTest {

    private final static String ITEM_NAME = "ItemName";
    private final static String DESCRIPTION = "This describes the item";

    private LibraryItem mItem1;

    @Test
    public void testCreateLibraryItem() {
        mItem1 = new LibraryItem(ITEM_NAME);
        assertTrue("LibraryItem has not the assigned name " + ITEM_NAME, mItem1.getName().equals(ITEM_NAME));
    }

    @Test
    public void testAddDescription() {
        mItem1 = new LibraryItem(ITEM_NAME);
        mItem1.setDescription(DESCRIPTION);
        assertEquals("Description was not added correctly", DESCRIPTION, mItem1.getDescription());
    }

    @Test
    public void testBookToString() {
        mItem1 = new LibraryItem(ITEM_NAME);
        mItem1.setDescription(DESCRIPTION);
        String expectedReturnString = ITEM_NAME + ": " + DESCRIPTION;
        assertEquals("Book has not the expected toString representation", expectedReturnString, mItem1.toString());
    }

}
