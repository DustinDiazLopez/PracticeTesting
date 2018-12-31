package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_TableView extends Application {

    Stage window;
    TableView<TableView_Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Title of window");

        //Name Column
        TableColumn<TableView_Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));  //must be same as variable

        //Price Column
        TableColumn<TableView_Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));  //must be same as variable

        //Quantity Column
        TableColumn<TableView_Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));  //must be same as variable

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //get all product (Database)
    public ObservableList<TableView_Product> getProduct() {
        ObservableList<TableView_Product> products = FXCollections.observableArrayList();
        products.add(new TableView_Product("Laptop", 859.99, 20));
        products.add(new TableView_Product("Bouncy Ball", 2.49, 198));
        products.add(new TableView_Product("Toilet", 99.99, 74));
        products.add(new TableView_Product("The Notebook", 5.99, 12));
        products.add(new TableView_Product("Corn", 1.49, 846));
        return products;
    }
}
