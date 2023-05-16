package br.com.fiap.formigueiro;

public class Formiga {
	
	private int velocidade;
	private int posicaoX;
	private int posicaoY;
	private boolean carregandoComida;
	private int feromonios;
	private int casaX;
	private int casaY;
	private int alimentoX;
	private int alimentoY;
	
	public Formiga(int x, int y) {
		this.posicaoX = x;
		this.posicaoY = y;
	}
	
	public void buscarComida() {
		andar();
		verificarComida();
	}
	
	private void verificarComida() {
		if(posicaoX == alimentoX && posicaoY == alimentoY) {
			pegarComida();
		}
	}
	
	private void pegarComida() {
		carregandoComida = true;
	}
	
	private void largarComida() {
		carregandoComida = false;
	}
	
	private void andar() {
		int sorteio = (int) (Math.random()*4);
		if(sorteio == 0) posicaoX += velocidade;
		if(sorteio == 1) posicaoX -= velocidade;
		if(sorteio == 2) posicaoY -= velocidade;
		if(sorteio == 3) posicaoY += velocidade;
	}
	
	private void verificarSeEstaEmCasa() {
		if(estaEmCasa()) largarComida();
	}
	
	private boolean estaEmCasa() {
		return posicaoX == casaX && posicaoY == casaY;
	}
	
	public void agir() {
		if(carregandoComida) {
			System.out.println("Indo para casa!");
			return;
		}
		
		buscarComida();
		
	}
	
	
	
	
}
	
