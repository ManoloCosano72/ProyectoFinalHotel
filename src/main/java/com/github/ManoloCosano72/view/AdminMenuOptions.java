package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Room;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminMenuOptions extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button findClients;
    @FXML
    private Button deleteClients;
    @FXML
    private Button updateData;
    @FXML
    private Button createRooms;
    @FXML
    private Button updateRoom;
    @FXML
    private Button deleteRooms;
    @FXML
    private Button findAllRooms;
    @FXML
    private TableView<Client> tableViewClient;
    @FXML
    private TableColumn<Client, String> columnDNI;
    @FXML
    private TableColumn<Client, String> columnName;
    @FXML
    private TableColumn<Client, String> columnSurnames;
    @FXML
    private TableColumn<Client, String> columnPhone;
    @FXML
    private TableColumn<Client, String> columnMail;
    @FXML
    private TableColumn<Client, Integer> columnAdmin;
    @FXML
    private TableView<Room> tableViewRoom;
    @FXML
    private TableColumn<Room, String> columnCodRoom;
    @FXML
    private TableColumn<Room, Integer> columnBeds;
    @FXML
    private TableColumn<Room, Integer> columnWindows;
    @FXML
    private TableColumn<Room, String> columnTypeR;
    @FXML
    private TableColumn<Room, Integer> columnPrice;
    @FXML
    private ImageView closeSession;
    private ObservableList<Client> clients;
    private ObservableList<Room> rooms;

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnDNI.setCellValueFactory(clients -> new SimpleStringProperty(clients.getValue().getDni()));
        columnName.setCellValueFactory(clients -> new SimpleStringProperty(clients.getValue().getName()));
        columnSurnames.setCellValueFactory(clients -> new SimpleStringProperty(clients.getValue().getSurnames()));
        columnPhone.setCellValueFactory(clients -> new SimpleStringProperty(clients.getValue().getPhone()));
        columnMail.setCellValueFactory(clients -> new SimpleStringProperty(clients.getValue().getMail()));
        columnAdmin.setCellValueFactory(clients -> new SimpleIntegerProperty(clients.getValue().getAdmin()).asObject());

        tableViewRoom.setEditable(true);
        columnCodRoom.setCellValueFactory(rooms -> new SimpleStringProperty(rooms.getValue().getCodRoom()));
        columnBeds.setCellValueFactory(rooms -> new SimpleIntegerProperty(rooms.getValue().getBeds()).asObject());
        columnBeds.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        columnWindows.setCellValueFactory(rooms -> new SimpleIntegerProperty(rooms.getValue().getBeds()).asObject());
        columnTypeR.setCellValueFactory(rooms -> new SimpleStringProperty(rooms.getValue().getTypeR().toString()));
        columnPrice.setCellValueFactory(rooms -> new SimpleIntegerProperty(rooms.getValue().getPrice()).asObject());
        columnBeds.setOnEditCommit(event -> {
            if(event.getNewValue()== event.getOldValue()){
                return;
            }

            if(event.getNewValue() > 0){
                Room roomUpdated = event.getRowValue();
                roomUpdated.setBeds(event.getNewValue());
                RoomDAO.build().update(roomUpdated);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No es valido");
                alert.show();
            }
        });
    }

    @FXML
    public void goToDeleteClients() throws Exception {
        App.currentController.openModal(Scenes.DELETECLIENTS, "Eliminar cliente", this, null);
    }

    @FXML
    public void goToUpdateData() throws Exception {
        App.currentController.openModal(Scenes.UPDATEDATAFROMADMIN, "Actualizar datos", this, null);
    }

    @FXML
    public void goToCreateRooms() throws Exception {
        App.currentController.openModal(Scenes.CREATEROOMS, "Crear habitacion", this, null);
    }

    @FXML
    public void goToUpdateRoom() throws Exception {
        App.currentController.openModal(Scenes.UPDATEROOMS, "Actualizar habitacion", this, null);
    }

    @FXML
    public void goToDeleteRooms() throws Exception {
        App.currentController.openModal(Scenes.DELETEROOM, "Eliminar habitacion", this, null);
    }

    @FXML
    public void findAllClients() throws Exception {
        List<Client> clients = ClientDAO.build().findAll();
        this.clients = FXCollections.observableList(clients);
        tableViewClient.setItems(this.clients);
    }

    @FXML
    public void findAllRooms() throws Exception {
        List<Room> rooms = RoomDAO.build().findAll();
        this.rooms = FXCollections.observableList(rooms);
        tableViewRoom.setItems(this.rooms);
    }
}
