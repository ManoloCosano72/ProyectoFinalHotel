package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.session.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button enterButton;
    @FXML
    private TextField fieldMail;
    @FXML
    private TextField fieldPassword;
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
    private void returnButton(Scene scene) throws Exception {
        App.currentController.changeScene(Scenes.MAIN, null);
    }

    @FXML
    private void enterButton() throws Exception {
        Client client = new Client();
        client.setMail(fieldMail.getText());
        client.setPassword(fieldPassword.getText());
        ClientDAO.build().findByMail(client.getMail());
        Session.LogIn(client);
        App.currentController.changeScene(Scenes.ADMINMENUOPTIONS,null);


    }
}
