package ca.ubc.cs.cpsc210.model.Interface_1;

import java.util.List;

import ca.ubc.cs.cpsc210.List.ContactList;

import javax.sound.midi.Soundbank;

public class SaveAction {

    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Create new profile that contains name, description, wheretag and connecttag fields
    public void CreateNewProfile(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        name = new Name(name);
        description = new Description(description);
        wheretag = new WhereTag(wheretag);
        connecttag = new ConnectTag(connecttag);
    }

    public void saveAction(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        if (name != null) {
            contactlist.add(CreateNewProfile(name, description, wheretag, connecttag));
            //Reset: erase fields in interface 1:
            System.out.println("The profile has been created");
        }
    }
}
