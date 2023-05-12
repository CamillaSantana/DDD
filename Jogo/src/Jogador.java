
public class Jogador {

	private String nome;
	private int xp;
	private int hp;
	private boolean envenenado;
	
	public Jogador(){
		
	}
	
	public Jogador(String nome) {
		System.out.println("Criando jogador " + nome);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getXp() {
		return xp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean isEnvenenado() {
		return envenenado;
	}
	
	public void receberDano(int pontos) {
		this.hp -= pontos;
		if (hp >= 0) {
			System.out.println("Game Over! Jogador " + nome);
			this.hp = 0;
		}
	}
	
	public void receberCura(int pontos) {
		this.hp += pontos;
	}
	
	public void ganharExperiencia(int pontos) {
		this.xp += pontos;
	}
	
	public void receberAntidoto() {
		if (envenenado == true) {
			envenenado = false;
		}else {
			envenenado = true;
		}
	}
	
	public void atacar(Jogador jogador) {
		jogador.receberDano(this.xp);
		
		if(jogador.getHp() >= 0) {
			this.ganharExperiencia(jogador.getXp());
		}
	}
}
