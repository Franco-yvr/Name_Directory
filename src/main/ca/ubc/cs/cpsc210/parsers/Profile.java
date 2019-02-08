package ca.ubc.cs.cpsc210.parsers;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    public List<String> profile;

    // MODIFIES: this
    // EFFECTS: Construct an empty list of profile to store name, description, wheretag and connecttag
    public void profile() {
        this.profile = new ArrayList<>();

    }

    // MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(String item) {
        profile.add(item);
    }

    // MODIFIES: this
    // EFFECTS: obtain item to the list
    public String getProfile(int index) {
        return profile.get(index);
    }

    // MODIFIES: this
// EFFECTS: obtain number of item in the list
    public int length() {
        return profile.size();
    }
}

