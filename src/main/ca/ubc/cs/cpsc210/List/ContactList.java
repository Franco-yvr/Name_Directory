package ca.ubc.cs.cpsc210.List;

import ca.ubc.cs.cpsc210.model.*;

import java.util.ArrayList;
import java.util.List;


public class ContactList {

    public List<Profile> contactlist;

    // MODIFIES: this
    // EFFECTS: Construct a arraylist to contain and utilise the new profiles
    public ContactList() {
        this.contactlist = new ArrayList<Profile>();
    }

    // MODIFIES: this
    // EFFECTS: return contactList field
    public List<Profile> getContactList() {
        return contactlist;
    }

    //MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(Profile profile) {
        contactlist.add(profile);
    }

    // MODIFIES: this
    // EFFECTS: obtain item to the list
    public Profile getContact(int index) {
        return contactlist.get(index);
    }

    // MODIFIES: this
    // EFFECTS: obtain number of item in the list
    public int lengthContactList() {
        return contactlist.size();
    }

    // MODIFIES: ContactList
    // EFFECTS: Create new profile and adds it to the ContactList
    public boolean addContact(String name, String description, String wheretag, String connecttag) {
        if (name != "") {
            Profile p = new Profile(name, description, wheretag, connecttag);
            contactlist.add(p);
            return true;
        }
        return false;
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search one profile for the keywords entered in the user interface search box
    //in each the name, description, wheretag and connecttag. Return true is keyword is found
    //in one or more field.
    private boolean searchProfile(int index, String searched) {
        if (getContact(index).getName().getName().contains(searched)
                || getContact(index).getDescription().getDescription().contains(searched)
                || getContact(index).getWhereTag().searchTag(searched)
                || getContact(index).getConnectTag().searchTag(searched)) {
            return true;
        } else {
            return false;
        }
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search the keywords entered in the user interface search box
    // in each the name, description, wheretag and connecttag for each profile
    // contained in ContactList
    public List<Profile> searchResult(String searched) {
        int i;
        List<Profile> results = new ArrayList<>();
        for (i = 0; i < contactlist.size(); i++) {
            if (searchProfile(i, searched)) {
                results.add(contactlist.get(i));
            }
        }
        return results;
    }
}


//REQUIRE: Contact list must not be empty
//    //EFFECTS: Search the keywords entered in the user interface search box
//    // in each the name, description, wheretag and connecttag for each profile
//    // contained in ContactList
//    private void createSearchList(String searched) {
//        int i;
//        ArrayList results = new ArrayList<>();
//        for (i = 0; i == contactlist.size() - 1; i++) ;
//        if (searchProfile(i, searched)) {
//            results.add(i);
//        }
//    }