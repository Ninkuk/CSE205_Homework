package Assignment7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProxyClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Assignment7/phoneCalls.txt"));

        ArrayList<PhoneCall> callRecordList = new ArrayList<>();

        while (in.hasNextLine()) {
            String readLine = in.nextLine();
            String[] lineSplit = readLine.split("/");
            PhoneCall call = new PhoneCall(lineSplit[0], Integer.parseInt(lineSplit[1]), lineSplit[2], lineSplit[3], Double.parseDouble(lineSplit[4]));
            callRecordList.add(call);
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #FFFFFF;");

        VBox optionsMenu = new VBox();

        Button searchCallBtn = new Button("Call Search");
        Button longestCallBtn = new Button("Longest Call");
        Button shortestCallBtn = new Button("Shortest Call");
        Button sortCallsBtn = new Button("Sort Calls");
        Button prepareBillBtn = new Button("Prepare Phone Bill");
        Button exitBtn = new Button("Exit");
        exitBtn.getStyleClass().add("exit-btn");

        optionsMenu.getChildren().addAll(new Label("Menu"), searchCallBtn, longestCallBtn, shortestCallBtn, sortCallsBtn, prepareBillBtn, exitBtn);
        optionsMenu.setSpacing(10);
        optionsMenu.setAlignment(Pos.CENTER);

        Label hintText = new Label("Select an option from the menu...");

        VBox rightPanel = new VBox();
        rightPanel.getChildren().add(hintText);
        rightPanel.setSpacing(10);
        rightPanel.setAlignment(Pos.CENTER);

        borderPane.setLeft(optionsMenu);
        borderPane.setRight(rightPanel);
        BorderPane.setMargin(optionsMenu, new Insets(0, 0, 0, 100));
        BorderPane.setMargin(rightPanel, new Insets(0, 100, 0, 0));

        TextField numberInput = new TextField();
        numberInput.setPromptText("Phone Number");
        Button enterButton = new Button("Enter");

        searchCallBtn.setOnAction(event -> {
            numberInput.clear();
            rightPanel.getChildren().clear();
            rightPanel.getChildren().addAll(numberInput, enterButton);
            borderPane.setRight(rightPanel);
        });


        enterButton.setOnAction(event -> {
            rightPanel.getChildren().clear();

            PhoneCall callSearch;
            callSearch = searchCall(numberInput.getText(), callRecordList);

            if (callSearch == null) {
                hintText.setText("Sorry, no number found!");
                rightPanel.getChildren().add(hintText);
            } else {
                printCallInfo(rightPanel, callSearch);
            }

        });

        longestCallBtn.setOnAction(event -> {
            rightPanel.getChildren().clear();
            printCallInfo(rightPanel, searchLongestCall(callRecordList));
        });

        shortestCallBtn.setOnAction(event -> {
            rightPanel.getChildren().clear();
            printCallInfo(rightPanel, searchShortestCall(callRecordList));
        });


        //Create Scene
        Scene scene = new Scene(borderPane, 1000, 500);
        scene.getStylesheets().add("./Assignment7/styles.css");

        //title
        primaryStage.setTitle("Assignment 7 - Phone Calls");

        //set the scene
        primaryStage.setScene(scene);

        //show the content on window
        primaryStage.show();
    }

    private PhoneCall searchCall(String numberToSearch, ArrayList<PhoneCall> callRecordList) {
        // linear search
        for (PhoneCall callRecord : callRecordList) {
            if (numberToSearch.equals(callRecord.getNumber())) {
                return callRecord;
            }
        }

        return null;
    }

    private PhoneCall searchLongestCall(ArrayList<PhoneCall> callRecordList) {
        PhoneCall longestCall = null;
        int longestDuration = Integer.MIN_VALUE;
        for (PhoneCall callRecord : callRecordList) {
            if (callRecord.getDuration() > longestDuration) {
                longestCall = callRecord;
            }
        }

        return longestCall;
    }

    private PhoneCall searchShortestCall(ArrayList<PhoneCall> callRecordList) {
        PhoneCall shortestCall = null;
        int shortestDuration = Integer.MAX_VALUE;
        for (PhoneCall callRecord : callRecordList) {
            if (callRecord.getDuration() < shortestDuration) {
                shortestCall = callRecord;
            }
        }

        return shortestCall;
    }

    private void printCallInfo(VBox rightPanel, PhoneCall callInfo) {
        rightPanel.getChildren().add(new Label("Number: " + callInfo.number +
                "\nDuration: " + callInfo.getDuration() +
                "\nDate: " + callInfo.getDate() +
                "\nCallee Name: " + callInfo.getCalleeName() +
                "\nCost: $" + callInfo.getCost()));
    }
}
