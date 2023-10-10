package br.com.fiap.livrosapi;

import java.util.List;

import br.com.fiap.livrosapi.model.Livro;
import br.com.fiap.livrosapi.service.LivroService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path ("livro")
public class LivroResource {
	
	LivroService service = new LivroService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livro> index() {
		return service.findAll();
	}
}
