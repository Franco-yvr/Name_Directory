package ca.ubc.cs.cpsc210.json;

import ca.ubc.cs.cpsc210.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static JSONArray readFromDisk() {
        try {
            String str = readFile("./contacts.json", Charset.defaultCharset());
            return new JSONArray(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void writeToDisk(JSONArray jsonArray) {
        String str = jsonArray.toString();
        // then write that String to disk inside a .json file
        try (PrintStream out = new PrintStream(new FileOutputStream("contacts.json"))) {
            out.print(str);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}