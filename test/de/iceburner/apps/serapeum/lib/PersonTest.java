package de.iceburner.apps.serapeum.lib;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Unit Test for Person class
 *
 * <p>
 * <b>Copyright:</b> Copyright (c) 2015
 * </p>
 * <p>
 * <b>Company</b> Iceburner
 * </p>
 *
 * @author ethssce - 2015-01-07 - Initial version
 */
public class PersonTest {

    private static final String NAME = "John J.";
    private static final String EMAIL = "john.j@somemail.com";
    private static final String PHONE = "017208154711";

    private Person mPerson;

    @Test
    public void testCreatePerson() {
        mPerson = new Person(NAME);
        assertEquals("Person was created with the wrong name", NAME, mPerson.getName());
        assertFalse("Person has items when he should not have", mPerson.hasItems());
    }

    @Test
    public void testToString() {
        mPerson = new Person(NAME);
        String expectedPrintout = NAME;
        assertEquals("toString-Printout was not as expected", expectedPrintout, mPerson.toString());
        mPerson.setMail(EMAIL);
        expectedPrintout = NAME + ", email: " + EMAIL;
        assertEquals("toString-Printout was not as expected", expectedPrintout, mPerson.toString());
        mPerson.setPhone(PHONE);
        expectedPrintout = NAME + ", email: " + EMAIL + ", phone: " + PHONE;
        assertEquals("toString-Printout was not as expected", expectedPrintout, mPerson.toString());
    }

}
