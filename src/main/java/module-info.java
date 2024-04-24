module com.github.ManoloCosano72 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;

    exports com.github.ManoloCosano72;
    opens com.github.ManoloCosano72 to javafx.fxml;
}
