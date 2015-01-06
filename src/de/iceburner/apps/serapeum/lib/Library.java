package de.iceburner.apps.serapeum.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Library class
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
public class Library {

    private Map<String, LibraryItem> mLibraryItems;

    public Library() {
        mLibraryItems = new HashMap();
    }

    private String createKey(String substring) {
        String key = substring + "001";
        int i = 1;
        while (mLibraryItems.containsKey(key)) {
            i++;
            if (i < 10) {
                key = substring + "00" + i;
            } else if (i < 100) {
                key = substring + "0" + i;
            } else {
                key = substring + i;
            }
        }
        return key;
    }

    /**
     * adds a Item to the Library and returns the assigned ID
     *
     * @param item - LibraryItem - item to add to library
     * @return String - ID that is connected to the item
     */
    public String addItem(LibraryItem item) {
        String key = createKey(item.getName().substring(0, 4));
        mLibraryItems.put(key, item);
        return key;
    }

    public LibraryItem getItem(String id) {
        return mLibraryItems.get(id);
    }

}
