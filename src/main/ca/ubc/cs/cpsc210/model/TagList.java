package ca.ubc.cs.cpsc210.model;

import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;

public class TagList {

    private List<String> taglist;

    //MODIFIES:this
    //EFFECTS: Construct a taglist list when given a string containing individual tags
    public TagList(String longstring) {
        this.taglist = new ArrayList<>(Arrays.asList(longstring.split("@")));
        taglist.remove(0);
    }

    //MODIFIES:this
    //EFFECTS: Construct a taglist list when given a string containing individual tags
    public TagList() {
        this.taglist = new ArrayList();
    }

    // EFFECTS: Return taglist object when called
    public List<String> getTaglist() {
        return taglist;
    }

    //MODIFIES:this
    //EFFECTS:Add new item to list of tags
    public void addTag(String newtag) {
        taglist.add(newtag);
    }

    // EFFECTS: Return taglist Item from the list when called with taglist index
    public String getTagItem(int index) {
        return taglist.get(index);
    }

    //REQUIRE: TagList list must not be empty
    //EFFECTS: Search the taglist list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchTag(String searched)  {
        for (int i = 0; i < taglist.size(); i++) {
            if (taglist.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: overrides the Object class so that the content
    // can be compares rather than the memory location,
    // Return true is keyword is found.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TagList)) {
            return false;
        }
        TagList tagList = (TagList) o;
        return taglist.equals(tagList.taglist);
    }

    //EFFECTS: overrides the Object class so that the content
    // can be compares rather than the memory location,
    // Return true is keyword is found.
    @Override
    public int hashCode() {
        return Objects.hash(taglist);
    }

    //    @Override
//    public Iterator<String> iterator() {
//        return taglist.iterator();
//    }
}

//implements Iterable<String>
//    public TagList<Tag>(String longstring){
//        Iterable<T> tagList = new ArrayList<>(Arrays.asList(longstring.split("@")));
//        public Tag taglist;
//"implement the list interface"

// Utilises CollectionUtils.isEqualCollection to compare the fields that are lists:
// public static boolean isEqualCollection(java.util.Collection a, java.util.Collection b) in CollectionUtils library
//       return CollectionUtils.isEqualCollection(taglist, tagList.getTaglist());
