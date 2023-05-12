
public class Jogo {

	public static void main(String[] args) {
		
		Jogador jogador1 = new Jogador();
		Jogador jogador2 = new Jogador();
		
		System.out.println("""
				JOGADOR 1
				
				Nome: %s
				XP: %d
				HP: %d
				Envenenado: %b
				""".formatted(jogador1.getNome(),jogador1.getXp(),jogador1.getHp(),jogador1.isEnvenenado()));
		
		
		jogador1.ganharExperiencia(50);
		jogador2.ganharExperiencia(100);
		jogador1.atacar(jogador2);

		System.out.println("""
				JOGADOR 1
				
				Nome: %s
				XP: %d
				HP: %d
				Envenenado: %b
				""".formatted(jogador1.getNome(),jogador1.getXp(),jogador1.getHp(),jogador1.isEnvenenado()));
		
		
	}
	
	
}
