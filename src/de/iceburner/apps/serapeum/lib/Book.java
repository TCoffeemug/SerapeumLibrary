package de.iceburner.apps.serapeum.lib;

/**
 * Book class for library
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
public class Book extends LibraryItem {

    private final String mAuthor;

    public Book(String name, String author) {
        super(name);
        mAuthor = author;
    }

    public String getAuthor() {
        return mAuthor;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder(super.getName());
        returnString.append(", ");
        returnString.append(mAuthor);
        if (!super.getDescription().equals("")) {
            returnString.append(": ");
            returnString.append(super.getDescription());
        }
        return returnString.toString();
    }

}
