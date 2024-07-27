module porto.java.PortoJava {
    requires javafx.controls;
    requires javafx.fxml;

    opens porto.java.PortoJava to javafx.fxml;
    exports porto.java.PortoJava;
}