package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import enums.Team;
import gui.GameComponent;
import player.Player;
import sharedObject.RenderableHolder;
import unit.ArmoredCar;
import unit.HeavyTank;
import unit.Howitzer;
import unit.Jeep;
import unit.LightTank;
import unit.Unit;

public class GameLogic {
	/* FIELD */
	private final static GameLogic instance = new GameLogic();

	private static List<Entity> gameObjectContainer;
	private static ArrayList<Entity> entities;

	private static Player player;
	private static Player enemy;

	private static long currentTime;
	private static long lastTimeTriggered = -1;
	private static int gameTime = 0;
	private static int level = 1;
	private static int moneyToAdd = 10;

	private static long timeSpawnJeep = 0;
	private static long timeSpawnArmoredCar = 0;
	private static long timeSpawnLightTank = 0;
	private static long timeSpawnHeavyTank = 0;
	private static long timeSpawnHowitzer = 0;

	private static boolean win;
	private static boolean lose;
	private static boolean end;

	/* CONSTRUCTOR */
	public GameLogic() {
		gameObjectContainer = new ArrayList<>();
		GameComponent gameComponent = new GameComponent();
		RenderableHolder.getInstance().add(gameComponent);

		/* Generate Player */
		player = new Player(Team.Player);
		enemy = new Player(Team.Enemy);

		/* Initialize ArrayList */
		entities = new ArrayList<>();

		/* addObjects */
		addNewObject(player);
		addNewObject(enemy);

		entities.add(player);
		entities.add(enemy);

		win = false;
		lose = false;
		end = false;

	}

	/* METHOD */
	public void gameStart() {
		gameObjectContainer.clear();
		setGameTime(0);

		GameComponent gameComponent = new GameComponent();
		RenderableHolder.getInstance().add(gameComponent);

		/* Clear ArrayList */
		entities.clear();

		/* Generate Player */
		player = new Player(Team.Player);
		enemy = new Player(Team.Enemy);

		/* Initialize ArrayList */
		entities = new ArrayList<>();

		/* addObjects */
		addNewObject(player);
		addNewObject(enemy);

		entities.add(player);
		entities.add(enemy);

		win = false;
		lose = false;
		end = false;

	}

	public void logicUpdate() {

		/* Update all entities */
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i) != null) {

				/* find targetEntity of all unit */
				if (entities.get(i) instanceof Unit) {
					if (((Unit) entities.get(i)).getTargetEntity() == null) {
						float xDiff = 1360; // max width size
						int targetHp = 1000000; // large number to check

						// finding target of entity.get(i)
						for (int j = entities.size() - 1; j >= 0; j--) {

							// check that entity is enemy,inAttackRange && closedDistance,minMaxHp enemy
							if (!entities.get(i).getTeam().equals(entities.get(j).getTeam())
									&& entities.get(i).distanceBetweenEntity(
											entities.get(j)) <= ((Unit) entities.get(i)).getAttackRange()
									&& entities.get(i).distanceBetweenEntity(entities.get(j)) <= xDiff
									&& entities.get(j).getHp() <= targetHp) {
								xDiff = entities.get(i).distanceBetweenEntity(entities.get(j));
								targetHp = entities.get(j).getHp();
								((Unit) entities.get(i)).setTargetEntity(entities.get(j)); // setTarget
								((Unit) entities.get(i)).setFindTargetTime(currentTime); // setFindTargetTime
							}
						}
					}
				}

				/* Update all entities */
				if (entities.get(i).getHp() != 0) {
					entities.get(i).update();
				}
				if (entities.get(i).getHp() == 0) {
					for (int j = entities.size() - 1; j >= 0; j--) {
						if (entities.get(j) instanceof Unit && ((Unit) entities.get(j)).getTargetEntity() != null
								&& ((Unit) entities.get(j)).getTargetEntity().equals(entities.get(i))) {
							((Unit) entities.get(j)).setTargetEntity(null);
						}
					}
					entities.get(i).setDestroyed();
					entities.remove(i);
				}
			}
		}
	}

	public void gameUpdate() {
		updateGameTime();
		checkGameEnd();
		if (isEnd()) {
			return;
		}
		logicUpdate();
	}

	public void checkGameEnd() {
		if (enemy.getHp() <= 0) {
			setWin(true);
			setEnd(true);

		}
		if (player.getHp() <= 0) {
			setLose(true);
			setEnd(true);
		}
	}

	public void spawnEnemyUnits() {
		if (gameTime == 0) {
			return;
		}
		if (gameTime % 30 == 0) {
			level += 1;
			level = Math.min(3, level);
		}
		if (level >= 1) {
			if (gameTime % 5 == 0) {
				Jeep jeep = new Jeep(Team.Enemy);
				addNewObject(jeep);
				entities.add(jeep);
			}
			if (gameTime % 10 == 0) {
				ArmoredCar armoredCar = new ArmoredCar(Team.Enemy);
				addNewObject(armoredCar);
				entities.add(armoredCar);
			}
			if (gameTime % 20 == 0) {
				LightTank lightTank = new LightTank(Team.Enemy);
				addNewObject(lightTank);
				entities.add(lightTank);
			}
		}
		if (level >= 2) {
			if (gameTime % 15 == 0) {
				HeavyTank heavyTank = new HeavyTank(Team.Enemy);
				addNewObject(heavyTank);
				entities.add(heavyTank);
			}

		}
		if (level == 3) {
			if (gameTime % 60 == 0) {
				Howitzer howitzer = new Howitzer(Team.Enemy);
				addNewObject(howitzer);
				entities.add(howitzer);
			}

		}
	}

	// Update everything that relate to timer
	public void updateGameTime() {
		lastTimeTriggered = (lastTimeTriggered < 0 ? currentTime : lastTimeTriggered);
		if (currentTime - lastTimeTriggered >= 1000000000) {
			gameTime++;
			lastTimeTriggered = currentTime;

			spawnEnemyUnits();

			if (gameTime % 10 == 0) {
				moneyToAdd += 10;
			}

			moneyToAdd = Math.min(moneyToAdd, 50);

			getPlayer().setMoney(getPlayer().getMoney() + moneyToAdd);
		}

	}

	// set on player action to spawn units
	public void spawnJeep() {
		Jeep jeep = new Jeep(Team.Player);
		if (currentTime - timeSpawnJeep >= jeep.getSpawnCd()) { // check spawn cd
			if (player.getMoney() >= jeep.getCost()) { // check if money enough
				timeSpawnJeep = currentTime;
				player.setMoney(player.getMoney() - jeep.getCost());
				addNewObject(jeep);
				entities.add(jeep);
			}
		}
	}

	public void spawnArmoredCar() {
		ArmoredCar armoredCar = new ArmoredCar(Team.Player);
		if (currentTime - timeSpawnArmoredCar >= armoredCar.getSpawnCd()) { // check spawn cd
			if (player.getMoney() >= armoredCar.getCost()) { // check if money enough
				timeSpawnArmoredCar = currentTime;
				player.setMoney(player.getMoney() - armoredCar.getCost());
				addNewObject(armoredCar);
				entities.add(armoredCar);
			}
		}
	}

	public void spawnLightTank() {
		LightTank lightTank = new LightTank(Team.Player);
		if (currentTime - timeSpawnLightTank >= lightTank.getSpawnCd()) { // check spawn cd
			if (player.getMoney() >= lightTank.getCost()) { // check if money enough
				timeSpawnLightTank = currentTime;
				player.setMoney(player.getMoney() - lightTank.getCost());
				addNewObject(lightTank);
				entities.add(lightTank);
			}
		}
	}

	public void spawnHeavyTank() {
		HeavyTank heavyTank = new HeavyTank(Team.Player);
		if (currentTime - timeSpawnHeavyTank >= heavyTank.getSpawnCd()) { // check spawn cd
			if (player.getMoney() >= heavyTank.getCost()) { // check if money enough
				// heavyTank.setSpawnTime(getCurrentTime());
				timeSpawnHeavyTank = currentTime;
				player.setMoney(player.getMoney() - heavyTank.getCost());
				addNewObject(heavyTank);
				entities.add(heavyTank);
			}
		}
	}

	public void spawnHowitzer() {
		Howitzer howitzer = new Howitzer(Team.Player);
		if (currentTime - timeSpawnHowitzer >= howitzer.getSpawnCd()) { // check spawn cd
			if (player.getMoney() >= howitzer.getCost()) { // check if money enough
				timeSpawnHowitzer = currentTime;
				player.setMoney(player.getMoney() - howitzer.getCost());
				addNewObject(howitzer);
				entities.add(howitzer);
			}
		}
	}

	// addNewObject
	public void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	/* GETTER & SETTER */
	public static GameLogic getInstance() {
		return instance;
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		GameLogic.player = player;
	}

	public static Player getEnemy() {
		return enemy;
	}

	public static void setEnemy(Player enemy) {
		GameLogic.enemy = enemy;
	}

	public static List<Entity> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public static long getCurrentTime() {
		return currentTime;
	}

	public static void setCurrentTime(long currentTime) {
		GameLogic.currentTime = currentTime;
	}

	public static boolean isWin() {
		return win;
	}

	public static void setWin(boolean win) {
		GameLogic.win = win;
	}

	public static boolean isLose() {
		return lose;
	}

	public static void setLose(boolean lose) {
		GameLogic.lose = lose;
	}

	public static boolean isEnd() {
		return end;
	}

	public static void setEnd(boolean end) {
		GameLogic.end = end;
	}

	public static int getGameTime() {
		return gameTime;
	}

	public static void setGameTime(int gameTime) {
		GameLogic.gameTime = gameTime;
	}

	public static long getTimeSpawnJeep() {
		return timeSpawnJeep;
	}

	public static long getTimeSpawnArmoredCar() {
		return timeSpawnArmoredCar;
	}

	public static long getTimeSpawnLightTank() {
		return timeSpawnLightTank;
	}

	public static long getTimeSpawnHeavyTank() {
		return timeSpawnHeavyTank;
	}

	public static long getTimeSpawnHowitzer() {
		return timeSpawnHowitzer;
	}
}