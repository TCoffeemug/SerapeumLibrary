package de.iceburner.apps.serapeum.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Map<String, Person> mPersons;
    private Map<String, String> mItemToPersonIds;

    public Library() {
        mLibraryItems = new HashMap();
        mPersons = new HashMap<>();
        mItemToPersonIds = new HashMap<>();
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

    /**
     * adds a Person to the Library and returns the assigned ID
     *
     * @param person - Person - person to add to library
     * @return String - ID that is connected to the person
     */
    public String addPerson(Person person) {
        String key = createKey(person.getName().substring(0, 4));
        mPersons.put(key, person);
        return key;
    }

    public Person getPerson(String id) {
        return mPersons.get(id);
    }

    /**
     * checks out an item to a person if the item is still available
     *
     * @param itemId - item in question
     * @param personId - person in question
     * @return boolean - true if checkOut was successful, otherwise false
     */
    boolean checkOut(String itemId, String personId) {
        LibraryItem item = mLibraryItems.get(itemId);
        if (item.isAvailable()) {
            item.setAvailable(false);
            mItemToPersonIds.put(itemId, personId);
            return true;
        }
        return false;
    }

    public String getPersonForItem(String itemId) {
        return mItemToPersonIds.get(itemId);
    }

    /**
     * returns a list of Items borrowed by a person
     *
     * @param personId - theID of the person
     * @return List - a list of itemIDs
     */
    public List<String> getItemsForPerson(String personId) {
        List<String> itemList = new ArrayList<>();
        for (String itemId : mItemToPersonIds.keySet()) {
            if (personId.equals(mItemToPersonIds.get(itemId))) {
                itemList.add(itemId);
            }
        }
        return itemList;
    }

    boolean checkIn(String itemId) {
        if (mItemToPersonIds.containsKey(itemId)) {
            mItemToPersonIds.remove(itemId);
            mLibraryItems.get(itemId).setAvailable(true);
            return true;
        }
        return false;
    }
}
