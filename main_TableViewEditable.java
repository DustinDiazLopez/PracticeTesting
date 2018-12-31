package GUI.PracticeTesting;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_TableViewEditable extends Application {

    Stage window;
    TableView<TableView_Product> table;
    TextField nameInput, priceInput, quantityInput;

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

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        TableView_Product product = new TableView_Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));  //TODO validate
        product.setQuantity(Integer.parseInt(quantityInput.getText()));

        //adding to table
        table.getItems().add(product);

        //clear input field
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //delete button clicked
    public void deleteButtonClicked() {
        ObservableList<TableView_Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //get all product (Database)
    public ObservableList<TableView_Product> getProduct() {
        ObservableList<TableView_Product> products = FXCollections.observableArrayList();
        products.add(new TableView_Product("Laptop", 859.99, 20));
        products.add(new TableView_Product("Bouncy Ball", 2.49, 198));
        products.add(new TableView_Product("Toilet", 99.99, 74));
        products.add(new TableView_Product("The Notebook DVD", 5.99, 12));
        products.add(new TableView_Product("Corn", 1.49, 846));
        return products;
    }
}
