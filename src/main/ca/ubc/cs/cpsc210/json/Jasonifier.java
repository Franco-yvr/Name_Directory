package ca.ubc.cs.cpsc210.json;

import ca.ubc.cs.cpsc210.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Jasonifier {

    // EFFECTS: returns JSONArray representing a ContactList
    public static JSONArray contactListToJson(ContactList c) {
        JSONArray contactListJson = new JSONArray();
        for (Profile p : c) {
            contactListJson.put(profileToJson(p));
        }
        return contactListJson;
    }

    // EFFECTS: returns JSONObject representing a profile
    public static JSONObject profileToJson(Profile p) {
        JSONObject profileJson = new JSONObject();
        profileJson.put("name", p.getName());
        profileJson.put("description", p.getDescription());
        profileJson.put("whereTag", whereTagToJson(p.getWhereTag()));
        profileJson.put("connectTag", connectTagToJson(p.getConnectTag()));
        return profileJson;
    }

    // EFFECTS: returns JSONArray representing a WhereTag
    public static JSONArray whereTagToJson(WhereTag wt) {
        JSONArray whereTagJson = new JSONArray();
        for (String t : wt) {
            whereTagJson.put(t);
        }
        return whereTagJson;
    }


    // EFFECTS: returns JSONArray representing a ConnectTag
    public static JSONArray connectTagToJson(ConnectTag ct) {
        JSONArray connectTagJson = new JSONArray();
        for (String t : ct) {
            connectTagJson.put(t);
        }
        return connectTagJson;
    }    }
}