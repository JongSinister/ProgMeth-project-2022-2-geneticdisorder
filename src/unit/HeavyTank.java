package unit;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import java.lang.Math;

public class HeavyTank extends Unit {
	/* CONSTRUCTOR */
	public HeavyTank(Team team) {
		super(team);
		setHp(500);
        setSpeed((float) 1.25);
        setAttackRange(350);
        setCost(250);
        setAttackSpeed(1200000000);
        setPower(300);
        setSpawnCd(3000000000L);
        setSpawnTime(GameLogic.getCurrentTime());

		if (getTeam().equals(Team.Player)) {
			setX(50);
			setY(590 + Math.round(30 * (Math.random())));
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1310);
			setY(590 + Math.round(30 * (Math.random())));
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
						gc.drawImage(RenderableHolder.playerHeavyTankF1, getX() - 75, getY() - 60, 211, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.playerHeavyTankF2, getX() - 80, getY() - 60, 259, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 150000000) {
						gc.drawImage(RenderableHolder.playerHeavyTankF3, getX() - 85, getY() - 60, 240, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 200000000) {
						gc.drawImage(RenderableHolder.playerHeavyTankF4, getX() - 80, getY() - 60, 232, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.playerHeavyTankF5, getX() - 75, getY() - 60, 217, 80);
					}
				} else {
					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.playerHeavyTankS1, getX() - 75, getY() - 60, 195, 80);
					} else {
						gc.drawImage(RenderableHolder.playerHeavyTankS2, getX() - 75, getY() - 60, 195, 80);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.playerHeavyTankR1, getX() - 75, getY() - 60, 195, 80);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.playerHeavyTankR2, getX() - 75, getY() - 60, 195, 80);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.playerHeavyTankR3, getX() - 75, getY() - 60, 195, 80);
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
						gc.drawImage(RenderableHolder.enemyHeavyTankF1, getX() - 91, getY() - 60, 211, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 100000000) {
						gc.drawImage(RenderableHolder.enemyHeavyTankF2, getX() - 134, getY() - 60, 259, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 150000000) {
						gc.drawImage(RenderableHolder.enemyHeavyTankF3, getX() - 110, getY() - 60, 240, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 200000000) {
						gc.drawImage(RenderableHolder.enemyHeavyTankF4, getX() - 107, getY() - 60, 232, 80);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) < 250000000) {
						gc.drawImage(RenderableHolder.enemyHeavyTankF5, getX() - 97, getY() - 60, 217, 80);
					}
				} else {
					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.enemyHeavyTankS1, getX() - 75, getY() - 60, 195, 80);
					} else {
						gc.drawImage(RenderableHolder.enemyHeavyTankS2, getX() - 75, getY() - 60, 195, 80);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.enemyHeavyTankR1, getX() - 75, getY() - 60, 195, 80);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.enemyHeavyTankR2, getX() - 75, getY() - 60, 195, 80);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.enemyHeavyTankR3, getX() - 75, getY() - 60, 195, 80);
				}
			}

		}
		if (this.isHitting()) {
			if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() + 20, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX() + 20, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() + 20, getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() + 20, getY() - 40, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() + 20, getY() - 40, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX(), getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX(), getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX(), getY() - 40, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX(), getY() - 40, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX(), getY() - 40, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot1, getX() + 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot2, getX() + 80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot3, getX() + 80, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot4, getX() + 80, getY() - 40, 40, 40);
				}
			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 750000000 && !isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 100000000) {
					gc.drawImage(RenderableHolder.bulletShot5, getX() - 70, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot6, getX() - 70, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot7, getX() - 70, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot8, getX() - 70, getY() - 40, 40, 40);
				}
			} else {
				this.setHitting(false);
			}
		}
	}
}