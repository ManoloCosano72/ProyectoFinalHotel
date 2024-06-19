package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ReserveDAO;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.entity.Reserve2;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.session.Session;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateReserveFromClient extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldDate;
    @FXML
    private ComboBox<Room> ComboBoxRoom;
    @FXML
    private Button createButton;

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Room> rooms = RoomDAO.build().findAll();
        ComboBoxRoom.setItems(FXCollections.observableList(rooms));
    }
    @FXML
    private void createReserve() throws Exception {
        Reserve2 reserve = new Reserve2();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Reserva creada con exito");
        reserve.setDate(Date.valueOf(fieldDate.getText()));
        reserve.setRoom(RoomDAO.build().findByCodRoom(ComboBoxRoom.getSelectionModel().getSelectedItem().getCodRoom()));
        List<Client> clients = new ArrayList<>();
        clients.add((Client)Session.getInstance().getUserLogged());
        reserve.setClients(clients);
        ReserveDAO.build().saveClientReserve(reserve);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.CLIENTMENUOPTIONS, null);
    }
}
