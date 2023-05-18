package br.com.fiap.pacman;

public class GameObject {

	private int x;
	private int y;
	private int screenSize = 500;
	
	public GameObject() {
		
	}
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	public void setX(int x) {
		if (x >= 0 && x <= screenSize) this.x = x;						
	}
	
	public void setY(int y) {
		if (y >= 0 && y <= screenSize) this.y = y;
	}
	
	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	
	
}
