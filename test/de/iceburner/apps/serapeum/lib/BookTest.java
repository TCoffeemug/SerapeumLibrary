package de.iceburner.apps.serapeum.lib;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit Tests for Book class
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
public class BookTest {

    private final static String BOOK_NAME = "The Fifth Elephant";
    private final static String DESCRIPTION = "This describes the book";
    private final static String AUTHOR = "Terry Pratchett";

    private Book mBook;

    private void initializeBook() {
        mBook = new Book(BOOK_NAME, AUTHOR);
        mBook.setDescription(DESCRIPTION);
    }

    @Test
    public void testCreateBookWithAuthor() {
        initializeBook();
        assertEquals("Book has not the assigned name", BOOK_NAME, mBook.getName());
        assertEquals("Book has not the assigned author", AUTHOR, mBook.getAuthor());
        assertEquals("Book has not the set Description", DESCRIPTION, mBook.getDescription());
    }

    @Test
    public void testBookToString() {
        initializeBook();
        String expectedReturnString = BOOK_NAME + ", " + AUTHOR + ": " + DESCRIPTION;
        assertEquals("Book has not the expected toString representation", expectedReturnString, mBook.toString());
    }

}
