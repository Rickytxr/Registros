module com.example.registros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.registros to javafx.fxml;
    exports com.example.registros;
}