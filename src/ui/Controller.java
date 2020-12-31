package ui;

import api.CarShowroom;
import api.CarShowroomContainer;
import api.Vehicle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane topPane;
    @FXML
    private Button buttonX;
    @FXML
    private Button buttonMinimize;
    @FXML
    private Label titleLabel;
    @FXML
    private Pane backgroundPane;
    @FXML
    private Button buttonRemove;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<CarShowroom> comboBox;
    @FXML
    private TableView<Vehicle> table;
    @FXML
    private TableColumn<Vehicle, String> colBrand;
    @FXML
    private TableColumn<Vehicle, String> colModel;
    @FXML
    private TableColumn<Vehicle, String> colShowroomName;
    @FXML
    private TableColumn<Vehicle, String> colEngine;
    @FXML
    private TableColumn<Vehicle, Integer> colPrice;
    @FXML
    private TableColumn<Vehicle, Integer> colYear;



    CarShowroomContainer container = new CarShowroomContainer();

    private ObservableList<Vehicle> observableTable = FXCollections.observableArrayList();
    private ObservableList<CarShowroom> observableComboBox = FXCollections.observableArrayList();

    @FXML
    private void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void minimizeApp(ActionEvent actionEvent) {
        Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void changeColorToYellow(ActionEvent actionEvent) {
        colorChange("yellow","#ffbe2f", "#000000");
    }
    public void changeColorToRed(ActionEvent actionEvent) {
        colorChange("red","#FF0000", "#FFFFFF");
    }
    public void changeColorToGreen(ActionEvent actionEvent) {
        colorChange("green","#28cc42", "#000000");
    }

    private void colorChange(String colorName, String bgColor, String textColor) {
        topPane.setStyle("-fx-background-color:" + bgColor);
        buttonX.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);
        buttonMinimize.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);
        titleLabel.setStyle("-fx-text-fill: " + textColor);
        backgroundPane.setStyle("-fx-border-color: " + bgColor);
        buttonRemove.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor);

        for (int i =0 ; i<6 ; i++ ) {
            table.getColumns().get(i).getStyleClass().clear();
            table.getColumns().get(i).getStyleClass().add(colorName+"-header");
            table.getColumns().get(i).getStyleClass().add(colorName+"-hover");
            table.getColumns().get(i).getStyleClass().add(colorName+"-selection");
        }
    }

    private void initTable(CarShowroomContainer container) {

        for (Map.Entry<String, CarShowroom> entry : container.getCarShowroomsMap().entrySet()) {
            CarShowroom c = entry.getValue();
            for (Vehicle vehicles : c.sortByName()) {
                observableTable.addAll(vehicles);
                
            }
        }

        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colShowroomName.setCellValueFactory((car)->new SimpleStringProperty(car.getValue().getCarShowroom().getCarCenterName()));
        colEngine.setCellValueFactory(new PropertyValueFactory<>("engineCapacity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("prodYear"));

        table.setItems(observableTable);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        container = DataGenerator.loadData();

        //observableTable<Vehicle> , observableComboBox<CarShowroom>

        initTable(container);
        initComboBox(container);
        colorChange("yellow","#ffbe2f", "#000000");
        initTableSearcher();
        initTooltip();
    }

    private void initComboBox(CarShowroomContainer container) {

        observableComboBox.addAll(container.getCarShowroomsMap().values());

        comboBox.setCellFactory(comboBox -> new ListCell<CarShowroom>(){
            @Override
            protected void updateItem(CarShowroom carShowroom, boolean b) {
                super.updateItem(carShowroom, b);
                if(carShowroom == null || b) {
                    setText("Showing all showrooms");
                } else {
                    setText(carShowroom.getCarCenterName());
                }
            }
        });

        comboBox.getItems().add(new CarShowroom("all",0));
        comboBox.getItems().addAll(observableComboBox);
        comboBox.getSelectionModel().select(0);
    }

    public void refreshTableFromComboBox(ActionEvent actionEvent) {

        CarShowroom showroom = comboBox.getSelectionModel().getSelectedItem();
        if(showroom != null) {
            if(showroom.getCarCenterName().equals("all")) {
                table.setItems(observableTable);
            }
            else {
                FilteredList<Vehicle> filteredList = new FilteredList<>(observableTable);
                filteredList.setPredicate(vehicle -> {
                    if (vehicle.getCarShowroom().equals(showroom))
                        return true;
                    return false;
                });
                table.setItems(filteredList);
            }
            initTableSearcher();
        }
    }

    private void initTableSearcher() {

        FilteredList<Vehicle> filteredList = new FilteredList<>(table.getItems(), b->true);
        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate((vehicle -> {
                if(newValue==null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCased = newValue.toLowerCase();

                return vehicle.getName().toLowerCase().contains(lowerCased);
            }));
        });

        SortedList<Vehicle> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedList);

    }

    private void initTooltip() {
        table.setRowFactory(tableView-> new TableRow<Vehicle>(){
            private Tooltip tooltip = new Tooltip();

            @Override
            protected void updateItem(Vehicle vehicle, boolean b) {
                super.updateItem(vehicle, b);
                if(vehicle==null){
                    setTooltip(null);
                }else{
                    tooltip.setText("Condition: " + vehicle.getCondition());
                    setTooltip(tooltip);
                }
            }
        });
    }

    public void removeCar(ActionEvent actionEvent) {
        Vehicle selectedVehicle = table.getSelectionModel().getSelectedItem();
        observableTable.remove(selectedVehicle);
        //remove from container/carshowrrom
    }
}














