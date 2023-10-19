package service;

import java.util.List;

import br.com.fiap.livrosapi.data.LivroDao;
import br.com.fiap.livrosapi.model.Livro;

public class LivroService {
	
	private LivroDao dao = new LivroDao();

	public List<Livro> findAll() {
		return dao.findAll();
	}

	public Livro findById(Long id) {
		return dao.findById(id);
	}

}
