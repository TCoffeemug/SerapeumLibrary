package de.iceburner.apps.serapeum.lib;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit Tests for Movie class
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
public class MovieTest {

    private final static String MOVIE_NAME = "Alien";
    private final static String DESCRIPTION = "This describes the movie";
    private final static String YEAR = "1979";

    private Movie mMovie;

    private void initializeBook() {
        mMovie = new Movie(MOVIE_NAME, YEAR);
        mMovie.setDescription(DESCRIPTION);
    }

    @Test
    public void testCreateBookWithAuthor() {
        initializeBook();
        assertEquals("Movie has not the assigned name", MOVIE_NAME, mMovie.getName());
        assertEquals("Movie has not the assigned year", YEAR, mMovie.getYear());
        assertEquals("Movie has not the set Description", DESCRIPTION, mMovie.getDescription());
    }

    @Test
    public void testBookToString() {
        initializeBook();
        String expectedReturnString = MOVIE_NAME + " (" + YEAR + "): " + DESCRIPTION;
        assertEquals("Movie has not the expected toString representation", expectedReturnString, mMovie.toString());
    }

}
