package ca.ubc.cs.cpsc210.json;

import ca.ubc.cs.cpsc210.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Persistence {

    // EFFECTS: returns JSONArray representing a ContactList
    public static JSONArray contactListToJson(ContactList c) {
        JSONArray contactListInJson = new JSONArray();
        for (Profile p : c.getContactList()) {
            contactListInJson.put(profileToJson(p));
        }
        return contactListInJson;
    }

    // EFFECTS: returns JSONObject representing a profile
    public static JSONObject profileToJson(Profile p) {
        JSONObject profileInJson = new JSONObject();
        profileInJson.put("name", p.getName());
        profileInJson.put("description", p.getDescription());
        profileInJson.put("wheretaglist", whereTagToJson(p.getWhereTag()));
        profileInJson.put("connecttaglist", connectTagToJson(p.getConnectTag()));
        return profileInJson;
    }

    // EFFECTS: returns JSONArray representing a WhereTagList
    public static JSONArray whereTagToJson(WhereTagList wt) {
        JSONArray whereTagInJson = new JSONArray();
        for (String t : wt.getTaglist()) {
            whereTagInJson.put(t);
        }
        //System.out.println(whereTagInJson);
        return whereTagInJson;
    }

    // EFFECTS: returns JSONArray representing a ConnectTagList
    public static JSONArray connectTagToJson(ConnectTagList ct) {
        JSONArray connectTagInJson = new JSONArray();
        for (String t : ct.getTaglist()) {
            connectTagInJson.put(t);
        }
        return connectTagInJson;
    }
//
//    //EFFECTS: Just add a new profile to the current JSONContactList
//    public static JSONObject addJSONProfileToJSONContactList(Profile p){
//        WHERE-THE-CONTACT-LIST-IS-STORED.put(profileToJson(p));
//    }
}