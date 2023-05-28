package entity;

import enums.Team;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	/* FIELD */
	private int maxHp;
	private int hp;
	private Team team;
	private float x, y;
	private int z;
	private boolean visible, destroyed;
	private boolean hitting;
	
	private long timeGetShot;
	private boolean explode;

	/* CONSTRUCTOR */
	public Entity(Team team) {
		setTeam(team);
		visible = true;
		destroyed = false;
		z = 10;
	}

	/* METHOD */
	public abstract void update();

	public float distanceBetweenEntity(Entity entity) {
		return (Math.abs(this.getX() - entity.getX()));
	}

	/* GETTER & SETTER */
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = Math.max(0, maxHp);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = Math.max(0, hp);
		if (getHp() == 0) {
			setDestroyed();
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed() {
		destroyed = true;
		visible = false;
	}

	@Override
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}

	public boolean isHitting() {
		return hitting;
	}

	public void setHitting(boolean hitting) {
		this.hitting = hitting;
	}

	public long getTimeGetShot() {
		return timeGetShot;
	}

	public void setTimeGetShot(long timeGetShot) {
		this.timeGetShot = timeGetShot;
	}

	public boolean isExplode() {
		return explode;
	}

	public void setExplode(boolean explode) {
		this.explode = explode;
	}

	

}
