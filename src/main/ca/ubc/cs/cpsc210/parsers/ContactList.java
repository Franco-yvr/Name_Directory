package ca.ubc.cs.cpsc210.parsers;

import java.util.ArrayList;
import java.util.List;


public class ContactList {

    public List<ArrayList> contactlist;

    // MODIFIES: this
    // EFFECTS: Construct a arraylist to contain and utilise the new contacts
    public void ContactList() {
        this.contactlist = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(Profile profile) {
        contactlist.add(profile);
    }

    // MODIFIES: this
    // EFFECTS: obtain item to the list
    public ArrayList getContactList(int index) {
        return contactlist.get(index);
    }

    // MODIFIES: this
    // EFFECTS: obtain number of item in the list
    public int length() {
        return contactlist.size();
    }
}