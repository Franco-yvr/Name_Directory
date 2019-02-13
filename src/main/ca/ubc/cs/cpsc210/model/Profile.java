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
    // EFFECTS: Return profile when called
    public Profile getProfile() {
        return profile;
    }

    // MODIFIES: this
    // EFFECTS: Set the profile string to new string
    public void setProfile(Profile profile) {
        this.profile = profile;
    }



}


