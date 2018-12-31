package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main_TreeView extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("title of window");

        TreeItem<String> root, dustin, diaz;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Dustin branch
        dustin = makeBranch("Dustin", root);  //child name and parent
        makeBranch("Chicken", dustin);
        makeBranch("Steak", dustin);
        makeBranch("Subway", dustin);


        //Diaz branch
        diaz = makeBranch("Diaz", root);  //child name and parent
        makeBranch("Hot topic", diaz);
        makeBranch("Stupid", diaz);
        makeBranch("IDK", diaz);

        //create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);  //expands root LEAVE AS IS (creates empty root if set to true)
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
            }
        });

        //layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }

    //Creates branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);  //root sub-item is expanded
        parent.getChildren().add(item);
        return item;
    }

}
