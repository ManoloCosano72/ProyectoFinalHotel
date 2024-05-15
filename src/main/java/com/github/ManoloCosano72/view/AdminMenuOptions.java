package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Room;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuOptions extends Controller implements Initializable {
    //@FXML
    //private AnchorPane anchorPane;
    @FXML
    private Button findClients;
    //@FXML
    //private Button findClientsByDni;
    //@FXML
    //private Button findClientsByName;
    @FXML
    private Button deleteClients;
    @FXML
    private Button updateData;
    @FXML
    private Button createRooms;
    @FXML
    private Button updateRoom;
    @FXML
    private Button findRoomByCode;
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
    private TableColumn<Room, String> columnCodReserve;
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

    }

    @FXML
    public void goToFindClients() throws Exception {

    }

    //@FXML
    //public void goToFindClientsByDni() throws Exception {

    //}

    //@FXML
    //public void goToFindClientsByName() throws Exception {
    //    App.currentController.changeScene(Scenes.FINDCLIENTSBYNAME, null);
    //}

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
    public void goToFindRoomsByCode() throws Exception {
        App.currentController.openModal(Scenes.FINDROOMBYCODE, "Encontrar habitacion", this, null);
    }

    @FXML
    public void goToDeleteRooms() throws Exception {
        App.currentController.openModal(Scenes.DELETEROOM, "Eliminar habitacion", this, null);
    }

    @FXML
    public void goToFindAllRooms() throws Exception {

    }
}
