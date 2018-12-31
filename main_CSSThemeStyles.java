package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main_CSSThemeStyles extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("title of window");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name
        Label nameLabel = new Label("Username: ");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);

        //input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        //password
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 1);

        //password input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        //login button
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);

        //signup button
        Button signUpButton = new Button("Sign Up");
        GridPane.setConstraints(signUpButton, 1, 3);
        signUpButton.getStyleClass().add("button-blue");
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

        Scene scene = new Scene(grid, 400, 200);
        scene.getStylesheets().add("CSS.css");
        window.setScene(scene);
        window.show();
    }
}
