package player;

import entity.Entity;
import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import unit.Unit;

public class Player extends Entity {
	/* FIELD */
	private int money;
	private long towerSpawnTime;

	/* CONSTRUCTOR */
	public Player(Team team) {
		super(team);
		setHp(2000);
		setMaxHp(2000);
		setMoney(150);
		setHitting(false);
		setTowerSpawnTime(GameLogic.getCurrentTime());
		setZ(1000);
		if (getTeam().equals(Team.Player)) {
			setX(35);
			setY(530);
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1325);
			setY(530);
		}
	}

	/* METHOD */
	@Override
	public void update() {
		// have been update in unit attack method
	}

	@Override
	public void draw(GraphicsContext gc) {
		GameLogic.getInstance();
			gc.drawImage(RenderableHolder.towerImg1, getX() - 150, getY() - 170, 250, 300);
	}

	public void spawnUnit(Unit unit) {

	}

	/* GETTER & SETTER */
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public long getTowerSpawnTime() {
		return towerSpawnTime;
	}

	public void setTowerSpawnTime(long towerSpawnTime) {
		this.towerSpawnTime = towerSpawnTime;
	}

}
