package br.com.fiap.futebol;

public class Goleiro extends Jogador {

	private int defesasRealizadas;
	
	public Goleiro(String nome, int camisa, double altura) {
		super(nome, camisa, altura);
	}

	@Override
	public void agir() {
		System.out.println("Goleiro %s está defendendo".formatted(this.getNome()));
	}
	
}
