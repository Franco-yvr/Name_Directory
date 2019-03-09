package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.*;
import ca.ubc.cs.cpsc210.model.exceptions.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.ubc.cs.cpsc210.json.Persistence.*;
import static ca.ubc.cs.cpsc210.json.Parser.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestParser {

    private ContactList testcontactlist = new ContactList();
    private Profile testprofile;
    private JSONArray testjsoncontactlist;
    private JSONObject testjsonprofile;
    private JSONArray testjsonwheretaglist;
    private JSONArray testconnecttaglist;

    @BeforeEach
    void setup() {
        try {
            testprofile = new Profile("Bill", "General manager", "@Vancouver", "@notrequired");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        testcontactlist.add(testprofile);
        testjsonprofile = profileToJson(testprofile);
        testjsonwheretaglist = whereTagToJson(testprofile.getWhereTag());
        testconnecttaglist = connectTagToJson(testprofile.getConnectTag());
        testjsoncontactlist = contactListToJson(testcontactlist);
    }

    @Test
    public void testJsonToContactList() {
        assertEquals(jsonToContactList(testjsoncontactlist).getContact(0),testprofile);
    }

    @Test
    public void testJsonToProfile() {
        assertEquals(jsonToProfile(testjsonprofile).getName(), "Bill");
        assertEquals(jsonToProfile(testjsonprofile).getDescription(), "General manager");
        assertEquals(jsonToProfile(testjsonprofile).getWhereTag().getTagItem(0), "Vancouver");
        assertEquals(jsonToProfile(testjsonprofile).getConnectTag().getTagItem(0), "notrequired");
    }

    @Test
    public void testJsonToWhereTaglist() {
        assertEquals(jsonToWhereTaglist(testjsonwheretaglist).getTagItem(0), "Vancouver");
    }

    @Test
    public void testJsonToConnectTagList() {
        assertEquals(jsonToConnectTagList(testconnecttaglist).getTagItem(0),"notrequired");
    }
}
