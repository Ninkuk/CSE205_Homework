import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Pizza extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        TextArea textArea = new TextArea();

        ToggleGroup pizzaTypeGroup = new ToggleGroup();

        RadioButton cheeseSelection = new RadioButton("Cheese");
        cheeseSelection.setToggleGroup(pizzaTypeGroup);
        cheeseSelection.setUserData(10.00);

        RadioButton pepperoniSelection = new RadioButton("Pepperoni");
        pepperoniSelection.setToggleGroup(pizzaTypeGroup);
        pepperoniSelection.setUserData(12.00);

        RadioButton veggieSelection = new RadioButton("Veggie");
        veggieSelection.setToggleGroup(pizzaTypeGroup);
        veggieSelection.setUserData(15.00);

        CheckBox extraCheeseSelection = new CheckBox("Extra Cheese");
        CheckBox baconSelection = new CheckBox("Bacon");
        CheckBox mushroomSelection = new CheckBox("Mushroom");

        Button calcButton = new Button("Calculate Total");
        calcButton.setMaxWidth(primaryStage.getMaxWidth());
        calcButton.setOnAction(action -> {
            Toggle selectedPizzaType = pizzaTypeGroup.getSelectedToggle();
            if (selectedPizzaType == null) {
                textArea.setText("Please select a pizza type!");
                return;
            }

            int numberOfToppings = 0;
            if (extraCheeseSelection.isSelected()) {
                numberOfToppings++;
            }
            if (baconSelection.isSelected()) {
                numberOfToppings++;
            }
            if (mushroomSelection.isSelected()) {
                numberOfToppings++;
            }

            double totalCost = (double) selectedPizzaType.getUserData() + (1.50 * numberOfToppings);
            textArea.setText("$" + totalCost);
        });


        VBox pizzaTypeColumn = new VBox(5);
        pizzaTypeColumn.getChildren().addAll(new Label("Pizza Type"), cheeseSelection, pepperoniSelection, veggieSelection);
//        pizzaTypeColumn.setStyle("-fx-border-style: solid; -fx-border-color: #212121; -fx-border-width: 5");

        VBox pizzaToppingsColumn = new VBox(5);
        pizzaToppingsColumn.getChildren().addAll(new Label("Toppings"), extraCheeseSelection, baconSelection, mushroomSelection);

        HBox hBox = new HBox(25);
        hBox.getChildren().addAll(pizzaTypeColumn, pizzaToppingsColumn);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.setAlignment(Pos.CENTER);


        borderPane.setCenter(vBox);
        borderPane.setTop(new Label("Joe's Pizza"));
        borderPane.setRight(textArea);
        borderPane.setBottom(calcButton);

        //Create Scene
        Scene scene = new Scene(borderPane, 800, 300);

        //TODO set the title
        primaryStage.setTitle("");

        //set the scene
        primaryStage.setScene(scene);

        //show the content on window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
