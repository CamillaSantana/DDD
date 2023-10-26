package br.com.fiap.livrosapi.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livrosapi.model.Livro;

public class LivroDao {
	
	private Connection conexao;

    public LivroDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
	
	public List<Livro> findAll() throws SQLException{
		var lista = new ArrayList<Livro>();
		
		var comando = conexao.prepareStatement("SELECT * FROM livros");
		var resultado = comando.executeQuery();
		
		while (resultado.next()) {
	        long id = resultado.getLong("id");
	        String titulo = resultado.getString("titulo");
	        String autor = resultado.getString("autor");
	        String sinopse = resultado.getString("sinopse");
	        String capa = resultado.getString("capa");
	        double nota = resultado.getInt("nota");
	        int valorLido = resultado.getInt("lido");

	        boolean lido = (valorLido == 0);

	        lista.add(new Livro(id, titulo, autor, sinopse, capa, nota, lido));
	    }
		
		return lista;
	}
		
	public Livro findById(Long id) throws SQLException {
		
		var comando = conexao.prepareStatement("SELECT * FROM livros WHERE ID=?");
		comando.setLong(1, id);
		var resultado = comando.executeQuery();
		
		long idLivro = resultado.getLong("id");
        String titulo = resultado.getString("titulo");
        String autor = resultado.getString("autor");
        String sinopse = resultado.getString("sinopse");
        String capa = resultado.getString("capa");
        double nota = resultado.getInt("nota");
        int valorLido = resultado.getInt("lido");

        boolean lido = (valorLido == 0);
        
        var livro = new Livro(idLivro, titulo, autor, sinopse, capa, nota, lido);
        
        return livro;
	}
}
