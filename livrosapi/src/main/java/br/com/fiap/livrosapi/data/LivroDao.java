package br.com.fiap.livrosapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livrosapi.model.Livro;

public class LivroDao {
	
	List<Livro> livros = new ArrayList<>();
	
	public LivroDao() {
		livros = List.of(
				new Livro(1L, "Trono de Vidro", "Sarah J. Maas", "O primeiro livro de Trono de Vidro segue a assassina Celaena Sardothien enquanto ela é convocada para competir por sua liberdade em um torneio mortal.", "http://...", 10.0, true),
				new Livro(2L, "A Revolução dos Bichos", "George Orwell", "Uma sátira política de George Orwell que narra a revolta dos animais de uma fazenda contra seus opressores humanos.", "http://...", 9.0, true),
				new Livro(3L, "Cem Anos de Solidão", "Gabriel García Márquez", "A obra-prima de Gabriel García Márquez que conta a história da família Buendía ao longo de sete gerações em Macondo.", "http://...", 9.3, true)
				);
	}
	
	public List<Livro> findAll(){
		return livros;
	}
	
	public Livro findById(Long id) {
		//SELECT * FROM LIVROS WHERE ID=?
		return livros
				.stream()
				.filter(livro -> livro.id() == id)
				.findFirst()
				.orElse(null);
	}
}
