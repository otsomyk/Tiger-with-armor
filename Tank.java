package tank;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Tank {
	private int speed = 10;

	// current position on BF
	private int X;
	private int Y;
	private Direction direction;
	private Bullet bullet;

	private ActionField af;
	private BattleField bf;
	private TankColor color;
	private int crew;
	private int maxSpeed;
	private boolean COLORDED_MODE = false;

	public TankColor getColor() {
		return color;
	}

	public int getCrew() {
		return crew;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public Tank(ActionField af, BattleField bf) {
		this(af, bf, 128, 250, Direction.UP);
	}

	public Tank(ActionField af, BattleField bf, int x, int y,
			Direction direction) {
		this.af = af;
		this.bf = bf;
		this.X = x;
		this.Y = y;
		this.direction = direction;
	}

	public Tank(TankColor color, int maxSpeed, int crew) {
		this.color = color;
		this.crew = crew;
		this.maxSpeed = maxSpeed;
	}

	public void turn(Direction direction) throws Exception {
		this.direction = direction;
		af.processTurn(this);
	}

	public void move() throws Exception {
		af.processMove(this);
	}

	public void destroy() {
		X = -100;
		Y = -100;
	}

	public void fire() throws Exception {
		Bullet bullet = new Bullet(X + 25, Y + 25, getDirection());
		af.processFire(bullet);
	}
	
	public void moveRandom() throws Exception {
		int rnd = (int) (System.currentTimeMillis() / 100) % 5;
		while (true) {
			if (rnd == 1) {
				turn(Direction.UP);
				move();
			} else if (rnd == 2) {
				turn(Direction.DOWN);
				move();
			} else if (rnd == 3) {
				turn(Direction.LEFT);
				move();
			} else {
				turn(Direction.RIGHT);
				move();

				Thread.sleep(speed);
				
				
			}
		}
	}

	public void updateX(int x) {
		this.X += x;
	}

	public void updateY(int y) {
		this.Y += y;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getSpeed() {
		return speed;
	}

}