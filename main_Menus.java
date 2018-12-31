package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main_Menus extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Title of window");

        //File menu
        Menu fileMenu = new Menu("_File");

        //Menus Items (File)
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open.."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        newFile.setOnAction(e -> System.out.println("Pasting some shite"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        //help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected()) {
                System.out.println("Program will now display line numbers...");
            } else {
                System.out.println("Hiding line numbers...");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Auto Save");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("_Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, difficultyMenu, helpMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }
}
