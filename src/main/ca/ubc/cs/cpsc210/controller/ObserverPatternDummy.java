package ca.ubc.cs.cpsc210.controller;

import ca.ubc.cs.cpsc210.observer.Observer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static javafx.collections.FXCollections.observableArrayList;

public class ObserverPatternDummy implements Observer {
    
    private  ObservableList<String> displaylist = observableArrayList();

    @FXML
    private static TableColumn recententrynamecolumn;

    @FXML
    private static TableView recententrytable;
    //Where you left-> you tried implementing a ListView then VBox table instead
//    but still couldnt fill the table, the listView and VBox fxml are now deleted. The problem was at
//    recententrytable.setItems(displaylist); you were receiving a null pointer for recententrytable,
//    then when you created a dummy table, the list still wouldnt display....had to stop debugging.

    public ObserverPatternDummy() {
    }

    public  void recentEntry() {
//        recententrynamecolumn.setItems(displaylist);
    }

    @Override
    public void update(String newprofilename) {
        displaylist.add(newprofilename);
    }
}