package br.com.fiap.loja;
public class App {

	public static void main(String[] args) {
		Produto produto = new Produto("Produto", 10, 1);
		Livros livro = new Livros("DDD", 90.9, 15, "Eric Evans");
		Eletronicos eletronico = new Eletronicos("iPhone", 15_000, 3, "Apple", "14Pro");
		Vestuario vestuario = new Vestuario("Blusa", 35.0, 3, "M", "Azul");
		
		System.out.println(livro);
		System.out.println(eletronico);
		System.out.println(vestuario);
		
		System.out.println(livro.getPrecoMinimo());
		System.out.println(eletronico.getPrecoMinimo());
		System.out.println(vestuario.getPrecoMinimo());
	}
}
