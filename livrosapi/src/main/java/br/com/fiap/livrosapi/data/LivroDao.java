package br.com.fiap.livrosapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livrosapi.model.Livro;

public class LivroDao {
	
	List <Livro> livros = new ArrayList<>();
	
	public LivroDao() {
		livros.add(
				new Livro(
						1L,
						"Trono de Vidro",
						"O primeiro livro de Trono de Vidro segue a assassina Celaena Sardothien enquanto ela é convocada para competir por sua liberdade em um torneio mortal.",
						"http://...",
						10.0,
						true
						)
				);
	}
	
	public List<Livro> findAll(){
		return livros;
	}
}
