package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.Math;
import java.text.DecimalFormat;

public class PrimaryController {
    @FXML TextField txtValorInicial;
    @FXML TextField txtTaxaJuros;
    @FXML TextField txtTempo;
    @FXML Label lblResultado;

    public void calcular(){
        int valorInicial = Integer.parseInt(txtValorInicial.getText());
        int taxaJuros = Integer.parseInt(txtTaxaJuros.getText());
        int tempo = Integer.parseInt(txtTempo.getText());

        double montante = valorInicial * Math.pow((1 + (taxaJuros*0.01)), tempo);

        double jurosCompostos = montante - valorInicial;

        DecimalFormat formato = new DecimalFormat("#.##");
        String jurosFormatado = formato.format(jurosCompostos);

        lblResultado.setText("Juros: " + String.valueOf(jurosFormatado));
        
    }
}
