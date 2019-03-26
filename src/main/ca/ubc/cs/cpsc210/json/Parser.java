package ca.ubc.cs.cpsc210.json;

import ca.ubc.cs.cpsc210.model.ConnectTagList;
import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.WhereTagList;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Parser {

    // EFFECTS: parses JSONArray represented by JSONContactList and return a non-JSON ContactList
    public static ContactList jsonToContactList(JSONArray ja) {
        ContactList contactlist = new ContactList();
        for (Object jsonprofile : ja) {
            JSONObject castedjsonprofile = (JSONObject) jsonprofile;
            contactlist.add(jsonToProfile(castedjsonprofile));
        }
        return contactlist;
    }

    // EFFECTS: parses JSONObject represented by JSONProfile and return a non-JSON Profile
    public static Profile jsonToProfile(JSONObject p) {
        String name = p.getString("name");
        String description = p.getString("description");
        WhereTagList wheretaglist = jsonToWhereTaglist(p.getJSONArray("wheretaglist"));
        ConnectTagList connecttaglist = jsonToConnectTagList(p.getJSONArray("connecttaglist"));
        Profile profile = null;
        try {
            profile = new Profile(name, description, wheretaglist, connecttaglist);
        } catch (NameFieldEmptyException e) {
            System.out.println("This profile could no be reconstructed because the name field is missing");
        }
        return profile;
    }

    // EFFECTS: Helper for ContactList: parses JSONArray represented by input
    // as a WhereTagList and returns it in non-json
    public static WhereTagList jsonToWhereTaglist(JSONArray ja) {
        WhereTagList wheretaglist = new WhereTagList();
        /// do not need to convert into an arraylist because it was packeaged and sent as array already
        for (Object jsontag : ja) {
            wheretaglist.addTag((String)jsontag);
        }
        return wheretaglist;
    }

    // EFFECTS: Helper for ContactList: parses JSONArray represented
    // by input as a ConnectTagList and returns it in non-json
    public static ConnectTagList jsonToConnectTagList(JSONArray ja) {
        ConnectTagList connecttaglist = new ConnectTagList();
        for (Object jsontag : ja) {
            connecttaglist.addTag((String) jsontag);
        }
        return connecttaglist;
    }
}
