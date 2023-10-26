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
	
	List<Livro> livros = new ArrayList<>();
	
	public List<Livro> findAll() throws SQLException{
		var lista = new ArrayList<Livro>();
		var comando = conexao.prepareStatement("SELECT * FROM livros");
		var resultado = comando.executeQuery();
		
		while(resultado.next()) {
			lista.add(new Livro(
					resultado.getLong("id"),
					resultado.getString("titulo"),
					resultado.getString("autor"),
					resultado.getString("sinopse"),
					resultado.getString("capa"),
					resultado.getDouble("nota"),
					resultado.getString("status")	
					));
		}
		
		return lista;
	}
	
	public Livro findById(Long id) throws SQLException{
		
		var comando = conexao.prepareStatement("SELECT * FROM livros WHERE ID=?");
		comando.setLong(1, id);
		var resultado = comando.executeQuery();
		
		if (resultado != null && resultado.next()) {
			return new Livro(
					resultado.getLong("id"),
		            resultado.getString("titulo"),
		            resultado.getString("autor"),
		            resultado.getString("sinopse"),
		            resultado.getString("capa"),
		            resultado.getDouble("nota"),
		            resultado.getString("status")
					);
		} else {
			return null;
		}
		
	}
	
	public void deleteById(Long id) throws SQLException{
		var comando = conexao.prepareStatement("DELETE FROM livros WHERE ID=?");
		comando.setLong(1, id);
		comando.executeUpdate();
		
	}
	
	public void save(Livro livro) throws SQLException{
		
		var comando = conexao.prepareStatement("INSERT INTO livros (titulo, autor, sinopse, capa, nota, status) VALUES (?, ?, ?, ?, ?, ?)");
	    comando.setString(1, livro.titulo());
	    comando.setString(2, livro.autor());
	    comando.setString(3, livro.sinopse());
	    comando.setString(4, livro.capa());
	    comando.setDouble(5, livro.nota());
	    comando.setString(6, livro.status());

	    comando.executeUpdate();
	}
	
	public void update(Livro livro) throws SQLException{
		var comando = conexao.prepareStatement("UPDATE livros SET titulo=?, autor=?, sinopse=?, capa=?, nota=?, status=? WHERE id=?");
		comando.setString(1, livro.titulo());
	    comando.setString(2, livro.autor());
	    comando.setString(3, livro.sinopse());
	    comando.setString(4, livro.capa());
	    comando.setDouble(5, livro.nota());
	    comando.setString(6, livro.status());
	    comando.setLong(7, livro.id());

	    comando.executeUpdate();
	}
	
}
