module com.safa.practica1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.safa.practica1.Controlador to javafx.fxml;
    opens com.safa.practica1.Modelo to javafx.base;

}
