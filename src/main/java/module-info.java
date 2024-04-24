module com.github.ManoloCosano72 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;

    opens com.github.ManoloCosano72 to javafx.fxml;
    opens com.github.ManoloCosano72.model.connection to java.xml.bind;

    exports com.github.ManoloCosano72;
    exports com.github.ManoloCosano72.utils;
    opens com.github.ManoloCosano72.utils to javafx.fxml;
}
