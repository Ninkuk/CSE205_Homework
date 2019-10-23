package Templates;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFX_Template extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Create Scene
        //TODO replace node/view accordingly
        Scene scene = new Scene(new Pane(), 200, 200);

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
