package br.com.fiap.livrosapi.model;

public record Livro(
		Long id,
		String titulo,
		String autor,
		String sinopse,
		String capa,
		Double nota,
		String status
		
) {}
