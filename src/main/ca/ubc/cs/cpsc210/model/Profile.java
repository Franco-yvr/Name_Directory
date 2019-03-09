package ca.ubc.cs.cpsc210.model;


import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Objects;

public class Profile {

    private String name;
    private String description;
    private WhereTagList wheretag;
    private ConnectTagList connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(String name, String description, String wheretag, String connecttag) throws NameFieldEmptyException {
        if (name == "") {
            throw new NameFieldEmptyException("Name field must be filled to create the profile");
        } else {
            this.name = name;
            this.description = description;
            this.wheretag = new WhereTagList(wheretag);
            this.connecttag = new ConnectTagList(connecttag);
        }
    }

    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Used in the parser: Construct a profile that contains name, description, wheretaglist and connecttaglist fields
    public Profile(String name, String description, WhereTagList wheretaglist, ConnectTagList connecttaglist) throws
            NameFieldEmptyException {
        if (name == "") {
            throw new NameFieldEmptyException("Name field must be filled to create the profile");
        } else {
            this.name = name;
            this.description = description;
            this.wheretag = wheretaglist;
            this.connecttag = connecttaglist;
        }
    }

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

    //EFFECTS: overrides the Object class so that the content can be compares rather than the memory location, Return true is keyword is found.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return name.equals(profile.name) &&
                description.equals(profile.description) &&
                wheretag.equals(profile.wheretag) &&
                connecttag.equals(profile.connecttag);
    }

    //EFFECTS: overrides the Object class so that the content can be compares rather than the memory location, Return true is keyword is found.
    @Override
    public int hashCode() {
        return Objects.hash(name, description, wheretag, connecttag);
    }
}


//new Name(name);
//new Description(description);
