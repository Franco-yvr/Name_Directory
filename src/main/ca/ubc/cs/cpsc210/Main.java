//package ca.ubc.cs.cpsc210;
//
//import ca.ubc.cs.cpsc210.model.ContactList;
//import ca.ubc.cs.cpsc210.model.Profile;
//import javafx.event.Event;
//import javafx.geometry.Pos;
//import javafx.scene.control.*;
//import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//TabPane tabPane = new TabPane();
//import java.awt.*;
//import java.awt.Label;
//import java.util.Optional;
//
//public class Main extends Application implements EventHandler<ActionEvent> {
//
//    private Button button1 = new Button();
//    private Button button2 = new Button();
//    private Stage stage1 = new Stage();
//    private Stage stage2 = new Stage();
//    private Scene scene1;
//    private Scene scene2;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
////        stage1 = primaryStage;
//
//        Label label1 = new Label("Welcome to Scene 1");
//        Label label2 = new Label("Welcome to Scene 2");
//
//        Pane layout = new Pane();
//        layout.getChildren().add(button1);
//        layout.getChildren().add(button2);
//        button1.setText("Go to scene 1");
//        button2.setText("Go to scene 2");
//        button1.setOnAction(e -> stage2.setScene(scene2));
//        button2.setOnAction(e -> stage1.setScene(scene1));
//
//        scene1 = new Scene(layout, 800, 600);
//        scene2 = new Scene(layout, 800, 600);
//
//        stage1.setTitle("Memorizer");
//
//        stage1.show();
////
////        button.setOnAction(new EventHandler<ActionEvent>){
////            //look in "this" class for the handle button
////            @Override
////            public void handle (ActionEvent event){
////                if (event.getSource() == button) {
////                    //insert call here
////                }
//
//
//    }
//
//    @Override
//    public void handle(ActionEvent event) {
//        System.out.println("hello");
//    }
//}
//
//
////        public void userPressesSearchButton(String word) {
////            try {
////                ContactList.searchResult("Bill");
////            }
////            catch (EmptyStringException e) {
////                System.out.println("Please type an entry");
////            }
//////        }
//////    }
//////    }
////public class SelectableToolButton extends ToggleButton
////{
////    // If empty, indicates the "Select" tool
////    private final Optional<DiagramElement> aPrototype;
////
////    /**
////     * Creates a button to represent the "select" tool.
////     *
////     * @param pImage The image representing the tool.
////     * @param pToolTip A short sentence describing the tool.
////     * @param pToggleGroup The toggle group this button is part of.
////     * @pre pImage != null && pToolTip != null && pToggleGroup != null.
////     */
////    public SelectableToolButton(Image pImage, String pToolTip, ToggleGroup pToggleGroup)
////    {
////        assert pImage != null && pToolTip != null && pToggleGroup != null;
////        setStyle("-fx-background-radius: 0");
////        aPrototype = Optional.empty();
////        setGraphic(new ImageView(pImage));
////        setToggleGroup(pToggleGroup);
////        setSelected(true);
////        setTooltip(new Tooltip(pToolTip));
////        setAlignment(Pos.BASELINE_LEFT);
////        setOnAction( pEvent -> setSelected(true) );
////    }
//
//
//
////public class DiagramTab extends Tab implements MouseDraggedGestureHandler