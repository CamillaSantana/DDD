package br.com.fiap.futebol;

public class Jogador {

	private String nome;
	private int camisa;
	private double altura;
	
	public Jogador(String nome, int camisa, double altura) {
		this.nome = nome;
		this.camisa = camisa;
		this.altura = altura;
	}
	
	public void agir() {
		
	}
	
	public String getNome() {
		return nome;
	}
}
