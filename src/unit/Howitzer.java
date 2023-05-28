package unit;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Howitzer extends Unit {
	public Howitzer(Team team) {
		super(team);
		setHp(100);
		setSpeed((float) 0.7);
		setAttackRange(500);
		setCost(300);
		setAttackSpeed(2000000000);
		setPower(400);
		setSpawnCd(10000000000L);
		setSpawnTime(GameLogic.getCurrentTime());

		if (getTeam().equals(Team.Player)) {
			setX(50);
			setY(620 + Math.round(30 * (Math.random())));
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1310);
			setY(620 + Math.round(30 * (Math.random())));
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
				if ((GameLogic.getCurrentTime() - getShootTime()) < 400000000) {
					if ((GameLogic.getCurrentTime() - getShootTime()) < 50000000) {
						gc.drawImage(RenderableHolder.playerHowizerF1, getX() - 80 , getY() - 60-10, 251,
								80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.playerHowizerF2, getX() - 95 , getY() - 60-30 ,
								301, 100);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 175000000) {
						gc.drawImage(RenderableHolder.playerHowizerF3, getX() - 115, getY() - 60-14 ,
								273, 84);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.playerHowizerF4, getX() - 95, getY() - 60-21 ,
								263, 91);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 350000000) {
						gc.drawImage(RenderableHolder.playerHowizerF5, getX() - 85, getY() - 60-21 ,
								240, 91);
					} else {
						gc.drawImage(RenderableHolder.playerHowizerF6, getX() - 75 , getY() - 78, 245,
								88);
					}
				} else {
					gc.drawImage(RenderableHolder.playerHowizerS1, getX() - 75, getY() - 60, 235, 70);
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.playerHowizerR1, getX() - 85, getY() - 70, 191, 88);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.playerHowizerR2, getX() - 85, getY() - 70 , 191, 88);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.playerHowizerR3, getX() - 85, getY() - 70 , 191, 88);
				}
			}
		}

		if (this.getTeam().equals(Team.Enemy)) {
			if (isAttacking()) {
				setShootTime(GameLogic.getCurrentTime());
			}
			if (getTargetEntity() != null) {
				if ((GameLogic.getCurrentTime() - getShootTime()) < 400000000) {

					if ((GameLogic.getCurrentTime() - getShootTime()) < 50000000) {
						gc.drawImage(RenderableHolder.enemyHowizerF1, getX() - 81, getY() - 70,
								251, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.enemyHowizerF2, getX() - 126, getY() - 90,
								301, 100);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 175000000) {
						gc.drawImage(RenderableHolder.enemyHowizerF3, getX() - 78, getY() - 74,
								273, 84);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.enemyHowizerF4, getX() - 88, getY() - 81,
								263, 91);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 350000000) {
						gc.drawImage(RenderableHolder.enemyHowizerF5, getX() - 81, getY() - 81, 241,
								91);
					} else {
						gc.drawImage(RenderableHolder.enemyHowizerF6, getX() - 85, getY() - 78, 245,
								88);
					}
				} else {
					gc.drawImage(RenderableHolder.enemyHowizerS1, getX() - 75, getY() - 60, 235, 70);
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.enemyHowizerR1, getX() - 80, getY() - 60 , 240, 88);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.enemyHowizerR2, getX() - 80, getY() - 64, 240,
							88);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.enemyHowizerR3, getX() - 80, getY() - 62, 240,
							88);
				}
			}

		}
		if (this.isHitting()) {
			if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Player)) {

				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() -10, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX() -10, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() -10, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() -10, getY() - 40, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() -10, getY() - 40, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() + 50, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX() + 50, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() + 50, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() + 50, getY() - 40, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() + 50, getY() - 40, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot1, getX() +50, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot2, getX() + 50, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot3, getX() + 50, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot4, getX() + 50, getY() - 40, 40, 40);
				}
			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot5, getX() + 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot6, getX() + 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot7, getX() + 80, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot8, getX() + 80, getY() - 40, 40, 40);
				}
			} else {
				this.setHitting(false);
			}
		}
	}
}
