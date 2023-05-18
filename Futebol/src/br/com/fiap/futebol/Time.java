package br.com.fiap.futebol;

public class Time {

	private String nome;
	
	public Time(String nome) {
		this.nome = nome;
	}
	
	Goleiro goleiro = new Goleiro("Rogerio Ceni", 1, 2.00);
	Atacante atacante1 = new Atacante("Bruninho", 10, 1.60);
	Atacante atacante2 = new Atacante("Guilherme", 15, 1.70);
	Atacante atacante3 = new Atacante("Denis", 5, 1.70);
	Atacante atacante4 = new Atacante("Breno", 54, 1.60);
	Atacante atacante5 = new Atacante("Leandro", 32, 1.40);
	Zagueiro zagueiro1 = new Zagueiro("Anthony", 12, 1.75);
	Zagueiro zagueiro2 = new Zagueiro("José", 11, 1.90);
	Zagueiro zagueiro3 = new Zagueiro("Gabriel", 4, 1.75);
	Zagueiro zagueiro4 = new Zagueiro("Raphinha", 8, 1.50);
	Zagueiro zagueiro5 = new Zagueiro("Lucas", 6, 1.76);
	
	public void jogar() {
		goleiro.agir();
		atacante1.agir();
		atacante2.agir();
		atacante3.agir();
		atacante4.agir();
		atacante5.agir();
		zagueiro1.agir();
		zagueiro2.agir();
		zagueiro3.agir();
		zagueiro4.agir();
		zagueiro5.agir();
	}
	
	
	
}
