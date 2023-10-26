package br.com.fiap.livrosapi;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.livrosapi.model.Livro;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
	public Response findById(@PathParam("id") Long id) throws SQLException {
		var livro = service.findById(id);
		
		if (livro == null) {
			return Response.status(404).build();
		}
		
		return Response.ok(livro).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		var livro = service.findById(id);
		
		if(livro == null) {
			return Response.status(404).build();
		}
		
		service.delete(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert (Livro livro) {
		if (service.save(livro)) {
			return Response.ok(livro).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	
	@PUT
	@Path("{id}")
	public Response update (@PathParam ("id") Long id, Livro livro) {
		var livroEncontrado = service.findById(id);
		
		if(livroEncontrado == null) {
    		return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		if (!service.update(livro))
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	
    	return Response.ok(livro).build();
    	
	}

}
