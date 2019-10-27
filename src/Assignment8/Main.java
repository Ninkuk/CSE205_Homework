package Assignment8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        VBox leftPanel = new VBox();
        VBox rightPanel = new VBox();

        TextArea textArea = new TextArea();
        TextField textField = new TextField();

        HBox sizePanel = new HBox();
        HBox analysisPanel = new HBox();

        RadioButton smallRB = new RadioButton("Small");
        RadioButton mediumRB = new RadioButton("Medium");
        RadioButton largeRB = new RadioButton("Large");

        ToggleGroup radioGroup = new ToggleGroup();

        smallRB.setToggleGroup(radioGroup);
        mediumRB.setToggleGroup(radioGroup);
        largeRB.setToggleGroup(radioGroup);

        //TODO: make it font size
        smallRB.setUserData("Small");
        mediumRB.setUserData("Medium");
        largeRB.setUserData("Large");

        CheckBox wordCountCB = new CheckBox("Word Count");
        CheckBox characterCountCB = new CheckBox("Character Count");
        CheckBox vowelCountCB = new CheckBox("Vowel Count");

        sizePanel.getChildren().addAll(smallRB, mediumRB, largeRB);
        analysisPanel.getChildren().addAll(wordCountCB, characterCountCB, vowelCountCB);

        leftPanel.getChildren().addAll(textArea, sizePanel);
        leftPanel.setPrefWidth(350);
        leftPanel.setPadding(new Insets(10, 5, 10, 10));
        rightPanel.getChildren().addAll(textField, analysisPanel);
        rightPanel.setPrefWidth(350);
        rightPanel.setPadding(new Insets(10, 10, 10, 5));

        borderPane.setLeft(leftPanel);
        borderPane.setRight(rightPanel);

        //Create Scene
        Scene scene = new Scene(borderPane, 700, 1000);

        // Title
        primaryStage.setTitle("Assignment 8");

        //set the scene
        primaryStage.setScene(scene);

        //show the content on window
        primaryStage.show();
    }
}
