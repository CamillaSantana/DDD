package br.com.fiap.pacman;

public class Player extends GameObject {
	
	private int direction;
	private int life = 5;
	private boolean invincible;
	
	public Player() {
		
	}
	
	public Player(int x, int y, int direction) {
		super(x, y);
		setDirection(direction);
	}
	
	public void mover() {
		if (direction == 0) setY(getY() - 10);
		if (direction == 90) setX(getX() + 10);
		if (direction == 180) setY(getY() + 10);
		if (direction == 270) setX(getX() - 10);
	}

	public int getDirection() {
		return direction;
	}
	
	public int getLife() {
		return life;
	}

	public boolean isInvincible() {
		return invincible;
	}
	
	public void setDirection(int direction) {
		if (direction == 0 || direction == 90 || direction == 180 || direction == 270)
			this.direction = direction;
	}

	public void setLife(int life) {
		if (life >= 0) this.life = life;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public boolean colide(GameObject object) { //polimorfismo
		return getX() == object.getX() && getY() == object.getY();
	}

	public void perdeVida() {
		if (!isInvincible())
			setLife(getLife() - 1 );
	}
	

}