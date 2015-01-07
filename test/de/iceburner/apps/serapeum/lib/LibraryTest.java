package de.iceburner.apps.serapeum.lib;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit Tests for Library class
 *
 * <p>
 * <b>Copyright:</b> Copyright (c) 2015
 * </p>
 * <p>
 * <b>Company</b> Iceburner
 * </p>
 *
 * @author ethssce - 2015-01-04 - Initial version
 */
public class LibraryTest {

    private static final String BOOK_NAME = "Lord of the Rings";
    private static final String AUTHOR = "J.R.R. Tolkien";
    private static final String MOVIE_NAME = "Alien";
    private static final int YEAR = 1979;
    private static final String DESCRIPTION = "descriptive description";
    private static final String ITEM_NAME = "Melon";
    private static final String ITEM_DESCRIPTION = "A fruit normally not kept in a library";
    private static final String PERSON_NAME1 = "Bilbo Baggins";
    private static final String PERSON_NAME2 = "Sgt. Ripley";

    private List<LibraryItem> mItemList;
    private List<String> mItemIdList;
    private Library mLibrary;
    private List<Person> mPersonList;
    private List<String> mPersonIdList;

    @Before
    public void setUp() {
        mItemList = new ArrayList<>();
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME, AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME + " 2", AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME + " 3", AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(MOVIE_NAME, String.valueOf(YEAR), LibraryItemFactory.ItemType.MOVIE));
        mItemList.add(LibraryItemFactory.createItem(MOVIE_NAME + " 2", String.valueOf(YEAR + 7), LibraryItemFactory.ItemType.MOVIE));
        mItemList.add(LibraryItemFactory.createItem(ITEM_NAME, ITEM_DESCRIPTION, LibraryItemFactory.ItemType.OTHER));
        mItemIdList = new ArrayList<>();
        mPersonList = new ArrayList<>();
        mPersonList.add(new Person(PERSON_NAME1));
        mPersonList.add(new Person(PERSON_NAME2));
        mPersonIdList = new ArrayList<>();
    }

    private void initializeLibrary() {
        mLibrary = new Library();
        for (LibraryItem item : mItemList) {
            mItemIdList.add(mLibrary.addItem(item));
        }
    }

    private void initializePeople() {
        for (Person person : mPersonList) {
            mPersonIdList.add(mLibrary.addPerson(person));
        }
    }

    @Test
    public void testAddItemsToLibrary() {
        initializeLibrary();
        for (String id : mItemIdList) {
            assertTrue("Item with id " + id + " could not be found in Library", mItemList.contains(mLibrary.getItem(id)));
        }
        mItemIdList.clear();
    }

    @Test
    public void testAddPersonsToLibrary() {
        mLibrary = new Library();
        initializePeople();
        for (String id : mPersonIdList) {
            assertTrue("Person with id " + id + " could not be found in Library", mPersonList.contains(mLibrary.getPerson(id)));
        }
        mPersonIdList.clear();
    }

    @Test
    public void testCheckOut() {
        initializeLibrary();
        initializePeople();
        String itemId = mItemIdList.get(0);
        String personId = mPersonIdList.get(0);
        assertTrue("Item could not be checked out", mLibrary.checkOut(itemId, personId));
        assertFalse("Item is still available", mLibrary.getItem(itemId).isAvailable());
        assertEquals("Item has no or wrong person linked", personId, mLibrary.getPersonForItem(itemId));
        assertTrue("Person does not have the right book", mLibrary.getItemsForPerson(personId).contains(itemId));
        //rule out double checkout
        assertFalse("Item could be lent twice", mLibrary.checkOut(itemId, personId));
        personId = mPersonIdList.get(1);
        assertFalse("Item could be lent twice", mLibrary.checkOut(itemId, personId));
        assertFalse("Item has no or wrong person linked", personId.equals(mLibrary.getPersonForItem(itemId)));
        assertFalse("Person does not have the right book", mLibrary.getItemsForPerson(personId).contains(itemId));
        mItemIdList.clear();
        mPersonIdList.clear();
    }

    @Test
    public void testCheckIn() {
        initializeLibrary();
        initializePeople();
        String itemId = mItemIdList.get(0);
        String personId = mPersonIdList.get(0);
        mLibrary.checkOut(itemId, personId);
        mLibrary.checkOut(mItemIdList.get(1), personId);
        assertTrue("Item could not be checked in", mLibrary.checkIn(itemId));
        assertTrue("Item is not available", mLibrary.getItem(itemId).isAvailable());
        assertFalse("Person still has the book", mLibrary.getItemsForPerson(personId).contains(itemId));
        assertFalse("Item could be checked in", mLibrary.checkIn(itemId));
        assertTrue("Item could not be checked out", mLibrary.checkOut(itemId, mPersonIdList.get(0)));
        mItemIdList.clear();
        mPersonIdList.clear();
    }

}
