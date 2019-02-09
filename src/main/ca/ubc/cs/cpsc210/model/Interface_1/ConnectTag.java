package ca.ubc.cs.cpsc210.model.Interface_1;

import java.util.ArrayList;

public class ConnectTag {

    public ArrayList<String> connecttag;

    // MODIFIES: this
    // EFFECTS: Construct a tag to be used as a ConnectTag entry
    public ConnectTag() {
        this.connecttag = connecttag;
    }


    //MODIFIES:this
    //EFFECTS: Create a new tag list for tags to be added
    public void CreateConnectTag() {
        connecttag = new ArrayList();
    }

    //MODIFIES:this
    //EFFECTS:Add new item to list of tags
    public void addTag(String tag) {
        connecttag.add(tag);
    }

    // MODIFIES: this
    // EFFECTS: removes last tag from list if not empty
    public void removeLastTag() {
        if (!connecttag.isEmpty()) {
            int lastConnectTagIndex = connecttag.size() - 1;
            connecttag.remove(lastConnectTagIndex);
        }
    }

    // MODIFIES: this
    // EFFECTS: Return tag when index called
    public String getTag(int index) {
        return connecttag.get(index);
    }

    // MODIFIES: this
    // EFFECTS: removes tag from list given index
    public void removeTag(int index) {
        connecttag.remove(index);
    }

    // EFFECTS: Return true is the ConnectTag strings contains given letter
    public int indexOf(String searched) {
        return connecttag.indexOf(searched);
    }
}