package service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.livrosapi.data.LivroDao;
import br.com.fiap.livrosapi.model.Livro;

public class LivroService {

	private LivroDao dao;

    public LivroService() throws SQLException {
        dao = new LivroDao();
    }

    public List<Livro> findAll() throws SQLException {
        return dao.findAll();
    }

    public Livro findById(Long id) throws SQLException {
        return dao.findById(id);
    }

}
