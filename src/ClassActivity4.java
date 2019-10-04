import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ClassActivity4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Shape shape = null;

    @Override
    public void start(Stage primaryStage) {

        shape = new Circle();

        Button btnRectangle = new Button("Rectangle");
        Button btnCircle = new Button("Circle");
        Button btnLine = new Button("Line");

        btnRectangle.setOnAction(action -> {
            shape = new Rectangle();
        });

        btnCircle.setOnAction(action -> {
            shape = new Circle(5, Color.RED);
        });

        btnLine.setOnAction(action -> {

        });

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnRectangle, btnCircle, btnLine, shape);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox);
        vbox.setAlignment(Pos.CENTER);

        //Create Scene
        //TODO replace node/view accordingly
        Scene scene = new Scene(vbox, 200, 200);

        //set the title
        primaryStage.setTitle("Activity #1 - CSE 205");

        //set the scene
        primaryStage.setScene(scene);

        //show the content on window
        primaryStage.show();
    }
}
