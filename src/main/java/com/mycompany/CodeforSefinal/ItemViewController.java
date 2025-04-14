package com.mycompany.CodeforSefinal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


    

public class ItemViewController implements Initializable{
    
    // Implementing all JavaFX ids so that they can be utilized in the code 
    @FXML private Button returnButton;
    @FXML private TableView<Item> itemViewTable;
    @FXML private TableColumn<Item, Long> IDFX;
    @FXML private TableColumn<Item, String> NameFX;
    @FXML private TableColumn<Item, Double> ItemPriceFX;
    
    // Test ArrayList - does nothing for now 
    private ArrayList<Invoice> invoiceItems = new ArrayList<>();
    
    // Needed imports for JavaFX
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // FXML Connected method, uses ActionEvent to detect when the button "return" is pressed, when it is pressed it will call the method. 
    @FXML
    private void handleReturnToInvoiceView(ActionEvent event) throws IOException {
        
        // Code that will load up the "InvoiceViewController.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvoiceViewPage.fxml"));
        root = loader.load();
        InvoiceViewController controller = loader.getController();
        
        // Code that loads up the "primary.fxml"
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    // FXML file that runs when the "secondary.fxml" loads
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Fake back-end filler data
              
        Item item1 = new Item(1, "Washing Machine", 200.0);
        Item item2 = new Item(2, "Toaster Oven", 100.0);
        Item item3 = new Item(3, "Microwave", 150.0);
        ArrayList<Item> testArray = new ArrayList<Item>();
        testArray.add(item1);
        testArray.add(item2);
        testArray.add(item3);
        
        // The arraylist must be turned into a obervablelist to be observed by the viewTable
        ObservableList<Item> observableItems = FXCollections.observableArrayList(testArray);
        
        // Checks all the getter methods inside of the Invoice and searches for the attribute in the quotes
        // If it finds it, it will call its getter method found inside the invoice class, if there is no getter then the program will fail
        IDFX.setCellValueFactory(new PropertyValueFactory<Item, Long>("itemId"));
        NameFX.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        ItemPriceFX.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));

        // Set the tableView to display these attributes
        itemViewTable.setItems(observableItems);
        
    }
    
   
    }
    
    
    
    
    

                