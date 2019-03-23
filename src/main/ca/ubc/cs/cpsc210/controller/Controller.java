
package ca.ubc.cs.cpsc210.controller;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    private Parent root = null;
    public ContactList originalcontactlist = new ContactList();

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
    private TableView resultTable;

    @FXML
    private Button searchButton;

    @FXML
    private TabPane tabPane;


    @FXML
    //MODIFIES: ContactList
    // EFFECTS: Create a new Profile, adds profile to the user ContactList, clear the fields
    public void saveButton(ActionEvent e1) {
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
        System.out.println("The Profile has been created");
//        Label label = new Label("Label");
//        tabPane.setHalignment(label, HPos.CENTER);
//        gridpane.add(label, 0, 0);
        System.out.println(originalcontactlist.getContact(0).getName());
    }

    // EFFECTS: -Search the user's contact
    //          -List a complete visual list inside the table
    //          -erase the textfield
    @FXML
    public void searchButton(ActionEvent e) {
        String searched = searchBox.getText();
//        List<Profile> listofresults = new ArrayList<>();
        List<Profile> searchResults = null;
//        FXCollections.observableArrayList();
        try {
            searchResults = originalcontactlist.searchResult(searched);
        } catch (EmptyStringException e1) {
            e1.printStackTrace();
        }
        System.out.println(searchResults.get(0).getName());
//        displayList(listofresults);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Description"));
        whereTagColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("WhereTag"));
        connectTagColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("ConnectTag"));
        resultTable = new TableView<Person>();
        resultTable.setItems(displayTable(searchResults));
//        resultTable.getColumns().addAll(nameColumn, descriptionColumn, whereTagColumn,connectTagColumn);
        searchBox.clear();
    }

    private ObservableList<Person> displayTable(List<Profile> searchresults) {
        ObservableList<Person> tablelist = FXCollections.observableArrayList();
        for (Profile p : searchresults) {
            String name = p.getName();
            String description = p.getDescription();
            System.out.println(p.getDescription());
            String wheretag = p.getWhereTag().tagListConcatonation();
            System.out.println(wheretag);
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

    private class Person {

        private String name;
        private String description;
        private String wheretags;
        private String connecttags;

        private Person(String name, String description, String wheretags, String connecttags) {
            this.name = name;
            this.description = description;
            this.wheretags = wheretags;
            this.connecttags = connecttags;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getWheretags() {
            return wheretags;
        }

        public String getConnecttags() {
            return connecttags;
        }
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

