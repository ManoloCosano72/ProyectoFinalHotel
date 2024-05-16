package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import static com.github.ManoloCosano72.model.dao.ClientDAO.build;

public class RegistrerController extends Controller implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField fieldDni;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldSurnames;
    @FXML
    private TextField fieldPhone;
    @FXML
    private TextField fieldMail;
    @FXML
    private TextField fieldPassword;
    @FXML
    private TextField fieldAdmin;
    @FXML
    private Button registrerButton;
    @FXML
    private ImageView returnButton;


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
    private void returnButton() throws Exception {
        App.currentController.changeScene(Scenes.MAIN, null);
    }

    @FXML
    public void registerClient() throws Exception {
        Client client = new Client();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Registrado con exito");
        client.setDni(fieldDni.getText());
        client.setName(fieldName.getText());
        client.setSurnames(fieldSurnames.getText());
        client.setPhone(fieldPhone.getText());
        client.setMail(fieldMail.getText());
        client.setPassword(fieldPassword.getText());
        client.setAdmin(Integer.parseInt(fieldAdmin.getText()));
        ClientDAO.build().save(client);
        alert.showAndWait();
        App.currentController.changeScene(Scenes.MAIN,null);
    }
}
