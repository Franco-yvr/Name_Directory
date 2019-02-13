package ca.ubc.cs.cpsc210.model;

import java.util.ArrayList;

public class Tag {
    public ArrayList<String> tag;

    public Tag() {
        this.tag = tag;
    }

    //MODIFIES:this
    //EFFECTS: Convert a series of horizontally written tags into a list of tags
    public void convertIntoList(String longstring) {
        tag = new ArrayList<String>();
        while (hasNext(tag)) ;
        if (next("@")) {
            int starttag = tag.indexOf("@");
            int endtag = tag.indexOf("@") - 1;
            addTag(tag.substring(starttag, endtag));
        }
    }

    //MODIFIES:this
    //EFFECTS:Add new item to list of tags
    public void addTag(String newtag) {
        tag.add(newtag);
    }

    // MODIFIES: this
    // EFFECTS: Return tag when index called
    public String getTag(int index) {
        return tag.get(index);
    }

    //REQUIRE: Tag list must not be empty
    //EFFECTS: Search the tag list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchTag(String searched) {
        int i;
        for (i = 0; i == tag.size() - 1; i++) {
            if (tag.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }
}


///MODIFIES: this
// EFFECTS: removes tag from list given index
//public void removeTag(int index) {
//    tag.remove(index);
// }

// EFFECTS: Return true is the Tag strings contains given letter
//public boolean indexOf(String searched) {
//   return tag.indexOf(searched);
//}