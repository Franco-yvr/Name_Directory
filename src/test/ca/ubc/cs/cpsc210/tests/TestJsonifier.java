package ca.ubc.cs.cpsc210.tests;
import ca.ubc.cs.cpsc210.model.exceptions.*;
import ca.ubc.cs.cpsc210.model.ContactList;

import ca.ubc.cs.cpsc210.model.Profile;
import org.junit.jupiter.api.Test;

import static ca.ubc.cs.cpsc210.json.Jsonifier.contactListToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonifier {


    private Profile testprofile = new Profile("Bill", "General manager", "@Vancouver","@notrequired");
    private ContactList testcontactlist = new ContactList();
//    testcontactlist.add(testprofile);

    @Test
    public void testContactListToJson() {
        testcontactlist.add(testprofile);
        contactListToJson(testcontactlist);
        assertEquals(contactListToJson(testcontactlist), "abc");
    }

    @Test
    public void testProfileToJson(){

    }

    @Test
    public void testWhereTagToJson(){

    }

    @Test
    public void testConnectTagToJson(){

    }
}
