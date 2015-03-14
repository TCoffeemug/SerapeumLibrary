package de.iceburner.apps.serapeum.lib;

/**
 * Person class that can lend items from the Library
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
public class Person {

    private final String mName;
    private String mEmail;
    private String mPhone;
    private boolean mHasItems;

    public Person(String name) {
        mName = name;
        mEmail = "";
        mPhone = "";
        mHasItems = false;
    }

    public void setMail(String mail) {
        mEmail = mail;
    }

    public void setPhone(String phonenumber) {
        mPhone = phonenumber;
    }

    public String getName() {
        return mName;
    }

    public String getMail() {
        return mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder(mName);
        if (!mEmail.equals("")) {
            returnString.append(", email: ");
            returnString.append(mEmail);
        }
        if (!mPhone.equals("")) {
            returnString.append(", phone: ");
            returnString.append(mPhone);
        }
        return returnString.toString();
    }
    
    public void setHasItems(boolean value) {
        mHasItems = value;
    }

    public boolean hasItems() {
        return mHasItems;
    }
}
