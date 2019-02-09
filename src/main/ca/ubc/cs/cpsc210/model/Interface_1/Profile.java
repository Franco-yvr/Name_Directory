package ca.ubc.cs.cpsc210.model.Interface_1;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    public List<String> profile;
    private Name name;
    private Description description;
    private WhereTag wheretag;
    private ConnectTag connecttag;


    //REQUIRE: Name field must not be null
    // MODIFIES: this
    // EFFECTS: Construct a profile that contains name, description, wheretag and connecttag fields
    public Profile(Name name, Description description, WhereTag wheretag, ConnectTag connecttag) {
        this.name = name;
        this.description = description;
        this.wheretag = wheretag;
        this.connecttag = connecttag;
    }

    //REQUIRE: Contact list must not be empty
    //EFFECTS: Search one profile for the keywords entered in the user interface search box
    //in each the name, description, wheretag and connecttag. Return true is keyword is found
    //in one or more field.
    public boolean searchProfile(int index, String searched) {
        if (contactlist.getContactList(index).getName().contains(searched) ||
                contactlist.getContactList(index).getDescription().contains(searched) ||
                contactlist.getContactList(index).searchWhereTag() ||
                contactlist.getContactList(index).searchConnectTag()) {
            return true;
        } else {
            return false;
        }


        //REQUIRE: Contact list must not be empty
        //EFFECTS: Search the keywords entered in the user interface search box
        // in each the name, description, wheretag and connecttag for each profile
        // contained in ContactList
        public void createSearchList (String searched){
            int i;
            ArrayList results = new ArrayList<>();
            for (i = 0; i == contactlist.size() - 1; i++) ;
            if(searchProfile(i, searched)){
                results.add(i);
            }




        }
    }


