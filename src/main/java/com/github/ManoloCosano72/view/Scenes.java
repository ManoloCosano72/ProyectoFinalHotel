package com.github.ManoloCosano72.view;

public enum Scenes {
    ROOT("view/layout.fxml"),
    MAIN("view/main.fxml"),
    REGISTRER("view/registrer.fxml"),
    LOGIN("view/login.fxml"),

    ADMINMENUOPTIONS("view/adminMenuOptions.fxml"),
    CREATEROOMS("view/createRooms.fxml"),
    DELETECLIENTS("view/deleteClients.fxml"),
    UPDATEDATAFROMADMIN("view/updateDataFromAdmin.fxml"),
    FINDALLCLIENTS("view/findClients.fxml"),
    UPDATEROOMS("view/updateRoom.fxml"),
    DELETEROOM("view/deleteRoom.fxml"),
    FINDALLROOMS("view/findAllRooms.fxml"),
    CLIENTMENUOPTIONS("view/clientMenuOptions.fxml"),
    DELETERESERVESFROMCLIENT("view/deleteReservesFromClient.fxml"),
    FINDALLRESERVESFROMCLIENT("view/findAllReservesFromClient.fxml"),
    UPDATERESERVE("view/updateReserveFromclient.fxml"),
    UPDATEDATAFROMCLIENT("view/updateDataFromClient.fxml"),
    CREATERESERVE("view/createReserveFromClient.fxml");

    private final String url;

    Scenes(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
