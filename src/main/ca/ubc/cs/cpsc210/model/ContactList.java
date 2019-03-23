package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.exceptions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ContactList {

    private List<Profile> contactlist;

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

    // EFFECTS: obtain item to the list
    public Profile getContact(int index) {
        return contactlist.get(index);
    }

    // EFFECTS: obtain number of item in the list
    public int lengthContactList() {
        return contactlist.size();
    }

    //REQUIRE: Contact list must not be empty
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

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search the keywords entered in the user interface search box
    // in each the name, description, wheretag and connecttag for each profile
    // contained in ContactList
    public List<Profile> searchResult(String searched) throws EmptyStringException {
        if (searched.equals("")) {
            throw new EmptyStringException("Entry must not be empty");
        }
        int i;
//        List<Profile> results = new ArrayList<>();
        ObservableList<Profile> results = FXCollections.observableArrayList();
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
}

//https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java

//    // MODIFIES: this
//    // EFFECTS: Create new profile and adds it to the ContactList
//    public boolean addContact(String name, String description, String wheretag, String connecttag) {
//        if (name != "") {
//            Profile p = new Profile(name, description, wheretag, connecttag);
//            contactlist.add(p);
//            return true;
//        }
//        return false;
//    }

//        for (i = 0; i < contactlist.size(); i++) {
//        if (searchProfile(i, searched)) {
//        results.add(contactlist.get(i));
//        }
//        }
//        return results;
//        }