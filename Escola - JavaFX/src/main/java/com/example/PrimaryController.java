package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField txtNome;
    @FXML TextField txtTurma;
    @FXML TextField txtRm;
    @FXML ListView<Aluno> lista;
    @FXML RadioButton optOrdenarPorNome;
    @FXML RadioButton optOrdenarPorTurma;
    
    //String[] alunos;  -> Array primitivo

    ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(){
        var aluno = new Aluno(
            txtNome.getText(),
            txtTurma.getText(),
            Integer.valueOf(txtRm.getText())
        );
        alunos.add(aluno);
        txtNome.clear();
        txtTurma.clear();
        txtRm.clear();
        atualizarTela();
    }

    public void atualizarTela(){
        ordenar();
        lista.getItems().clear();

        for(var aluno: alunos){
            lista.getItems().add(aluno);
        }
    }

    private void ordenar(){
        if(optOrdenarPorNome.isSelected()){
            alunos.sort((o1, o2) -> o1.nome().compareToIgnoreCase(o2.nome()));
        }

        if(optOrdenarPorTurma.isSelected()){
            alunos.sort((o1, o2) -> o1.turma().compareToIgnoreCase(o2.turma()));
        }
        
        //função anônima -> arrow function(js) -> lambda expression (java)
    }

    public void apagar(){
       

        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText("Confirmação");
        alerta.setContentText("Deseja deletar este aluno? Essa operação não poderá ser desfeita.");
        var resposta = alerta.showAndWait();

        if (resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
             var aluno = lista.getSelectionModel().getSelectedItem();
            alunos.remove(aluno);
            atualizarTela();
        }
    }

}


//inner class

