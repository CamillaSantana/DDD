package br.com.fiap.pacman;

public class Ghost extends GameObject{

	private int direction;
	
	public Ghost() {

	}

	public Ghost(int x, int y, int direction) {
		super(x, y);
		setDirection(direction);
	}

	public void mover() {
		mudarDirecao();
		if (direction == 0) setY(getY() - 10);
		if (direction == 90) setX(getX() + 10);
		if (direction == 180) setY(getY() + 10);
		if (direction == 270) setX(getX() - 10);
	}
	
	private void mudarDirecao() {
		int sorteio = (int) (Math.random()	* 4); //0 1 2 3
		setDirection(sorteio * 90);
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		if (direction == 0 || direction == 90 || direction == 180 || direction == 270)
			this.direction = direction;
	}
}
