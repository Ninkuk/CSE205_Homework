import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ClassActivity4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //shapes created here and shown on button click
        Rectangle rectangle = new Rectangle(100, 50, Color.BLUE);
        Circle circle = new Circle(50, Color.RED);
        Line line = new Line(0, 0, 50, 50);

        //Buttons
        Button btnRectangle = new Button("Rectangle");
        Button btnCircle = new Button("Circle");
        Button btnLine = new Button("Line");

        //shows elements horizontally
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnRectangle, btnCircle, btnLine);
        hbox.setAlignment(Pos.CENTER);

        //button to show the rectangle and remove other shapes
        btnRectangle.setOnAction(action -> {
            hbox.getChildren().add(rectangle);
            hbox.getChildren().removeAll(circle, line);
        });

        //button to show the circle and remove other shapes
        btnCircle.setOnAction(action -> {
            hbox.getChildren().add(circle);
            hbox.getChildren().removeAll(rectangle, line);
        });

        //button to show the line and remove other shapes
        btnLine.setOnAction(action -> {
            hbox.getChildren().add(line);
            hbox.getChildren().removeAll(rectangle, circle);
        });

        //For centering hbox vertically
        VBox vbox = new VBox();
        vbox.getChildren().add(hbox);
        vbox.setAlignment(Pos.CENTER);

        //Create Scene
        Scene scene = new Scene(vbox, 750, 500);

        //set the title
        primaryStage.setTitle("Activity #1 - CSE 205");

        //set the scene
        primaryStage.setScene(scene);

        //show the content on window
        primaryStage.show();
    }
}
