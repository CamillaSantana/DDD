package br.com.fiap.futebol;

public class Zagueiro extends Jogador{

	private int numeroChuteira;
	
	public Zagueiro(String nome, int camisa, double altura) {
		super(nome, camisa, altura);
	}

	@Override
	public void agir() {
		System.out.println("Zagueiro %s está marcando!".formatted(this.getNome()));
	}
	
}
