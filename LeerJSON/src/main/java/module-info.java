module com.example.leerjson {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.leerjson to javafx.fxml;
    exports com.example.leerjson;
    exports com.example.leerjson.Controller;
    opens com.example.leerjson.Controller to javafx.fxml;
    opens com.example.leerjson.Model to com.fasterxml.jackson.databind;
}