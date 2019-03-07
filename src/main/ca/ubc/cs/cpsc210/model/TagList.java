package ca.ubc.cs.cpsc210.model;

import ca.ubc.cs.cpsc210.model.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static java.util.Arrays.asList;

public class TagList {

    private List<String> tag;

    //MODIFIES:this
    //EFFECTS: Construct a tag list when given a string containing individual tags
    public TagList(String longstring) {
        this.tag = new ArrayList<>(Arrays.asList(longstring.split("@")));
        tag.remove(0);
    }

    //MODIFIES:this
    //EFFECTS: Construct a tag list when given a string containing individual tags
    public TagList() {
        this.tag = new ArrayList();
    }

    // EFFECTS: Return tag object when called
    public List<String> getTag() {
        return tag;
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

    //REQUIRE: TagList list must not be empty
    //EFFECTS: Search the tag list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchTag(String searched)  {
        for (int i = 0; i < tag.size(); i++) {
            if (tag.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }

//    @Override
//    public Iterator<String> iterator() {
//        return tag.iterator();
//    }
}

//implements Iterable<String>
//    public TagList<Tag>(String longstring){
//        Iterable<T> tagList = new ArrayList<>(Arrays.asList(longstring.split("@")));
//        public Tag tag;
//"implement the list interface"


