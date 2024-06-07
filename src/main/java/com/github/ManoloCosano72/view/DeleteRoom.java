package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteRoom extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldCodRoom;
    @FXML
    private Button deleteButton;
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
    public void deleteRoom() throws Exception {
        Room room = new Room();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Habitacion borrada con exito");
        room.setCodRoom(fieldCodRoom.getText());
        RoomDAO.build().delete(room);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.ADMINMENUOPTIONS,null);
    }
}
