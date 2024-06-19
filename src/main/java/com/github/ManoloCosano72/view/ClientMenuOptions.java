package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.session.Session;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ClientMenuOptions extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button deleteReserves;
    @FXML
    private Button findAllReserves;
    @FXML
    private Button updateData;
    @FXML
    private Button createReserve;
    @FXML
    private TableView<Reserve> tableViewReserve;
    @FXML
    private TableColumn<Reserve, String> columnCodReserve;
    @FXML
    private TableColumn<Reserve, Date> columnDate;
    @FXML
    private TableColumn<Reserve, String> columnCodRoom;
    @FXML
    private ImageView closeSession;
    private ObservableList<Reserve> reserves;


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
    private void goToDeleteReserves() throws Exception {
        App.currentController.openModal(Scenes.DELETERESERVESFROMCLIENT, "Borrar reservas de la lista", this, null);
    }

    @FXML
    private void goToUpdateDataFromClient() throws Exception {
        App.currentController.openModal(Scenes.UPDATEDATAFROMCLIENT, "Actualizar datos ", this, null);
    }

    @FXML
    private void goToCreateReserve() throws Exception {
        App.currentController.openModal(Scenes.CREATERESERVE, "Crear reservas", this, null);
    }



    @FXML
    private void findAllReserves() {

    }
    @FXML
    private void logOut(){
        Session.LogOut();
        System.exit(0);
    }
}
