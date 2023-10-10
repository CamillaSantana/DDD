package br.com.fiap.livrosapi.service;

import java.util.List;

import br.com.fiap.livrosapi.data.LivroDao;
import br.com.fiap.livrosapi.model.Livro;

public class LivroService {
	
	LivroDao dao = new LivroDao();

	public List<Livro> findAll() {
		return dao.findAll();
	}

}
