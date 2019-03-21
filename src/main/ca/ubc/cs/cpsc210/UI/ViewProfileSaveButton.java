package ca.ubc.cs.cpsc210.UI;

import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.IOException;


public class ViewProfileSaveButton {
    private static final String fxmlstring = "src/main/ca.ubc.cs.cpsc210/FXML/File.fxml";
    private File fxmlfile = new File(fxmlstring);
    //ensures that it is well connected with scene builder//declares scene builder type and name variable as scene builder id

    public static void profileSaved() {
        this.load();
    }

    private void load() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlfile.toURI().toURL());
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}