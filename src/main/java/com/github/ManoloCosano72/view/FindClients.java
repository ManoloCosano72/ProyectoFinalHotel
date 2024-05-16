package com.github.ManoloCosano72.view;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class FindClients extends Controller implements Initializable {
    @Override
    public void onOpen(Object input) throws Exception {
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //@FXML
    //public void findAllClients() throws Exception {
    //    Client client = new Client();
    //    client.setDni(fieldName.getText());
    //    client.setSurnames(fieldSurnames.getText());
    //    client.setPhone(fieldPhone.getText());
    //    client.setMail(fieldMail.getText());
    //    client.setPassword(fieldPassword.getText());
    //    ClientDAO.build().findAll(client);
    //    App.currentController.changeScene(Scenes.ADMINMENUOPTIONS, null);
    //}
}
