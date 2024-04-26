package com.github.ManoloCosano72.view;

import com.github.ManoloCosano72.App;

import java.io.IOException;

public abstract class Controller {
    App app;
    public void setApp(App app){
        this.app=app;
    }

    public abstract void onOpen(Object input) throws IOException;
    public abstract void onClose(Object output);
}
