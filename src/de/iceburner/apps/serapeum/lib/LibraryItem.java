package de.iceburner.apps.serapeum.lib;

/**
 * BaseClass for library items
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
public class LibraryItem {

    private final String mName;
    private String mDescription;
    private boolean mAvailable;

    LibraryItem(String name) {
        mName = name;
        mDescription = "";
        mAvailable = true;
    }

    String getName() {
        return mName;
    }

    void setDescription(String description) {
        mDescription = description;
    }

    String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder(mName);
        if (!mDescription.equals("")) {
            returnString.append(": ");
            returnString.append(mDescription);
        }
        return returnString.toString();
    }

    public void setAvailable(boolean value) {
        mAvailable = value;
    }

    public boolean isAvailable() {
        return mAvailable;
    }
}
