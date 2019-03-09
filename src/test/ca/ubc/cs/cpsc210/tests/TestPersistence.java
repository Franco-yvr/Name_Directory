package ca.ubc.cs.cpsc210.tests;
import ca.ubc.cs.cpsc210.model.*;
import ca.ubc.cs.cpsc210.model.exceptions.*;
import org.json.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ca.ubc.cs.cpsc210.json.Persistence.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestPersistence {

    private ContactList testcontactlist = new ContactList();
    private Profile testprofile;

    @BeforeEach
            void setup(){
        try {
            testprofile = new Profile("Bill", "General manager", "@Vancouver", "@notrequired");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        testcontactlist.add(testprofile);
    }

    @Test
    public void testContactListToJson() {
        JSONArray data = contactListToJson(testcontactlist);
        assertEquals(data.getJSONObject(0).get("name"), "Bill");
        assertEquals(data.getJSONObject(0).get("description"), "General manager");
        assertEquals(data.getJSONObject(0).getJSONArray("wheretaglist").getString(0) ,"Vancouver");
        assertEquals(data.getJSONObject(0).getJSONArray("connecttaglist").getString(0), "notrequired");
    }

    @Test
    public void testProfileToJson() {
        JSONObject data = profileToJson(testprofile);
        assertEquals(data.get("name"), "Bill");
        assertEquals(data.get("description"), "General manager");
        assertEquals(data.getJSONArray("wheretaglist").getString(0) ,"Vancouver");
        assertEquals(data.getJSONArray("connecttaglist").getString(0), "notrequired");
    }

    @Test
    public void testWhereTagToJson() {
        WhereTagList testwheretaglist = new WhereTagList("@BigNose@OneEye@LongTeeth");
        JSONArray data = whereTagToJson(testwheretaglist);
        assertEquals(data.getString(0),"BigNose");
        assertEquals(data.getString(1),"OneEye");
        assertEquals(data.getString(2),"LongTeeth");
    }

    @Test
    public void testConnectTagToJson() {
        ConnectTagList testconnecttaglist = new ConnectTagList("@Kitsilano@SanFrancisco@Portland");
        JSONArray data = connectTagToJson(testconnecttaglist);
        assertEquals(data.getString(0),"Kitsilano");
        assertEquals(data.getString(1),"SanFrancisco");
        assertEquals(data.getString(2),"Portland");
    }
}
