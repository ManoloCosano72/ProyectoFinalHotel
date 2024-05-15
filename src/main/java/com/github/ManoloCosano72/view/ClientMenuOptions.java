package com.github.ManoloCosano72.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuOptions extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button findReservesByCode;
    @FXML
    private Button deleteReserves;
    @FXML
    private Button findAllReserves;
    @FXML
    private Button updateReserve;
    @FXML
    private Button updateData;
    @FXML
    private Button createReserve;
    @FXML
    private ImageView closeSession;


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
