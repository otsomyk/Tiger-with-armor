package tank;

public class Tiger extends Tank {
	private int armor;

	public Tiger(ActionField af, BattleField bf) {
		super(af, bf);
	}

	public Tiger(ActionField af, BattleField bf, int X, int Y,
			Direction direction) {
		super(af, bf, X, Y, direction);
		armor = 1;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}
