package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ResourceBundle;

public class CreateReserveFromClient extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldCodReserve;
    @FXML
    private TextField fieldDate;
    @FXML
    private TextField fieldCodRoom;
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

    }
    @FXML
    public void createReserve() throws Exception {
        Reserve reserve = new Reserve();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Reserva creada con exito");
        reserve.setCodReserve(fieldCodReserve.getText());
        reserve.setDate(Date.valueOf(fieldDate.getText()));
        //reserve.setRoom(reserve.getRoom().getCodRoom(fieldCodRoom.getText()));
        ReserveDAO.build().save(reserve);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.CLIENTMENUOPTIONS, null);
    }
}
