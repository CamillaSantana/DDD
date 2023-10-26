package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.livrosapi.data.LivroDao;
import br.com.fiap.livrosapi.model.Livro;

public class LivroService {
	
	private LivroDao livroDao;

	public List<Livro> findAll(){
		try {
			livroDao = new LivroDao();
			return livroDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
	        return new ArrayList<>();
		}
	}
	
	public Livro findById(Long id){        
        try {
			livroDao = new LivroDao();
			return livroDao.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public void delete(Long id) {
		if (findById(id) != null) {
			try {
				livroDao = new LivroDao();
				livroDao.deleteById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean save(Livro livro) {
		
		try {
			livroDao = new LivroDao();
			livroDao.save(livro);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(Livro livro) {
		try {
			livroDao = new LivroDao();
			livroDao.update(livro);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
