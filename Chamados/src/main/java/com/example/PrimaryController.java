package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField txtUser;
    @FXML TextField txtCodigo;
    @FXML RadioButton rbComputador;
    @FXML RadioButton rbImpressora;
    @FXML RadioButton rbRede;
    @FXML CheckBox ckPrimeiroContato;
    @FXML CheckBox ckAtendido;
    @FXML CheckBox ckEncerrado;
    @FXML ListView<Chamado> listaChamados;

    ArrayList <Chamado> chamados = new ArrayList<>();

    public void adicionarChamado(){

        var chamado = new Chamado(
            txtUser.getText(),
            txtCodigo.getText(),
            (rbComputador.isSelected()?"Computador":
            rbImpressora.isSelected()?"Impressora":
            rbRede.isSelected()?"Rede":"Nenhum"),
            (ckPrimeiroContato.isSelected()?"Primeiro contato":
            ckAtendido.isSelected()?"Atendido":
            ckEncerrado.isSelected()?"Encerrado":"Nenhum")
        );

        chamados.add(chamado);

        txtUser.clear();
        txtCodigo.clear();
        rbComputador.setSelected(false);
        rbImpressora.setSelected(false);
        rbRede.setSelected(false);
        ckPrimeiroContato.setSelected(false);
        ckAtendido.setSelected(false);
        ckEncerrado.setSelected(false);

        atualizarTela();
    }
    

    public void atualizarTela(){
        listaChamados.getItems().clear();

        for(var chamado: chamados){
            listaChamados.getItems().add(chamado);
        }
    }

    public void editarChamado(){
        //clicar no chamado, clicar em editar, e os campos do chamado aparecem no formulário para que sejam alterados?
    }

    public void apagarChamado(){
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText("Confirmação");
        alerta.setContentText("Deseja deletar este chamado? Essa operação não poderá ser desfeita.");
        var resposta = alerta.showAndWait();

        if (resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
            var aluno = listaChamados.getSelectionModel().getSelectedItem();
            chamados.remove(aluno);
            atualizarTela();
        }
    }

}