package Controlador;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class PrincipalController {

    @FXML
    private Button Btn;

    @FXML
    private Line Linea1;

    @FXML
    private Line Linea2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    void BtnAc(ActionEvent event) {


        label1.setText("Coordenada1");
        label2.setText("Coordenada2");
        label3.setText("Coordenada3");
        label4.setText("Coordenada4");


    }

}

