package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main_Embedding_Layout extends Application {

    Stage window;
    Button button;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title of window");

        HBox topMenu = new HBox();
        Button a = new Button("File");
        Button e = new Button("Edit");
        Button v = new Button("View");
        topMenu.getChildren().addAll(a, e, v);

        VBox leftMenu = new VBox();
        Button dd = new Button("D");
        Button ee = new Button("E");
        Button ff = new Button("F");
        leftMenu.getChildren().addAll(dd, ee, ff);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
