package ca.ubc.cs.cpsc210.model;public class Description {    public String description;    // MODIFIES: this    // EFFECTS: Construct a description for a person's description    public Description(String description) {        this.description = description;    }    // MODIFIES: this    // EFFECTS: Return description when called    public String getDescription() {        return description;    }    // MODIFIES: this    // EFFECTS: Set description string to new strings    public void setDescription(String newdescription) {        this.description = newdescription;    }}