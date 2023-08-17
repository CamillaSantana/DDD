package com.example;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField txtNome;
    @FXML TextArea txtAlunos;

    //String[] alunos;  -> Array primitivo

    ArrayList<String> alunos = new ArrayList<>();

    public void adicionarAluno(){
        alunos.add(txtNome.getText());
        txtNome.clear();
        atualizarTela();
    }

    public void atualizarTela(){
        ordenar();
        txtAlunos.clear();
        // for (int i = 0; i < alunos.size(); i++){
        //     txtAlunos.appendText(alunos.get(i) + "\n");
        // }

        for(var aluno: alunos){
            txtAlunos.appendText(aluno + "\n");

        }
    }

    private void ordenar(){
        //anonymous class
        alunos.sort((o1, o2) -> o1.compareToIgnoreCase(o2));
        //função anônima -> arrow function(js) -> lambda expression (java)
    }

}


//inner class

