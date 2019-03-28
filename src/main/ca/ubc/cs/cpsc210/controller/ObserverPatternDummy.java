package ca.ubc.cs.cpsc210.controller;

import ca.ubc.cs.cpsc210.observer.Observer;
import ca.ubc.cs.cpsc210.ui.UserInterfacefx;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javax.swing.table.TableColumn;

import static javafx.collections.FXCollections.observableArrayList;

public class ObserverPatternDummy implements Observer {

    private ObservableList<String> displaylist = observableArrayList();

    @FXML
    private static TableColumn recententrynamecolumn;

    @FXML
    private static TableView<String> recententrytable;
    //Where you left-> you tried implementing a ListView then VBox table instead
//    but still couldnt fill the table, the listView and VBox fxml are now deleted. The problem was at
//    recententrytable.setItems(displaylist); you were receiving a null pointer for recententrytable,
//    then when you created a dummy table, the list still wouldnt display....had to stop debugging.

    ObserverPatternDummy() { }

//    public  void recentEntry() {
////        recententrynamecolumn.setItems(displaylist);
//    }

    @Override
    public void update(String newprofilename) {
        UserInterfacefx.changeRoot("../FXML/RecentEntryTable.fxml");
//        displaylist.add(newprofilename);
    }
}