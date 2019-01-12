package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main_Closing_Correctly extends Application {

    Stage window;
    Button button;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button = new Button("Close program");

        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Title", "Are you sure you want to quit?");

        if (answer) {
            window.close();
        }
    }
}

