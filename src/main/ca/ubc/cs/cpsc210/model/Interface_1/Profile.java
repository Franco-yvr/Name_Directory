package ca.ubc.cs.cpsc210.model.Interface_1;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    public List<String> profile;
    private Name name;
    private Description description;
    private WhereTag wheretag;
    private ConnectTag connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        this.name = name;
        this.description = description;
        this.wheretag = wheretag;
        this.connecttag = connecttag;
    }

    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Create new profile that contains name, description, wheretag and connecttag fields
    public void CreateNewProfile(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        this.name = new Name(name);
        this.description = new Description(description);
        this.wheretag = new WhereTag(wheretag);
        this.connecttag = new ConnectTag(connecttag);
    }
}


