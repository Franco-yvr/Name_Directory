package ca.ubc.cs.cpsc210.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class UserInterfacefx extends Application {

    private Parent root = null;
    private Stage stage = null;

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
        stage = primaryStage;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memorizer");
//        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeRoot(String fxmlfile) {
//        try {
//            root = FXMLLoader.load(getClass().getResource(fxmlfile));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        Parent root = null;
        try {
            root = FXMLLoader.load(UserInterfacefx.class.getResource(fxmlfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

