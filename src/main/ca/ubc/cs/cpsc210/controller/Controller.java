
package ca.ubc.cs.cpsc210.controller;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import ca.ubc.cs.cpsc210.ui.UserInterfacefx;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ca.ubc.cs.cpsc210.json.*;
import org.json.JSONArray;

import java.net.URL;
import java.util.*;

import static ca.ubc.cs.cpsc210.json.Parser.*;
import static ca.ubc.cs.cpsc210.json.Persistence.*;


import static ca.ubc.cs.cpsc210.observer.Observable.addObserver;
import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    private Parent root;
    private JSONArray originalcontactlist;
    private ObserverPatternDummy dummy;

    public Controller() {
        root = null;
        JSONArray arr = Persistence.readFromDisk();
        if (arr == null) {
            originalcontactlist = new JSONArray();
        } else {
            originalcontactlist = arr;
        }
        dummy = new ObserverPatternDummy();
        addObserver(dummy);
    }

    @FXML
    private TextField searchBox;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> descriptionColumn;
    @FXML
    private TableColumn<Person, String> whereTagColumn;
    @FXML
    private TableColumn<Person, String> connectTagColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField whereTagField;
    @FXML
    private TextField connectTagField;
    @FXML
    private Button profileSaveButton;

    @FXML
    private Button saveButton;

    @FXML
    private TableView<Person> resultTable;

    @FXML
    private Button searchButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private MenuItem sessionentries;

    @FXML
    //MODIFIES: ContactList
    // EFFECTS: Create a new Profile, adds profile to the user ContactList, clear the fields
    public void saveButton(ActionEvent e1) {
        ContactList c = jsonToContactList(originalcontactlist);
        String namefieldtext = nameField.getText();
        String descriptionfieldtext = descriptionField.getText();
        String wheretagfield = whereTagField.getText();
        String connecttagfield = connectTagField.getText();
        Profile p;
        try {
            p = new Profile(namefieldtext, descriptionfieldtext, wheretagfield, connecttagfield);
            c.add(p);
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        originalcontactlist = contactListToJson(c);
        writeToDisk(originalcontactlist);
        nameField.clear();
        descriptionField.clear();
        whereTagField.clear();
        connectTagField.clear();
    }

    // EFFECTS: Convert JSONContactlist
//              Create a list of search results
//              Send list to the person class constructor to ready for display on TableView
//              Display in TableView
//              Erase the textfield
    @FXML
    public void searchButton(ActionEvent e) {
        ContactList c = jsonToContactList(originalcontactlist);
        String searched = searchBox.getText();
        ArrayList<Profile> searchResults = null;
        try {
            searchResults = c.searchResult(searched);
        } catch (EmptyStringException e1) {
            e1.printStackTrace();
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        whereTagColumn.setCellValueFactory(new PropertyValueFactory<>("wheretags"));
        connectTagColumn.setCellValueFactory(new PropertyValueFactory<>("connecttags"));
        ObservableList<Person> data = displayTable(searchResults);
        resultTable.setItems(data);
        searchBox.clear();
    }

    // EFFECTS: Convert the ArrayList into Observable List
//              Flatten the WhereTag and ConnectTag list into a string
//              Return the Observable list for searchButton to use to display
    public ObservableList<Person> displayTable(ArrayList<Profile> searchresults) {
        ObservableList<Person> tablelist = observableArrayList();
        for (Profile p : searchresults) {
            String name = p.getName();
            String description = p.getDescription();
            String wheretag = p.getWhereTag().tagListConcatonation();
            String connecttag = p.getConnectTag().tagListConcatonation();
            Person person = new Person(name, description, wheretag, connecttag);
            tablelist.add(person);
        }
        return tablelist;
    }

    //     EFFECTS: Implements openSessionEntries button under "file" in the user Interface
//                  helper for changeroot method in the UI runner
//                  Calls recent entry method in ObserverPatternDummy as part of Observer Pattern implementation
    @FXML
    public void openSessionEntries(ActionEvent e) {
        UserInterfacefx.changeRoot("../FXML/RecentEntryTable.fxml");
        dummy.recentEntry();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    //    EFFECT: Constructor for making profiles into SimpleStringProperty and utilise TableView
    public class Person {

        private final SimpleStringProperty name;
        private final SimpleStringProperty description;
        private final SimpleStringProperty wheretags;
        private final SimpleStringProperty connecttags;

        private Person(String name, String description, String wheretags, String connecttags) {
            this.name = new SimpleStringProperty(name);
            this.description = new SimpleStringProperty(description);
            this.wheretags = new SimpleStringProperty(wheretags);
            this.connecttags = new SimpleStringProperty(connecttags);
        }

        public String getName() {
            return name.get();
        }

//        public SimpleStringProperty nameProperty() {
//            return name;
//        }

        public String getDescription() {
            return description.get();
        }

        public SimpleStringProperty descriptionProperty() {
            return description;
        }

        public String getWheretags() {
            return wheretags.get();
        }

        public SimpleStringProperty wheretagsProperty() {
            return wheretags;
        }

        public String getConnecttags() {
            return connecttags.get();
        }

        public SimpleStringProperty connecttagsProperty() {
            return connecttags;
        }
    }
}

