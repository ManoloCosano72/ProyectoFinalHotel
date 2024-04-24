package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.connection.ConnectionProperties;
import com.github.ManoloCosano72.utils.XMLManager;

public class saveConnection {
    public static void main(String[] args) {
        ConnectionProperties c = new ConnectionProperties("localhost","3306","hotel","root","root");
        XMLManager.writeXML(c,"connection.xml");
    }
}
