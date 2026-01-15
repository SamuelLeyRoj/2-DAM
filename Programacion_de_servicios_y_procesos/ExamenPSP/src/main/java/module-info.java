module com.safa.practica1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;


    opens Controlador to javafx.fxml;
    opens Modelo to javafx.base;

}
