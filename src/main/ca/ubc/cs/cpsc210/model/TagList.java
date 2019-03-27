package ca.ubc.cs.cpsc210.model;

import java.util.*;

public class TagList implements Iterable<String> {

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

    //EFFECTS: Search the taglist list for the keywords entered in the user interface search box.
    //Return true is keyword is found.
    public boolean searchTag(String searched) {
        for (int i = 0; i < taglist.size(); i++) {
            if (taglist.get(i).contains(searched)) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: Lays out a list of String into one long string separated with "@" for SearchTabButton
    public String tagListConcatonation() {
        String concatonatedstring = "";
        for (String s : taglist) {
            concatonatedstring = concatonatedstring + "@" + s + " ";
        }
        return concatonatedstring;
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


    @Override
    public Iterator<String> iterator() {
        return new TagListIterator();
    }

    private class TagListIterator implements Iterator<String> {

        private Iterator<String> taglistiterator = taglist.iterator(); //created iterator here

        @Override
        public boolean hasNext() {
            return taglistiterator.hasNext(); //check if iterator pointer has a next element
        }

        @Override
        public String next() {
            if (!taglistiterator.hasNext()) {
                throw new NoSuchElementException();
            }
            return taglistiterator.next();
        }
    }
}