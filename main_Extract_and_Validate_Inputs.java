package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_Extract_and_Validate_Inputs extends Application {
    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of page!");

        //Form
        TextField nameInput = new TextField();
        button = new Button("Submit");

        //when clicked
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(nameInput, button);

        scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String message){
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is " + age + " years old.");
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a valid input.");
            return false;
        }
    }

    private boolean isDouble(TextField input, String message){
        try {
            double number = Double.parseDouble(input.getText());
            System.out.println(number);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a number.");
            return false;
        }
    }
}
