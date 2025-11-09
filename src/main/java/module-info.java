module com.example.trafficgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.trafficgame to javafx.fxml;
    exports com.example.trafficgame;
}