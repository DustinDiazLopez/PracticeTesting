package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_CheckBox extends Application {
    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Checkbox");

        //CheckBox
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        //button
        button = new Button("Order Now!");
        button.setOnAction(e -> handleActions(box1, box2));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }

    private void handleActions(CheckBox box1, CheckBox box2) {
        String message = "You want with your sub: \n";

        if (box1.isSelected()) {
            message += "+ bacon\n";
        }
        if (box2.isSelected()) {
            message += "+ tuna\n";
        }

        System.out.println(message);
    }
}
