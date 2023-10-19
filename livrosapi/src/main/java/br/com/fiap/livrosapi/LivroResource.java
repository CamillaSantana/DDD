package br.com.fiap.livrosapi;

import java.util.List;

import br.com.fiap.livrosapi.model.Livro;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.LivroService;

@Path ("livro")
public class LivroResource {
	
		private LivroService service = new LivroService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livro> listAll() {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		var livro = service.findById(id);
		
		if (livro == null) {
			return Response.status(404).build();
		}
		
		return Response.ok(livro).build();
	}
}
