package ca.ubc.cs.cpsc210.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Tag {
    public List<String> tag;

    //MODIFIES:this
    //EFFECTS: Construct a tag list when given a string containing individual tags
    public Tag(String longstring) {
        this.tag = new ArrayList<>(Arrays.asList(longstring.split("@")));
        tag.remove(0);
    }

    //MODIFIES:this
    //EFFECTS:Add new item to list of tags
    public void addTag(String newtag) {
        tag.add(newtag);
    }

    // EFFECTS: Return tag Item from the list when called with tag index
    public String getTagItem(int index) {
        return tag.get(index);
    }

    //REQUIRE: Tag list must not be empty
    //EFFECTS: Search the tag list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchTag(String searched) {
        int i;
        for (i = 0; i < tag.size(); i++) {
            if (tag.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }
}


//        while (hasNext(tag)) ;
//        if (next("@")) {
//            int starttag = tag.indexOf("@");
//            int endtag = tag.indexOf("@") - 1;
//            addTag(tag.substring(starttag, endtag));

///MODIFIES: this
// EFFECTS: removes tag from list given index
//public void removeTag(int index) {
//    tag.remove(index);
// }

// EFFECTS: Return true is the Tag strings contains given letter
//public boolean indexOf(String searched) {
//   return tag.indexOf(searched);
//}

//    // MODIFIES: this
//    // EFFECTS: Return tag object when called
//    public List<String> getTag() {
//        return tag;
//    }