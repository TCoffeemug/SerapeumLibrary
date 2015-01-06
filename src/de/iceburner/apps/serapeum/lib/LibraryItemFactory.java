package de.iceburner.apps.serapeum.lib;

/**
 * factory for library items
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
public class LibraryItemFactory {

    /**
     * ItemTypes available to put in library. If you want to store anything else
     * than books or movies in the library, please use OTHER
     */
    public enum ItemType {

        BOOK, MOVIE, OTHER
    }

    /**
     * Factory creates LibraryItem or one of its subclasses
     *
     * @param name - String - name of the Library Item
     * @param info - String - additional info: Author (BOOK), Year (MOVIE), Description (OTHER)
     * @param type - ItemType - BOOK, MOVIE or OTHER
     * @return LibraryItem - depending on type it could be subclasses Book, Movie
     */
    public static LibraryItem createItem(String name, String info, ItemType type) {
        switch (type) {
            case BOOK:
                return new Book(name, info);
            case MOVIE:
                return new Movie(name, info);
            case OTHER:
                LibraryItem item = new LibraryItem(name);
                item.setDescription(info);
                return item;
        }
        throw new IllegalArgumentException("Incorrect type value");
    }

}
