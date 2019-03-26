
package ca.ubc.cs.cpsc210.controller;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ca.ubc.cs.cpsc210.json.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.*;

import static ca.ubc.cs.cpsc210.json.Parser.*;
import static ca.ubc.cs.cpsc210.json.Persistence.*;


import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    private Parent root;
    private JSONArray originalcontactlist;

    public Controller() {
        root = null;
        JSONArray arr = Persistence.readFromDisk();
        if (arr == null) {
            originalcontactlist = new JSONArray();
        } else {
            originalcontactlist = arr;
        }
    }

    @FXML
    private TextField searchBox;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn descriptionColumn;
    @FXML
    private TableColumn whereTagColumn;
    @FXML
    private TableColumn connectTagColumn;
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

//        System.out.println("The Profile has been created"); ///
//        Label label = new Label("Label");
//        tabPane.setHalignment(label, HPos.CENTER);
//        gridpane.add(label, 0, 0);
    }

    // EFFECTS: -Search the user's contact
    //          -List a complete visual list inside the table
    //          -erase the textfield
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
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("description"));
        whereTagColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("wheretags"));
        connectTagColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("connecttags"));
        ObservableList<Person> data = displayTable(searchResults);
        resultTable.setItems(data);
        searchBox.clear();
    }

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

    //MODIFIES: scene
    // EFFECTS: displays the search result to the table in Search tab
//    private void displayList(List<Profile> listofresults) {
//        List<String> listofnames = new ArrayList();
//        List<String> listofdescriptions = new ArrayList();
//        List<String> listofwheretags = new ArrayList();
//        List<String> listofconnecttags = new ArrayList();
//        for (Profile p : listofresults) {
//            nameColumn.getColumns().add(p.getName());
//            descriptionColumn.getColumns().add(p.getDescription());
//            whereTagColumn.getColumns().add(p.getWhereTag().tagListConcatonation());
//            connectTagColumn.getColumns().add(p.getConnectTag().tagListConcatonation());
//        }
//
//        nameColumn.getColumns().
//                resultTable.refresh();
//
//docs.oracle.com/javafx/2/ui_controls/table-view.htm

//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public class Person {

//        private String name;
//        private String description;
//        private String wheretags;
//        private String connecttags;

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

        public SimpleStringProperty nameProperty() {
            return name;
        }

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
//
//        public void setName(String name) {
//            this.name.set(name);
//        }
//
//        public void setDescription(String description) {
//            this.description.set(description);
//        }
//
//        public void setWheretags(String wheretags) {
//            this.wheretags.set(wheretags);
//        }
//
//        public void setConnecttags(String connecttags) {
//            this.connecttags.set(connecttags);
//        }
        //        public String getName() {
//            return name;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public String getWheretags() {
//            return wheretags;
//        }
//
//        public String getConnecttags() {
//            return connecttags;
//        }
    }


}

//    //MODIFIES: primaryStage
//    // EFFECTS: return the scene associted with the profile tab
//    @FXML
//    public void profileTabButton(ActionEvent e) {
////        try {
////            root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        Scene scene = new Scene(root);
////        primaryStage.setScene(scene);
//    }
//
//    //MODIFIES: primaryStage
//    // EFFECTS: return the scene associted with the search tab
//    @FXML
//    public void searchTabButton(ActionEvent e) {
////        try {
////            root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        Scene scene = new Scene(root);
////        primaryStage.setScene(scene);
//    }

