//package ca.ubc.cs.cpsc210.controller;
//
//import javafx.collections.ObservableArray;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//import org.json.JSONArray;
//
//import javax.swing.table.TableColumn;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecentEntryController {
//
//    private static Parent root = null;
//    private static ObservableList<String> recententrycontactlist;
//
//    @FXML
//    private static TableColumn recententrynamecolumn;
//
//    @FXML
//    private static TableView recententrytable;
//
//
//    public static void recentEntryController() {
//        try {
//            root = FXMLLoader.load(RecentEntryController.class.getResource("../FXML/RecentEntryTable.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        recententrynamecolumn.setCellValueFactory(new PropertyValueFactory<Controller.Person, String>("name"));
//        recententrytable.setItems(recententrycontactlist);
//        Scene scene = new Scene(root);
//        Stage primaryStage = null;
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public void update() {
//        recententrycontactlist = new ObservableArray<String>();
//        recententrycontactlist.add()
//
//    }
//
//}