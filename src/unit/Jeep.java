package unit;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Jeep extends Unit {
	/* CONSTRUCTOR */
	public Jeep(Team team) {
		super(team);
		setHp(100);
		setSpeed(2);
		setAttackRange(200);
		setCost(50);
		setAttackSpeed(50000000);
		setPower(2);
		setSpawnCd(1000000000);
		setSpawnTime(GameLogic.getCurrentTime());

		if (getTeam().equals(Team.Player)) {
			setX(50);
			setY(500 + Math.round(30 * (Math.random())));
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1310);
			setY(500 + Math.round(30 * (Math.random())));
		}

		setZ(Math.round(getY()) - 490);
	}

	@Override
	public void draw(GraphicsContext gc) {
		GameLogic.getInstance();
		if (this.getTeam().equals(Team.Player)) {
			if (isAttacking()) {
				setShootTime(GameLogic.getCurrentTime());
			}
			if (getTargetEntity() != null) {
				if ((GameLogic.getCurrentTime() - getShootTime()) < 750000000) {
					if ((GameLogic.getCurrentTime() - getShootTime()) % 20000000 < 10000000) { 
						gc.drawImage(RenderableHolder.playerJeepF1, getX() - 85, getY() - 60, 138, 70);
					} else {
						gc.drawImage(RenderableHolder.playerJeepF2, getX() - 83, getY() - 60, 135, 70);
					}
				} else {
					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) { 
						gc.drawImage(RenderableHolder.playerJeepS1, getX() - 85, getY() - 60, 138, 70);
					} else {
						gc.drawImage(RenderableHolder.playerJeepS2, getX() - 86, getY() - 60, 138, 70);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 666666666) < 333333333) {
					gc.drawImage(RenderableHolder.playerJeepR1, getX() - 102, getY() - 60, 154, 70);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 666666666) < 666666666) {
					gc.drawImage(RenderableHolder.playerJeepR3, getX() - 102, getY() - 60, 154, 70);
				}
			}
		}

		if (this.getTeam().equals(Team.Enemy)) {
			if (isAttacking()) {
				setShootTime(GameLogic.getCurrentTime());
			}
			if (getTargetEntity() != null) {
				if ((GameLogic.getCurrentTime() - getShootTime()) < 750000000) {

					if ((GameLogic.getCurrentTime() - getShootTime()) % 30000000 < 10000000) {
						gc.drawImage(RenderableHolder.enemyJeepF1, getX() - 75, getY() - 60, 131, 70);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) % 30000000 < 20000000) {
						gc.drawImage(RenderableHolder.enemyJeepF2, getX() - 75, getY() - 60, 131, 70);
					} else {
						gc.drawImage(RenderableHolder.enemyJeepF3, getX() - 75, getY() - 60, 131, 70);
					}
				} else {

					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.enemyJeepS1, getX() - 75, getY() - 60, 131, 70);
					} else {
						gc.drawImage(RenderableHolder.enemyJeepS2, getX() - 75, getY() - 60, 131, 70);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.enemyJeepR1, getX() - 75, getY() - 60, 131, 70);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.enemyJeepR2, getX() - 75, getY() - 60, 131, 70);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.enemyJeepR3, getX() - 75, getY() - 60, 131, 70);
				}
			}

		}
		if (this.isHitting()) {
			if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() - 50, getY() - 50, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX() - 50, getY() - 50, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() - 50, getY() - 50, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() - 50, getY() - 50, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() - 50, getY() - 50, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() - 30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX() - 30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() - 30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() - 30, getY() - 60, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() - 30, getY() - 60, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot1, getX(), getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot2, getX(), getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot3, getX(), getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot4, getX(), getY() - 40, 40, 40);
				}
			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot5, getX() - 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot6, getX() - 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot7, getX() - 80, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot8, getX() - 80, getY() - 40, 40, 40);
				}
			} else {
				this.setHitting(false);
			}
		}
	}
}
