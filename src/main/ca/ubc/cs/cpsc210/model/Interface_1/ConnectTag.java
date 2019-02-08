package ca.ubc.cs.cpsc210.model.Interface_1;

public class ConnectTag {

        public String connecttag;

        // MODIFIES: this
        // EFFECTS: Construct a tag to be used as a ConnectTag entry
        public void name(String connecttag) {
            this.connecttag = connecttag;
        }

        // MODIFIES: this
        // EFFECTS: Return connecttag when called
        public String getConnectTag() {
            return connecttag;
        }

        // MODIFIES: this
        // EFFECTS: Set connecttag string to new strings
        public void setConnectTag(String connecttag) {
            this.connecttag = connecttag;
        }

        // EFFECTS: Return true if the connecttag strings contains given letter
        public boolean contains(String searched) {
            return false;
        }

}
