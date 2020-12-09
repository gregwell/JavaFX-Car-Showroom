package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Pane topPane;
    @FXML
    private Button buttonX;
    @FXML
    private Button buttonMinimize;
    @FXML
    private Label titleLabel;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Pane backgroundPane;
    @FXML
    private Button buttonRemove;

    @FXML
    private void closeApp(ActionEvent actionEvent) {
        System.out.println("X clicked!"); //temporarly just show in a terminal
        System.exit(0);
    }

    @FXML
    private void minimizeApp(ActionEvent actionEvent) {
        System.out.println("app minimized!");
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void changeColorToYellow(ActionEvent actionEvent) {
        colorChange("#ffbe2f", "#000000");
    }

    private void colorChange(String bgColor, String textColor) {
        topPane.setStyle("-fx-background-color:" + bgColor);
        buttonX.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);
        buttonMinimize.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);
        titleLabel.setStyle("-fx-text-fill: " + textColor);
        backgroundPane.setStyle("-fx-border-color: " + bgColor);
        buttonRemove.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);
    }

    public void changeColorToRed(ActionEvent actionEvent) {
        colorChange("#FF0000", "#FFFFFF");
    }

    public void changeColorToGreen(ActionEvent actionEvent) {
        colorChange("#28cc42", "#000000");
    }
}
