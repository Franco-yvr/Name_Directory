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
    //EFFECTS: Convert a series of horizontally written tags into a list of tags
    public void convertIntoList(String tag) {
        connecttag = new ArrayList<String>();
        while (hasNext(tag)) ;
        {
            if (next("@")) {
                int starttag = tag.indexOf("@");
                int endtag = tag.indexOf("@") - 1;
                addTag(tag.substring(starttag, endtag));
            }
        }
    }

    //MODIFIES:this
    //EFFECTS:Add new item to list of tags
    public void addTag(String tag) {
        connecttag.add(tag);
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

    //REQUIRE: tag list must not be empty
    //EFFECTS: Search the tag list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchConnectTag(String searched) {
        int i;
        for (i = 0; i == connecttag.size() - 1; i++) {
            if (connecttag.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }
}