package ca.ubc.cs.cpsc210.model;


public class Profile {

    public Profile profile;
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

    // MODIFIES: this
    // EFFECTS: Return name when called
    public Name getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: Return description when called
    public Description getDescription() {
        return description;
    }

    // MODIFIES: this
    // EFFECTS: Return wheretag when called
    public WhereTag getWhereTag() {
        return wheretag;
    }

    // MODIFIES: this
    // EFFECTS: Return ConnectTag when called
    public ConnectTag getConnectTag() {
        return connecttag;
    }



}


