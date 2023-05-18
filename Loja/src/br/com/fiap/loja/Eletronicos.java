package br.com.fiap.loja;

public class Eletronicos extends Produto{

	private String marca;
	private String modelo;
	private String meuTipo = "Eletrônico";
	
	public Eletronicos(String nome, double preco, int quantidade, String marca, String modelo) {
		super(nome, preco, quantidade);
		setTipo(meuTipo);
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + marca + " " + modelo;
	}

	@Override
	public double getPrecoMinimo() {
		if(marca.equalsIgnoreCase("Apple")) 
			return super.getPrecoMinimo();
		
		return super.getPrecoMinimo() * 0.9;
	}
}
