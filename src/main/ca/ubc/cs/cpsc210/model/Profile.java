package ca.ubc.cs.cpsc210.model;


import java.util.ArrayList;

public class Profile {

    private String name;
    private String description;
    private WhereTagList wheretag;
    private ConnectTagList connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(String name, String description, String wheretag, String connecttag) {
        this.name = name;
        this.description = description;
        this.wheretag = new WhereTagList(wheretag);
        this.connecttag = new ConnectTagList(connecttag);
    }

    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Used in the parser: Construct a profile that contains name, description, wheretaglist and connecttaglist fields
    public Profile(String name, String description, WhereTagList wheretaglist, ConnectTagList connecttaglist) {
        this.name = name;
        this.description = description;
        this.wheretag = wheretaglist;
        this.connecttag = connecttaglist;
    }

    //new Name(name);
    //new Description(description);

    // EFFECTS: Return name when called
//    public Name getName() {return name;
    public String getName() {
        return name;
    }

    // EFFECTS: Return description when called
//    public Description getDescription() {return description;
    public String getDescription() {
        return description;
    }

    // EFFECTS: Return wheretag when called
    public WhereTagList getWhereTag() {
        return wheretag;
    }

    // EFFECTS: Return ConnectTagList when called
    public ConnectTagList getConnectTag() {
        return connecttag;
    }
}


