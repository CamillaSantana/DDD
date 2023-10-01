package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Contato;
import com.example.model.Grupo;

public class ContatoDao {

    private Connection conexao;

    public ContatoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void inserirContato(Contato contato) throws SQLException {

        var sql = "INSERT INTO contato (nome, numero, email, grupo_id) VALUES (?, ?, ?, ?)";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, contato.getNome());
        comando.setString(2, contato.getNumero());
        comando.setString(3, contato.getEmail());
        comando.setInt(4, contato.getGrupo().getId());
        comando.executeUpdate();

    }

    public void apagar(Integer id) throws SQLException{
        buscarTodos();
        var comando = conexao.prepareStatement("DELETE FROM contato WHERE id=?");
        comando.setInt(1, id);
        comando.executeUpdate();
    }

    public void atualizar (Contato contato) throws SQLException{
        var comando = conexao.prepareStatement("UPDATE contato SET nome =?, numero=?, email=? WHERE id=?");
        comando.setString(1, contato.getNome());
        comando.setString(2, contato.getNumero());
        comando.setString(3, contato.getEmail());
        comando.setInt(4, contato.getId()) ;
        comando.executeUpdate();
    }

    public List<Contato> buscarTodos() throws SQLException{
        var lista = new ArrayList<Contato>();
        var comando = conexao.prepareStatement("SELECT contato.*, grupo.nome_grupo FROM contato INNER JOIN grupo ON contato.grupo_id = grupo.id");
        var resultado = comando.executeQuery();

        
        while(resultado.next()){
            lista.add(new Contato(
                resultado.getInt("id"),
                resultado.getString("nome"),
                resultado.getString("numero"),
                resultado.getString("email"),
                new Grupo(
                    resultado.getInt("grupo_id"),
                    resultado.getString("nome_grupo")
            )
            ));
        }
        return lista;
    }

    
}

