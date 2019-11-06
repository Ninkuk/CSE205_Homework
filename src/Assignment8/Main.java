package Assignment8;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Layout
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

        // radiobutton data is font size
        smallRB.setUserData(10);
        mediumRB.setUserData(15);
        largeRB.setUserData(20);

        largeRB.setSelected(true);
        textArea.setFont(new Font("Arial", 20));

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton selectedOption = (RadioButton) newValue;
                textArea.setFont(new Font("Arial", Double.parseDouble(selectedOption.getUserData().toString())));
            }
        });

        CheckBox[] checkBoxes = new CheckBox[3];
        String[] checkBoxValues = {"Word Count", "Character Count", "Vowel Count"};
        String[] displayedValues = {"", "", ""};

//        for (int i = 0; i < checkBoxes.length; i++) {
//            CheckBox checkBox = new CheckBox(checkBoxValues[i]);
//            checkBoxes[i] = checkBox;
//            analysisPanel.getChildren().add(checkBox);
//
//            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                    if (newValue) {
//                        displayedValues
//                    }
//                    textField.setText(textField.getText() +);
//                }
//            });
//        }

        CheckBox wordCountCB = new CheckBox("Word Count");
        CheckBox characterCountCB = new CheckBox("Character Count");
        CheckBox vowelCountCB = new CheckBox("Vowel Count");

        wordCountCB.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    displayedValues[0] = "Word Count: 5";
                } else {
                    displayedValues[0] = "";
                }

                refreshTextField(textField, displayedValues);
            }
        });

        characterCountCB.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    displayedValues[1] = "Character Count: 6";
                } else {
                    displayedValues[1] = "";
                }

                refreshTextField(textField, displayedValues);
            }
        });

        vowelCountCB.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    displayedValues[2] = "Vowel Count: 6";
                } else {
                    displayedValues[2] = "";
                }

                refreshTextField(textField, displayedValues);
            }
        });


        // Layout Styles
        textArea.setPrefHeight(650);
        textField.setPrefHeight(650);

        sizePanel.getChildren().addAll(smallRB, mediumRB, largeRB);
        sizePanel.setAlignment(Pos.CENTER);
        sizePanel.setSpacing(10);
        analysisPanel.getChildren().addAll(wordCountCB, characterCountCB, vowelCountCB);
        analysisPanel.setAlignment(Pos.CENTER);
        analysisPanel.setSpacing(10);

        leftPanel.getChildren().addAll(textArea, sizePanel);
        leftPanel.setPrefWidth(350);
        leftPanel.setPadding(new Insets(10, 5, 10, 10));
        leftPanel.setSpacing(10);
        rightPanel.getChildren().addAll(textField, analysisPanel);
        rightPanel.setPrefWidth(350);
        rightPanel.setPadding(new Insets(10, 10, 10, 5));
        rightPanel.setSpacing(10);

        borderPane.setLeft(leftPanel);
        borderPane.setRight(rightPanel);

        // Creates Scene
        Scene scene = new Scene(borderPane, 700, 700);

        // Sets Title
        primaryStage.setTitle("Assignment 8");

        // Set the scene
        primaryStage.setScene(scene);

        // Show the content on window
        primaryStage.show();
    }

    private void refreshTextField(TextField textField, String[] displayedValues) {
        //Cannot create multiline text in TextField thus results showed in single line
        //Wouldn't Label be a better and more convenient way to display the output?
        textField.setText(displayedValues[0] + " " + displayedValues[1] + " " + displayedValues[2]);
    }
}
