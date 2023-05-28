package unit;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import java.lang.Math;

public class LightTank extends Unit {
	/* CONSTRUCTOR */
	public LightTank(Team team) {
		super(team);
		setHp(350);
		setSpeed((float) 1.25);
		setAttackRange(300);
		setCost(150);
		setAttackSpeed(700000000);
		setPower(150);
		setSpawnCd(3000000000L);
		setSpawnTime(GameLogic.getCurrentTime());

		if (getTeam().equals(Team.Player)) {
			setX(50);
			setY(560 + Math.round(30 * (Math.random())));
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1310);
			setY(5560 + Math.round(30 * (Math.random())));
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
				if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
					if ((GameLogic.getCurrentTime() - getShootTime()) < 50000000) {
						gc.drawImage(RenderableHolder.playerLightTankF1, getX() - 75, getY() - 60, 181, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.playerLightTankF2, getX() - 80, getY() - 60, 209, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 150000000) {
						gc.drawImage(RenderableHolder.playerLightTankF3, getX() - 85, getY() - 60, 200, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 200000000) {
						gc.drawImage(RenderableHolder.playerLightTankF4, getX() - 80, getY() - 60, 192, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.playerLightTankF5, getX() - 75, getY() - 60, 183, 65);
					}
				} else {
					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.playerLightTankS1, getX() - 75, getY() - 60, 163, 65);
					} else {
						gc.drawImage(RenderableHolder.playerLightTankS2, getX() - 75, getY() - 60, 163, 65);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.playerLightTankR1, getX() - 75, getY() - 60, 163, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.playerLightTankR2, getX() - 75, getY() - 60, 163, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.playerLightTankR3, getX() - 75, getY() - 60, 163, 65);
				}
			}
		}

		if (this.getTeam().equals(Team.Enemy)) {
			if (isAttacking()) {
				setShootTime(GameLogic.getCurrentTime());
			}
			if (getTargetEntity() != null) {
				if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {

					if ((GameLogic.getCurrentTime() - getShootTime()) < 50000000) {
						gc.drawImage(RenderableHolder.enemyLightTankF1, getX() - 93, getY() - 60, 181, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.enemyLightTankF2, getX() - 116, getY() - 60, 209, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 150000000) {
						gc.drawImage(RenderableHolder.enemyLightTankF3, getX() - 101, getY() - 60, 200, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 200000000) {
						gc.drawImage(RenderableHolder.enemyLightTankF4, getX() - 99, getY() - 60, 192, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.enemyLightTankF5, getX() - 95, getY() - 60, 183, 65);
					}
				} else {

					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.enemyLightTankS1, getX() - 75, getY() - 60, 163.16, 65);
					} else {
						gc.drawImage(RenderableHolder.enemyLightTankS2, getX() - 75, getY() - 60, 163.16, 65);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.enemyLightTankR1, getX() - 75, getY() - 60, 163.16, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.enemyLightTankR2, getX() - 75, getY() - 60, 163.16, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.enemyLightTankR3, getX() - 75, getY() - 60, 163.16, 65);
				}
			}

		}
		if (this.isHitting()) {
			if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX(), getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX(), getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX(), getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX(), getY() - 60, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX(), getY() - 60, 70, 70);

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
					gc.drawImage(RenderableHolder.bulletShot1, getX() + 30, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot2, getX() + 30, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot3, getX() + 30, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot4, getX() + 30, getY() - 40, 40, 40);
				}
			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot5, getX(), getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot6, getX(), getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot7, getX(), getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot8, getX(), getY() - 40, 40, 40);
				}
			} else {
				this.setHitting(false);
			}
		}

	}
}