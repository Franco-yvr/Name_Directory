package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.exceptions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;


public class ContactList implements Iterable<Profile> {

    private ArrayList<Profile> contactlist;

    // MODIFIES: this
    // EFFECTS: Construct a arraylist to contain and utilise the new profiles
    public ContactList() {
        this.contactlist = new ArrayList<Profile>();
    }

    // EFFECTS: return contactList field
    public List<Profile> getContactList() {
        return contactlist;
    }

    //MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(Profile profile) {
        contactlist.add(profile);
    }

    //MODIFIES: this
    // EFFECTS: remove item from the list
    public void remove(Profile profile) {
        contactlist.remove(profile);
    }

    // EFFECTS: obtain item to the list
    public Profile getContact(int index) {
        return contactlist.get(index);
    }

    // EFFECTS: obtain number of item in the list
    public int lengthContactList() {
        return contactlist.size();
    }

    //EFFECTS: Search one profile for the keywords entered in the user interface search box
//in each the name, description, wheretag and connecttag. Return true is keyword is found
//in one or more field.
    private boolean searchProfile(Profile profile, String searched) {
        if (profile.getName().contains(searched)
                || profile.getDescription().contains(searched)
                || profile.getWhereTag().searchTag(searched)
                || profile.getConnectTag().searchTag(searched)) {
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: Search the keywords entered in the user interface search box
    // in each the name, description, wheretag and connecttag for each profile
    // contained in ContactList
    public ArrayList<Profile> searchResult(String searched) throws EmptyStringException {
        if (searched.equals("")) {
            throw new EmptyStringException("Entry must not be empty");
        }
        ArrayList<Profile> results = new ArrayList<Profile>();
        for (Profile profile : contactlist) {
            if (searchProfile(profile, searched)) {
                results.add(profile);
            }
        }
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactList that = (ContactList) o;
        return contactlist.equals(that.contactlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactlist);
    }

    @Override
    public Iterator<Profile> iterator() {
        return contactlist.iterator();
    }
//
//    private class ContactListIterator implements Iterator<Profile> {
//
////        private Iterator<Profile> contactlistiterator = contactlist.iterator();
//
//        @Override
//        public boolean hasNext() {
//            return contactlistiterator.hasNext();
//        }
//
//        @Override
//        public Profile next() {
//            if (!contactlistiterator.hasNext()) {
//                throw new NoSuchElementException();
//            }
//            return contactlistiterator.next();
//        }
//    }
//}
}