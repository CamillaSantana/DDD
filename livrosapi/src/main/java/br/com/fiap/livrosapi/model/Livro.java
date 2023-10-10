package br.com.fiap.livrosapi.model;

public record Livro(
		Long id,
		String titulo,
		String sinopse,
		String capa,
		Double nota,
		Boolean lido
		
) {

}
