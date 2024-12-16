package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.awt.*;

public class Controller {
    private Button btnAdd;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<?> tableEquipment;

    @FXML
    private void addEquipment() {
        String name = txtName.getText();
        // Add logic to insert into the database using your existing CRUD functionality
        System.out.println("Added: " + name);
    }
}
