package unit;

import entity.Entity;
import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Unit extends Entity implements Attackable, Moveable {
	/* FIELD */
	private int power;
	private int cost;
	private float speed;
	private int attackRange;
	private long spawnCd;
	private Entity targetEntity;

	private long attackSpeed;
	private long findTargetTime;
	private long spawnTime;
	private long shootTime;

	private boolean attacking;
	private long timeAttacking;

	/* CONSTRUCTOR */
	public Unit(Team team) {
		super(team);
	}

	/* METHOD */
	@Override
	public void update() {
		if (getTargetEntity() != null) {
			attack(getTargetEntity());
		}
		move();

	}

	@Override
	public void draw(GraphicsContext gc) {
		if (this.getTeam().equals(Team.Player)) {
			gc.drawImage(RenderableHolder.weedyTest, getX(), getY());
		}
		if (this.getTeam().equals(Team.Enemy)) {
			gc.drawImage(RenderableHolder.weedyTest, getX(), getY());
		}
	}

	@Override
	public void attack(Entity entity) {
		this.setAttacking(false);
		// entity.setHitting(false)
		GameLogic.getInstance();
		if (GameLogic.getCurrentTime() - findTargetTime >= attackSpeed) { // check attackCooldown
			// Audio
			if (this.getClass().getName().equals("unit.Jeep")) {
				AudioClip jeepAudio = RenderableHolder.gunShootingSound;
				jeepAudio.setVolume(0.2);
				jeepAudio.play();
			}
			if (this.getClass().getName().equals("unit.ArmoredCar")) {
				AudioClip armoredCarAudio = RenderableHolder.gunShootingSound2;
				armoredCarAudio.setVolume(0.2);
				armoredCarAudio.play();
			}
			if (this.getClass().getName().equals("unit.LightTank")) {
				RenderableHolder.tankShoot1.play();
			}
			if (this.getClass().getName().equals("unit.HeavyTank")) {
				RenderableHolder.tankShoot2.play();
			}
			if (this.getClass().getName().equals("unit.Howitzer")) {
				RenderableHolder.howitzerShootingSound.play();
			}

			if (this.getClass().getName().equals("unit.ArmoredCar") || this.getClass().getName().equals("unit.Jeep")) {
				entity.setExplode(false);
			} else {
				entity.setExplode(true);
			}
			this.setAttacking(true);
			entity.setHitting(true);
			entity.setHp(entity.getHp() - this.getPower());
			setFindTargetTime(GameLogic.getCurrentTime() + attackSpeed); // set time of next attack
			setTimeAttacking(GameLogic.getCurrentTime()); // time that shooting
			entity.setTimeGetShot(GameLogic.getCurrentTime());
		}
	}

	@Override
	public void move() {
		if (getTargetEntity() == null) {
			if (this.getTeam().equals(Team.Player)) {
				this.setX(getX() + getSpeed());
			}
			if (this.getTeam().equals(Team.Enemy)) {
				this.setX(getX() - getSpeed());
			}
		}
	}

	/* GETTER & SETTER */
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = Math.max(0, power);
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = Math.max(0, cost);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = Math.max(0, speed);
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(long attackSpeed) {
		this.attackSpeed = Math.max(0, attackSpeed);
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public long getSpawnCd() {
		return spawnCd;
	}

	public void setSpawnCd(long spawnCd) {
		this.spawnCd = spawnCd;
	}

	public Entity getTargetEntity() {
		return targetEntity;
	}

	public void setTargetEntity(Entity targetEntity) {
		this.targetEntity = targetEntity;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public long getFindTargetTime() {
		return findTargetTime;
	}

	public void setFindTargetTime(long findTargetTime) {
		this.findTargetTime = findTargetTime;
	}

	public long getTimeAttacking() {
		return timeAttacking;
	}

	public void setTimeAttacking(long timeAttacking) {
		this.timeAttacking = timeAttacking;
	}

	public void setSpawnTime(long spawnTime) {
		this.spawnTime = spawnTime;
	}

	public long getSpawnTime() {
		return this.spawnTime;
	}

	public void setShootTime(long shootTime) {
		this.shootTime = shootTime;
	}

	public long getShootTime() {
		return this.shootTime;
	}

}
