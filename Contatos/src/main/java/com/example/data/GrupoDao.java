package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Grupo;

public class GrupoDao {

    private Connection conexao;

    public GrupoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void inserirGrupo(Grupo grupoNovo) throws SQLException {
        var sql = "INSERT INTO grupo (nome_grupo) VALUES (?)";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, grupoNovo.getNome());
        comando.executeUpdate();
    }

    public void apagar(Integer id) throws SQLException {
        buscarTodos();
        var comando = conexao.prepareStatement("DELETE FROM grupo WHERE id=?");
        comando.setInt(1, id);
        comando.executeUpdate();
    }

    public void atualizar (Grupo grupo) throws SQLException {
        var comando = conexao.prepareStatement("UPDATE grupo SET nome_grupo =? WHERE id=?");
        comando.setString(1, grupo.getNome());
        comando.setInt(2, grupo.getId());
        comando.executeUpdate();
    }

    public List<Grupo> buscarTodos() throws SQLException {
        var lista = new ArrayList<Grupo>();

        var comando = conexao.prepareStatement("SELECT * FROM grupo");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add(new Grupo(
                resultado.getInt("id"),
                resultado.getString("nome_grupo")
            )
            );
        }

        return lista;
    }

    

}
