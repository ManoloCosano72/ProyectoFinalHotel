package com.github.ManoloCosano72.view;

public enum Scenes {
    ROOT("view/layout.fxml"),
    MAIN("view/main.fxml"),
    REGISTRER("view/registrer.fxml"),
    LOGIN("view/login.fxml"),
    CLIENTMENUOPTIONS("view/clientMenuOptions.fxml"),
    ADMINMENUOPTIONS("view/adminMenuOptions.fxml"),
    CREATEROOMS("view/createRooms.fxml"),
    DELETECLIENTS("view/deleteClients.fxml"),

    //FINDCLIENTSBYDNI("view/findClientsByDni.fxml"),

    //FINDCLIENTSBYNAME("view/findClientsByName.fxml"),
    UPDATEDATAFROMCLIENT("view/updateDataFromClient.fxml"),
    UPDATEDATAFROMADMIN("view/updateDataFromAdmin.fxml"),
    FINDALLCLIENTS("view/findClients.fxml"),
    UPDATEROOMS("view/updateRoom.fxml"),
    FINDROOMBYCODE("view/findRoomByCode.fxml"),
    DELETEROOM("view/deleteRoom.fxml"),
    FINDALLROOMS("view/findAllRooms.fxml");

    private final String url;

    Scenes(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
