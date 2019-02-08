package ca.ubc.cs.cpsc210.model.Interface_1;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    public List<String> profile;
//REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public void profile(Name name,Description description,WhereTag wheretag,ConnectTag connecttag) {
        this.Name = name;
        Description = description;
        WhereTag = wheretag;
        ConnectTag = connecttag;
    }

    // MODIFIES: this
    // EFFECTS: Add item to the list
    public void add(String item) {
        profile.add(item);
    }

    // MODIFIES: this
    // EFFECTS: Remove item to the list
    public void remove(int index) {
        profile.remove(index);
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

