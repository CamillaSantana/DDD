package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML TextField txtNumero1;
    @FXML TextField txtNumero2;
    @FXML Label lblResultado;

    public void somar(){
        var numero1 = Integer.parseInt(txtNumero1.getText());
        var numero2 = Integer.parseInt(txtNumero2.getText());

        var soma = numero1 + numero2;

        lblResultado.setText(String.valueOf(soma));
        
    }
}
