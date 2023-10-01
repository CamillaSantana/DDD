package com.example;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.data.ContatoDao;
import com.example.data.GrupoDao;
import com.example.model.Contato;
import com.example.model.Grupo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class PrimaryController implements Initializable{

    //Atributos do contato
    @FXML TextField txtNomeContato;
    @FXML TextField txtNumeroContato;
    @FXML TextField txtEmailContato;

    @FXML TableView<Contato> tabelaContatos;

    @FXML TableColumn<Contato, String> colNomeContato;
    @FXML TableColumn<Contato, String> colNumeroContato;
    @FXML TableColumn<Contato, String> colEmailContato;
    @FXML TableColumn<Grupo, String> colGrupoContato;

    @FXML ComboBox<Grupo> cbGrupo;

    //Atributos do grupo
    @FXML TextField txtNomeGrupo;

    @FXML TableView<Grupo> tabelaGrupos;

    @FXML TableColumn<Grupo, String> colNomeGrupo;
    @FXML TableColumn<Grupo, Integer> colQuantidadeContatosGrupo;

    ContatoDao contatoDao;
    GrupoDao grupoDao;



    public void adicionarGrupo(){
        var grupoNovo = criarGrupo();
        try {
            grupoDao.inserirGrupo(grupoNovo);
            tabelaGrupos.getItems().add(grupoNovo);
            carregarGrupos();
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao inserir grupo");
        }
    }

    public void adicionarContato(){
        var contatoNovo = criarContato();
        try {
            contatoDao.inserirContato(contatoNovo);
            tabelaContatos.getItems().add(contatoNovo);
            carregarContatos();
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao inserir contato");
        }
    }

    public void apagarContato(){
        var contato = tabelaContatos.getSelectionModel().getSelectedItem(); 
        if (contato == null) mostrarMensagem("Erro", "Selecione um contato para apagar");
        try {
            contatoDao.apagar(contato.getId());
            tabelaContatos.getItems().remove(contato);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao apagar contato");
            e.printStackTrace();
        }
    }

    public void apagarGrupo(){
        var grupo = tabelaGrupos.getSelectionModel().getSelectedItem();
        if (grupo == null) mostrarMensagem("Erro", "Selecione um grupo para apagar");
        try {
            grupoDao.apagar(grupo.getId());
            tabelaGrupos.getItems().remove(grupo);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao apagar grupo");
        }
    }

    public void atualizarContato(Contato contato){
        try {
            contatoDao.atualizar(contato);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao atualizar os dados");
        }
    }

    public void atualizarGrupo(Grupo grupo){
        try {
            grupoDao.atualizar(grupo);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao atualizar os dados");
        }
    }

    private Contato criarContato() {
        return new Contato(
            null,
            txtNomeContato.getText(),
            txtNumeroContato.getText(),
            txtEmailContato.getText(),
            cbGrupo.getSelectionModel().getSelectedItem()
        );
    }

    public Grupo criarGrupo(){
        return new Grupo(
            null,
            txtNomeGrupo.getText()
        );
    }

    public void carregarGrupos(){
        tabelaGrupos.getItems().clear();
        try {
            txtNomeGrupo.clear();
            var grupos = grupoDao.buscarTodos();
            grupos.forEach(grupo -> tabelaGrupos.getItems().add(grupo));
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao carregar grupos");
        }
    }

    public void carregarContatos(){
        tabelaContatos.getItems().clear();
        try {
            limparCamposContato();
            var contatos = contatoDao.buscarTodos();
            contatos.forEach(contato -> tabelaContatos.getItems().add(contato));
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao carregar contatos");
        }
    }

    private void mostrarMensagem(String titulo, String mensagem){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    public void limparCamposContato(){
        txtNomeContato.clear();
        txtNumeroContato.clear();
        txtEmailContato.clear();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNomeContato.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNomeContato.setCellFactory(TextFieldTableCell.forTableColumn());
        colNomeContato.setOnEditCommit(c -> atualizarContato(c.getRowValue().nome(c.getNewValue())));

        colNumeroContato.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNumeroContato.setCellFactory(TextFieldTableCell.forTableColumn());
        colNumeroContato.setOnEditCommit(c -> atualizarContato(c.getRowValue().numero(c.getNewValue())));

        colEmailContato.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmailContato.setCellFactory(TextFieldTableCell.forTableColumn());
        colEmailContato.setOnEditCommit(c -> atualizarContato(c.getRowValue().email(c.getNewValue())));

        colGrupoContato.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        
        colNomeGrupo.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNomeGrupo.setCellFactory(TextFieldTableCell.forTableColumn());
        colNomeGrupo.setOnEditCommit(c -> atualizarGrupo(c.getRowValue().nome(c.getNewValue())));

        try {
            contatoDao = new ContatoDao();
            grupoDao = new GrupoDao();
            cbGrupo.getItems().addAll(grupoDao.buscarTodos());
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao buscar clientes");
            e.printStackTrace();
        }

        carregarContatos();
        carregarGrupos();

        tabelaContatos.setEditable(true);
        tabelaGrupos.setEditable(true);
    }

    
}