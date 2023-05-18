package br.com.fiap.loja;

public class Livros extends Produto{

	private String autor;
	private String meuTipo = "Livro";

	public Livros(String nome, double preco, int quantidade, String autor) {
		super(nome, preco, quantidade);
		setTipo(meuTipo);
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + autor;
	}

	@Override
	public double getPrecoMinimo() {
		return super.getPrecoMinimo() * 0.8;
	}
	
}
