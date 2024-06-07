package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Reserve;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class UpdateReserveFromClient extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldDate;
    @FXML
    private TextField fieldCodRoom;
    @FXML
    private Button updateButton;

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
    public void updateReserve() throws Exception {
        Reserve reserve = new Reserve();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Consulta creada con exito");
        reserve.setDate(Date.valueOf(fieldDate.getText()));
        //reserve.setRoom(fieldCodRoom.getText());
        ReserveDAO.build().update(reserve);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.CLIENTMENUOPTIONS, null);
    }
}
