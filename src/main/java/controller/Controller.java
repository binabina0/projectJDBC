package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputText;

    @FXML
    private VBox outputText;

    @FXML
    private TableView<?> tables;

    @FXML
    void initialize() {
        assert inputText != null : "fx:id=\"inputText\" was not injected: check your FXML file 'sample.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'sample.fxml'.";
        assert tables != null : "fx:id=\"tables\" was not injected: check your FXML file 'sample.fxml'.";

    }

}
