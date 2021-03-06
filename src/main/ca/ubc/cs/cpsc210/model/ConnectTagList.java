package ca.ubc.cs.cpsc210.model;

public class ConnectTagList extends TagList {

    // MODIFIES: this
    // EFFECTS: Construct a tag to be used as a ConnectTagList entry
    public ConnectTagList(String longstring) {
        super(longstring);
    }

    // MODIFIES: this
    // EFFECTS: Used in Parser: Construct a tag to be used as a ConnectTagList entry
    public ConnectTagList() {
        super();
    }
}
























//Note: it has been noted that the ConnectTagList and WhereTagList are identical
//and extending TagList which contain all the implementations. Although it may
//look redundant at this moment, this distinction will be necessary in the future because
//I plan to add functionalities to ConnectTagList such as
// - Notification to connect with the person at the specified time
// - Creation of a calendar that can be synced with google calendar
// - Addition of reason to reconnect and the discussion to be held
// Therefore, for easing the development of these funtionalities in the future, keeping
// ConnectTagList is beneficial