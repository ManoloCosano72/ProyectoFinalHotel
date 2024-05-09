package com.github.ManoloCosano72.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {
    @FXML
    private ImageView logotype;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonRegistrer;
    @FXML
    private Button exit;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
