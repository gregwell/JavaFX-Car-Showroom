package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

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


}
