package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main_Confirm_Box extends Application {

    Stage window;
    Button button;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        button = new Button("Click me you filthy animal!");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("title of window", "Are you sure?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}
