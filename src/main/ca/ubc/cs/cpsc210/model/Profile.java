package ca.ubc.cs.cpsc210.model;


public class Profile {

    private Name name;
    private Description description;
    private WhereTag wheretag;
    private ConnectTag connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(String name, String description, String wheretag, String connecttag) {
        this.name = new Name(name);
        this.description = new Description(description);
        this.wheretag = new WhereTag(wheretag);
        this.connecttag = new ConnectTag(connecttag);
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


