package ca.ubc.cs.cpsc210.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import org.json.JSONArray;

import javax.swing.table.TableColumn;

public class RecentEntryController {

    private Parent root;
    private JSONArray recententrycontactlist;

    public void RecentEntryController() {

    }

    @FXML
    private TableColumn recententrynamecolumn;

    @FXML
    private TableColumn recententrydescriptioncolumn;

    @FXML
    private TableColumn recententrywheretagcolumn;

    @FXML
    private TableColumn recententryconnecttagcolumn;


}

