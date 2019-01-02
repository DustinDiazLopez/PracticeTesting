package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class main_Properties extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Title of window");

        Properties_Persons dustin = new Properties_Persons();
        dustin.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): "+ dustin.firstNameProperty());
            System.out.println("getFirstName(): " + dustin.getFirstName());
        });

        button = new Button("Submit");
        button.setOnAction(e -> {
            dustin.setFirstName("Dustin Díaz");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }
}
