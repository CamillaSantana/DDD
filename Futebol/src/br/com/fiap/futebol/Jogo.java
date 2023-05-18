package br.com.fiap.futebol;

public class Jogo {

	public static void main(String[] args) {
		
		Time time1 = new Time("São Paulo");
		Time time2 = new Time("Corinthians");
		
		time1.jogar();
		time2.jogar();
	}
}
