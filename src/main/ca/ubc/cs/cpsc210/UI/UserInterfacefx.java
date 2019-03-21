package ca.ubc.cs.cpsc210.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class UserInterfacefx extends Application {
    Parent root = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            root = FXMLLoader.load(getClass().getResource("File.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
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

