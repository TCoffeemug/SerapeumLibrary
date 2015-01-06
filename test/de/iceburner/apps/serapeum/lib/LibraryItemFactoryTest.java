package de.iceburner.apps.serapeum.lib;

import de.iceburner.apps.serapeum.lib.LibraryItemFactory.ItemType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * unit tests for item factory
 *
 * <p>
 * <b>Copyright:</b> Copyright (c) 2015
 * </p>
 * <p>
 * <b>Company</b> Iceburner
 * </p>
 *
 * @author ethssce - 2015-01-05 - Initial version
 */
public class LibraryItemFactoryTest {

    private final static String MOVIE_NAME = "Alien";
    private final static String YEAR = "1979";
    private final static String BOOK_NAME = "The Fifth Elephant";
    private final static String AUTHOR = "Terry Pratchett";
    private final static String ITEM_NAME = "ItemName";
    private final static String DESCRIPTION = "This is some description";

    private LibraryItem mItem;
    private Movie mMovie;
    private Book mBook;

    @Test
    public void testCreateMovieItem() {
        mItem = LibraryItemFactory.createItem(MOVIE_NAME, YEAR, ItemType.MOVIE);
        assertTrue("Item is not created as an instance of Movie", mItem instanceof Movie);
        mItem.setDescription(DESCRIPTION);
        String expectedReturnString = MOVIE_NAME + " (" + YEAR + "): " + DESCRIPTION;
        assertEquals("Movie has not the expected toString representation", expectedReturnString, mItem.toString());
        mMovie = (Movie) mItem;
        assertEquals("Movie has not the assigned year", YEAR, mMovie.getYear());
    }

    @Test
    public void testCreateBookItem() {
        mItem = LibraryItemFactory.createItem(BOOK_NAME, AUTHOR, ItemType.BOOK);
        assertTrue("Item is not created as an instance of Book", mItem instanceof Book);
        mItem.setDescription(DESCRIPTION);
        String expectedReturnString = BOOK_NAME + ", " + AUTHOR + ": " + DESCRIPTION;
        assertEquals("Book has not the expected toString representation", expectedReturnString, mItem.toString());
        mBook = (Book) mItem;
        assertEquals("Book has not the assigned author", AUTHOR, mBook.getAuthor());
    }

    @Test
    public void testCreateLibraryItem() {
        mItem = LibraryItemFactory.createItem(ITEM_NAME, DESCRIPTION, ItemType.OTHER);
        assertTrue("Item is not created as an instance of LibraryItem", mItem instanceof LibraryItem);
        String expectedReturnString = ITEM_NAME + ": " + DESCRIPTION;
        assertEquals("Item has not the expected toString representation", expectedReturnString, mItem.toString());
    }

}
