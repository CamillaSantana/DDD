package br.com.fiap.futebol;

public class Atacante extends Jogador{

	private int golsMarcados;
	
	public Atacante(String nome, int camisa, double altura) {
		super(nome, camisa, altura);
	}

	@Override
	public void agir() {
		System.out.println("Atacante %s está chutando".formatted(this.getNome()));
	}
	
	
}
