package ca.ubc.cs.cpsc210.Controller;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import static ca.ubc.cs.cpsc210.UI.UserInterfacefx.primaryStage;

public class Controller implements Initializable {

    private Parent root = null;
    public ContactList originalcontactlist = new ContactList();

    @FXML private TextField searchBox;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn descriptionColumn;
    @FXML private TableColumn whereTagColumn;
    @FXML private TableColumn connectTagColumn;
    @FXML private TextField nameField;
    @FXML private TextField descriptionField;
    @FXML private TextField whereTagField;
    @FXML private TextField connectTagField;
    @FXML private Button profileSaveButton;
    @FXML private Button searchTabButton;
    @FXML private Button searchButton;

    //MODIFIES: primaryStage
    // EFFECTS: return the scene associted with the profile tab
    @FXML
    public void profileTabButton() {
//        try {
//            root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
    }

    //MODIFIES: primaryStage
    // EFFECTS: return the scene associted with the search tab
    @FXML
    public void searchTabButton() {
//        try {
//            root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
    }

    @FXML
    //MODIFIES: ContactList
    // EFFECTS: Create a new Profile, adds profile to the user ContactList, clear the fields
    public void saveButton() {
        String namefieldtext = nameField.getText();
        String descriptionfieldtext = descriptionField.getText();
        String wheretagfield = whereTagField.getText();
        String connecttagfield = connectTagField.getText();
        Profile p;
        try {
            p = new Profile(namefieldtext, descriptionfieldtext, wheretagfield, connecttagfield);

            originalcontactlist.add(p);
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        nameField.clear();
        descriptionField.clear();
        whereTagField.clear();
        connectTagField.clear();
    }

    // EFFECTS: -Search the user's contact
    //          -List a complete visual list inside the table
    //          -erase the textfield
    @FXML
    public void searchButton(TextField searchBox) {
        String searched = searchBox.getText();
        List<Profile> listofresults = new ArrayList<>();
        try {
            listofresults = originalcontactlist.searchResult(searched);
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }
        displayList(listofresults);
        searchBox.clear();
    }

    //MODIFIES: scene
    // EFFECTS: displays the search result to the table in Search tab
    private void displayList(List<Profile> listofresults) {
//        List<String> listofnames = new ArrayList();
//        List<String> listofdescriptions = new ArrayList();
//        List<String> listofwheretags = new ArrayList();
//        List<String> listofconnecttags = new ArrayList();
        for (Profile p : listofresults) {
            nameColumn.getColumns().add(p.getName());
            descriptionColumn.getColumns().add(p.getDescription());
            whereTagColumn.getColumns().add(p.getWhereTag().tagListConcatonation());
            connectTagColumn.getColumns().add(p.getConnectTag().tagListConcatonation());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}