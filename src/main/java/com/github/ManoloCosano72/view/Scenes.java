package com.github.ManoloCosano72.view;

public enum Scenes {
    MAIN("view/main.fxml");
    private String url;
    Scenes(String url){
        this.url=url;
    }
    public String getURL(){
        return url;
    }
}
