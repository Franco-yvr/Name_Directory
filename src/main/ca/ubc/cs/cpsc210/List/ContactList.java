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
    public int length() {
        return contactlist.size();
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search the keywords entered in the user interface search box
    // in each the name, description, wheretag and connecttag for each profile
    // contained in ContactList
    public void createSearchList(String searched) {
        int i;
        ArrayList results = new ArrayList<>();
        for (i = 0; i == contactlist.size() - 1; i++) ;
        if (searchProfile(i, searched)) {
            results.add(i);
        }
    }

    // MODIFIES: ContactList
    // EFFECTS: Create new profile and adds it to the ContactList
    public void saveButton(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        if (name != null) {
            Profile p = new Profile(name, description, wheretag, connecttag);
            contactlist.add(p);
            //Reset: erase fields in interface 1:
            System.out.println("The profile has been created");
        }
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search one profile for the keywords entered in the user interface search box
    //in each the name, description, wheretag and connecttag. Return true is keyword is found
    //in one or more field.
    public boolean searchProfile(int index, String searched) {
        if (getContact(index).getName().contains(searched) ||
                getContact(index).getDescription().contains(searched) ||
                getContact(index).searchWhereTag() ||
                getContact(index).searchConnectTag()) {
            return true;
        } else {
            return false;
        }
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search the keywords entered in the user interface search box
    // in each the name, description, wheretag and connecttag for each profile
    // contained in ContactList
    public void searchResult(String searched) {
        int i;
        ArrayList results = new ArrayList<>();
        for (i = 0; i == contactlist.size() - 1; i++) ;
        if (searchProfile(i, searched)) {
            results.add(i);
        }
    }
}