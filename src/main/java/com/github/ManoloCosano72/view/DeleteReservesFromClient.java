package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.entity.Reserve2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteReservesFromClient extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldCodReserve;
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
    private void deleteReserve() throws Exception {
        Reserve2 reserve = new Reserve2();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Reserva borrada con exito");
        reserve.setCodReserve(Integer.parseInt(fieldCodReserve.getText()));
        ReserveDAO.build().deleteReserveFromList(reserve);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.CLIENTMENUOPTIONS,null);
    }
}
