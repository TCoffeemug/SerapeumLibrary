package de.iceburner.apps.serapeum.lib;

import java.util.ArrayList;
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

    private ArrayList<LibraryItem> mItemList;
    private ArrayList<String> mIdList;
    private Library mLibrary;

    @Before
    public void setUp() {
        mItemList = new ArrayList<>();
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME, AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME + " 2", AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(BOOK_NAME + " 3", AUTHOR, LibraryItemFactory.ItemType.BOOK));
        mItemList.add(LibraryItemFactory.createItem(MOVIE_NAME, String.valueOf(YEAR), LibraryItemFactory.ItemType.MOVIE));
        mItemList.add(LibraryItemFactory.createItem(MOVIE_NAME + " 2", String.valueOf(YEAR + 7), LibraryItemFactory.ItemType.MOVIE));
        mItemList.add(LibraryItemFactory.createItem(ITEM_NAME, ITEM_DESCRIPTION, LibraryItemFactory.ItemType.OTHER));
        mIdList = new ArrayList<>();
    }

    private void initializeLibrary() {
        mLibrary = new Library();
        for (LibraryItem item : mItemList) {
            mIdList.add(mLibrary.addItem(item));
        }
    }

    @Test
    public void testAddItemsToLibrary() {
        initializeLibrary();
        for (String id : mIdList) {
            assertTrue("Item with id " + id + " could not be found in Library", mItemList.contains(mLibrary.getItem(id)));
        }
    }

}
