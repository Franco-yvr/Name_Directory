package ca.ubc.cs.cpsc210.Controller;

import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ca.ubc.cs.cpsc210.UI.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.security.PrivateKey;
import java.util.ResourceBundle;

public class ControllerProfileSaveButton implements Initializable {
    @FXML
    private TextField nameField;
    private TextField descriptionField;
    private TextField whereTagField;
    private TextField connectTagField;

    @FXML
    private Button profileSaveButton;

    @FXML
    public void saveButton(ActionEvent event) {
        String namefieldtext = nameField.getText();
        String descriptionfieldtext = descriptionField.getText();
        String wheretagfield = whereTagField.getText();
        String connecttagfield = connectTagField.getText();
        try {
            Profile p = new Profile(namefieldtext, descriptionfieldtext, wheretagfield, connecttagfield);

        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        ViewProfileSaveButton.profileSaved();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
