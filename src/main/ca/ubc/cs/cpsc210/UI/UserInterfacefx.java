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
    public static Stage primaryStage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.primaryStage = primaryStage;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    // How to change scene -> UserInterfacefx.setScene(newScene)
    public static void setScene(Scene scene) {
        try {
            primaryStage.setTitle("Memorizer");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//
//        for loop\
//        button item new button\
//        add below to the obect display window,
//                when start
//        need to
//        load the
//        fmxl using
//        fxml loader
//        and set
//        the scene
//        to it
//        inside bracket, then
//        show it,
//        innmain call launvh
//
//        add save to json at stop method

