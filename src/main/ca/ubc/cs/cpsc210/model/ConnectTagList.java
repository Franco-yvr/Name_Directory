package ca.ubc.cs.cpsc210.model;

public class ConnectTagList extends TagList {

    // MODIFIES: this
    // EFFECTS: Construct a tag to be used as a ConnectTagList entry
    public ConnectTagList(String longstring) {
        super(longstring);
    }

    // MODIFIES: this
    // EFFECTS: Used in Parser: Construct a tag to be used as a ConnectTagList entry
    public ConnectTagList(){
        super();
    }
}
