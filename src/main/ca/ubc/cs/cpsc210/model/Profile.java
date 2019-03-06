package ca.ubc.cs.cpsc210.model;


import com.sun.org.glassfish.gmbal.Description;

public class Profile {

    private String name;
    private String description;
    private WhereTag wheretag;
    private ConnectTag connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(String name, String description, String wheretag, String connecttag) {
        this.name = name;
        this.description = description;
        this.wheretag = new WhereTag(wheretag);
        this.connecttag = new ConnectTag(connecttag);
    }
    //new Name(name);
    //new Description(description);

    // EFFECTS: Return name when called
//    public Name getName() {return name;
    public String getName() {return name;
    }

    // EFFECTS: Return description when called
//    public Description getDescription() {return description;
    public String getDescription() {return description;
    }

    // EFFECTS: Return wheretag when called
    public WhereTag getWhereTag() {
        return wheretag;
    }

    // EFFECTS: Return ConnectTag when called
    public ConnectTag getConnectTag() {
        return connecttag;
    }
}


