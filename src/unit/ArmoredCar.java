package unit;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class ArmoredCar extends Unit{
	/* CONSTRUCTOR */
	public ArmoredCar(Team team) {
		super(team);
        setHp(200);
        setSpeed((float) 1.75);
        setAttackRange(225);
        setCost(100);
        setAttackSpeed(80000000);
        setPower(3);
        setSpawnCd(2000000000);	
		setSpawnTime(GameLogic.getCurrentTime());

		if (getTeam().equals(Team.Player)) {
			setX(50);
			setY(530 + Math.round(30 * (Math.random())));
		}
		if (getTeam().equals(Team.Enemy)) {
			setX(1310);
			setY(530 + Math.round(30 * (Math.random())));
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
					if ((GameLogic.getCurrentTime() - getShootTime()) %30000000 < 10000000) {
						gc.drawImage(RenderableHolder.playerArmoredCarF1, getX() - 75+4.37, getY() - 60, 176.43, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime()) %30000000 < 20000000) {
						gc.drawImage(RenderableHolder.playerArmoredCarF2, getX() - 75+4.37, getY() - 60, 176.43, 65);
					} else{
						gc.drawImage(RenderableHolder.playerArmoredCarF3, getX() - 75+4.37, getY() - 60, 176.43, 65);
					}
				} else {
					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.playerArmoredCarS1, getX() - 75+4.37, getY() - 60-2, 176.43, 67);
					} else {
						gc.drawImage(RenderableHolder.playerArmoredCarS2, getX() - 75+3.76, getY() - 60, 177.04, 65);
					}
				}
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.playerArmoredCarR1, getX() - 75, getY() - 60, 180.8, 65);//standard
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.playerArmoredCarR2, getX() - 75-1, getY() - 60-2, 181.8, 67);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.playerArmoredCarR3, getX() - 75, getY() - 60-1, 180.8, 66);
				}
			}
		}

		if (this.getTeam().equals(Team.Enemy)) {
			if (isAttacking()) {
				setShootTime(GameLogic.getCurrentTime());
			}
			if (getTargetEntity() != null) {
				if ((GameLogic.getCurrentTime() - getShootTime()) <750000000) {

					if ((GameLogic.getCurrentTime() - getShootTime())%30000000 < 10000000) {
						gc.drawImage(RenderableHolder.enemyArmoredCarF1, getX() - 75, getY() - 60, 176, 65);
					} else if ((GameLogic.getCurrentTime() - getShootTime())%30000000 < 20000000) {
						gc.drawImage(RenderableHolder.enemyArmoredCarF2, getX() - 75, getY() - 62, 176, 67);
					} else {
						gc.drawImage(RenderableHolder.enemyArmoredCarF3, getX() - 75, getY() - 61, 176, 66);
					}
				} else {

					if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 500000000) {
						gc.drawImage(RenderableHolder.enemyArmoredCarS1, getX() - 75, getY() - 60, 177, 65);
					} else {
						gc.drawImage(RenderableHolder.enemyArmoredCarS2, getX() - 75, getY() - 60, 171, 65);
					}
				}
				
			} else {
				if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 333333333) {
					gc.drawImage(RenderableHolder.enemyArmoredCarR1, getX() - 75, getY() - 60, 181, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 666666666) {
					gc.drawImage(RenderableHolder.enemyArmoredCarR2, getX() - 75, getY() - 60, 181, 65);
				} else if (((GameLogic.getCurrentTime() - getSpawnTime()) % 1000000000) < 999999999) {
					gc.drawImage(RenderableHolder.enemyArmoredCarR3, getX() - 75, getY() - 60, 181, 65);
				}
			}

		}
		if (this.isHitting()) {
			if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Player)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX() , getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX(), getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX() , getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX() , getY() - 60, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX() , getY() - 60, 70, 70);

				}

			} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 300000000 && isExplode()
					&& this.getTeam().equals(Team.Enemy)) {
				if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 100000000) {
					gc.drawImage(RenderableHolder.artilleryExplode1, getX()-30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 150000000) {
					gc.drawImage(RenderableHolder.artilleryExplode2, getX()-30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 200000000) {
					gc.drawImage(RenderableHolder.artilleryExplode3, getX()-30, getY() - 60, 70, 70);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) < 250000000) {
					gc.drawImage(RenderableHolder.artilleryExplode4, getX()-30, getY() - 60, 70, 70);
				} else {
					gc.drawImage(RenderableHolder.artilleryExplode5, getX()-30, getY() - 60, 70, 70);

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
					gc.drawImage(RenderableHolder.bulletShot5, getX()-80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 200000000) {
					gc.drawImage(RenderableHolder.bulletShot6, getX()-80, getY() - 40, 40, 40);
				} else if ((GameLogic.getCurrentTime() - getTimeGetShot()) % 400000000 < 300000000) {
					gc.drawImage(RenderableHolder.bulletShot7, getX()-80, getY() - 40, 40, 40);
				} else {
					gc.drawImage(RenderableHolder.bulletShot8, getX()-80, getY() - 40, 40, 40);
				}
			} else {
				this.setHitting(false);
			}
		}
	}
}

	

