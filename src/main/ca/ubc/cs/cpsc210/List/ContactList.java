package ca.ubc.cs.cpsc210.List;

import ca.ubc.cs.cpsc210.model.Interface_1.Profile;

import java.util.ArrayList;
import java.util.List;


public class ContactList {

    public List<ArrayList> contactlist;

    // MODIFIES: this
    // EFFECTS: Construct a arraylist to contain and utilise the new contacts
    public ContactList() {
        this.contactlist = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(Profile profile) {
        contactlist.add(profile);
    }

    // MODIFIES: this
    // EFFECTS: obtain item to the list
    public Profile getContactList(int index) {
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
    public void createSearchList (String searched){
        int i;
        ArrayList results = new ArrayList<>();
        for (i = 0; i = contactlist.size() - 1; i++) ;
        if(searchProfile(i, searched)){
            results.add(i);
        }
    }
}