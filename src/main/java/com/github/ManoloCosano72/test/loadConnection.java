package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.connection.ConnectionProperties;
import com.github.ManoloCosano72.utils.XMLManager;

public class loadConnection {
    public static void main(String[] args) {
        ConnectionProperties c = XMLManager.readXML (new ConnectionProperties(),"connection.xml");
        XMLManager.readXML(c,"connection.xml");
    }
}
