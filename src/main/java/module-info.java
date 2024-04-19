module com.github.ManoloCosano72 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.ManoloCosano72 to javafx.fxml;
    exports com.github.ManoloCosano72;
}
