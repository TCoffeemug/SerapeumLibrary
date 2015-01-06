package de.iceburner.apps.serapeum.lib;

/**
 * Movie class for library
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
public class Movie extends LibraryItem {

    private final String mYear;

    public Movie(String name, String year) {
        super(name);
        mYear = year;
    }

    public String getYear() {
        return mYear;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder(super.getName());
        returnString.append(" (");
        returnString.append(mYear);
        returnString.append(")");
        if (!super.getDescription().equals("")) {
            returnString.append(": ");
            returnString.append(super.getDescription());
        }
        return returnString.toString();
    }
}
