package br.com.fiap.pacman;

public class Booster extends Item{

	private int duration;

	public Booster() {
	}

	public Booster(int x, int y, int duration) {
		super(x, y);
		setDuration(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration > 0) this.duration = duration;
	}
}
