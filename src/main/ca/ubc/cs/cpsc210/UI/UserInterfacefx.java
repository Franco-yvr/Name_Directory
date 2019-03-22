package ca.ubc.cs.cpsc210.UI;

import ca.ubc.cs.cpsc210.model.ContactList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.rmi.runtime.NewThreadAction;


import java.io.IOException;

public class UserInterfacefx extends Application {

    private Parent root = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/SearchScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memorizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

