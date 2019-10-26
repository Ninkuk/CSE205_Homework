package Assignment7;

import javafx.application.Application;
import javafx.application.Platform;
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
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Scanner in = new Scanner(new File("phoneCalls.txt"));

        ArrayList<PhoneCall> callRecordList = new ArrayList<>();

        // Creates call record objects
        while (in.hasNextLine()) {
            String readLine = in.nextLine();
            String[] lineSplit = readLine.split("/");
            PhoneCall call = new PhoneCall(lineSplit[0], Integer.parseInt(lineSplit[1]), lineSplit[2], lineSplit[3], Double.parseDouble(lineSplit[4]));
            callRecordList.add(call);
        }

        // Left Panel Layout
        VBox optionsMenu = new VBox();

        // Menu Buttons - left panel
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

        // Right Panel Layout
        Label hintText = new Label("Select an option from the menu...");

        VBox rightPanel = new VBox();
        rightPanel.getChildren().add(hintText);
        rightPanel.setSpacing(10);
        rightPanel.setAlignment(Pos.CENTER);

        // Sets the main layout
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #FFFFFF;");
        borderPane.setLeft(optionsMenu);
        borderPane.setRight(rightPanel);
        BorderPane.setMargin(optionsMenu, new Insets(0, 0, 0, 100));
        BorderPane.setMargin(rightPanel, new Insets(0, 100, 0, 0));

        // Number search field and button
        TextField numberInput = new TextField();
        numberInput.setPromptText("Phone Number");
        Button enterButton = new Button("Enter");

        // Button click handlers

        // Shows the search box and button
        searchCallBtn.setOnAction(event -> {
            numberInput.clear();
            rightPanel.getChildren().clear();
            rightPanel.getChildren().addAll(numberInput, enterButton);
            borderPane.setRight(rightPanel);
        });

        // Calls the callSearch method and displays the call info if found
        enterButton.setOnAction(event -> {
            rightPanel.getChildren().clear();

            PhoneCall callSearch;
            callSearch = searchCall(numberInput.getText(), callRecordList);

            if (callSearch == null) {
                hintText.setText("Sorry, no number found! Please try again!");
                rightPanel.getChildren().add(hintText);
            } else {
                printCallInfo(rightPanel, callSearch);
            }

        });

        // Since next 3 methods require the array to be sorted, I will sort it at once here
        sort(callRecordList, 0, callRecordList.size() - 1);

        // Displays the call info of longest call. Gets the object at the last index since it is already sorted
        longestCallBtn.setOnAction(event -> {
            rightPanel.getChildren().clear();
            printCallInfo(rightPanel, callRecordList.get(callRecordList.size() - 1));
        });

        // Displays the call info of shortest call. Gets the object at the first index since it is already sorted
        shortestCallBtn.setOnAction(event -> {
            rightPanel.getChildren().clear();
            printCallInfo(rightPanel, callRecordList.get(0));
        });

        // Displays the number and call duration in a ascending order
        sortCallsBtn.setOnAction(event -> {
            rightPanel.getChildren().clear();
            for (PhoneCall phoneCall : callRecordList) {
                rightPanel.getChildren().add(new Label("Destination Number: " + phoneCall.getNumber() + "\nDuration: " + phoneCall.getDuration()));
            }
        });

        // Creates phone_bills.txt
        prepareBillBtn.setOnAction(event -> {
            PrintWriter out = null;
            try {
                out = new PrintWriter("phone_bills.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("Could be a Relative Path Issue");
            }

            if (out != null) {
                out.println("Destination Number    Duration(m)    Cost($)");
                double total = 0;
                for (PhoneCall phoneCall : callRecordList) {
                    out.println(phoneCall.getNumber() + "          " + phoneCall.getDuration() + "             " + phoneCall.getCost());
                    total += phoneCall.getCost();
                }
                out.println("\nTotal: " + NumberFormat.getCurrencyInstance().format(total));
                out.close();
            } else {
                System.err.println("Error Creating File!");
            }


            rightPanel.getChildren().clear();
            hintText.setText("Phone bill generated successfully!");
            rightPanel.getChildren().add(hintText);
        });

        // Closes the program
        exitBtn.setOnAction(event -> Platform.exit());


        // Create Scene
        Scene scene = new Scene(borderPane, 1000, 500);
        scene.getStylesheets().add("styles.css");

        // Title
        primaryStage.setTitle("Assignment 7 - Phone Calls");

        // Set the scene
        primaryStage.setScene(scene);

        // Show the content on window
        primaryStage.show();
    }

    // Linear Search for String
    private PhoneCall searchCall(String numberToSearch, ArrayList<PhoneCall> callRecordList) {
        for (PhoneCall callRecord : callRecordList) {
            if (numberToSearch.equals(callRecord.getNumber())) {
                return callRecord;
            }
        }

        return null;
    }

    // Quick Sort
    private void sort(ArrayList<PhoneCall> callRecordList, int start, int end) {
        if (start < end) {
            int part = partition(callRecordList, start, end);

            sort(callRecordList, start, part - 1);
            sort(callRecordList, part + 1, end);
        }
    }

    private int partition(ArrayList<PhoneCall> callRecordList, int start, int end) {
        int pivot = callRecordList.get(end).getDuration();
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (callRecordList.get(j).getDuration() < pivot) {
                i++;

                PhoneCall temp = callRecordList.get(i);
                callRecordList.set(i, callRecordList.get(j));
                callRecordList.set(j, temp);
            }
        }

        PhoneCall temp = callRecordList.get(i + 1);
        callRecordList.set(i + 1, callRecordList.get(end));
        callRecordList.set(end, temp);

        return i + 1;
    }

    // Displays the entire call info in the right panel VBOX
    private void printCallInfo(VBox rightPanel, PhoneCall callInfo) {
        rightPanel.getChildren().add(new Label("Number: " + callInfo.number +
                "\nDuration: " + callInfo.getDuration() +
                "\nDate: " + callInfo.getDate() +
                "\nCallee Name: " + callInfo.getCalleeName() +
                "\nCost: $" + callInfo.getCost()));
    }
}