package gui;

import enums.Team;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import unit.ArmoredCar;
import unit.HeavyTank;
import unit.Howitzer;
import unit.Jeep;
import unit.LightTank;

public class GameComponent implements IRenderable {

	@Override
	public void draw(GraphicsContext gc) {
		GameLogic.getInstance();

		/* SET TOP BAR */
		setTopBar(gc);
		/* SET BOTTOM BAR */
		setBottomBar(gc);

	}

	@Override
	public int getZ() {
		return 9999;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	/* METHOD */
	private void setTopBar(GraphicsContext gc) {
		Color a = Color.web("#535353");
		// adding top icon
		gc.drawImage(RenderableHolder.blackHomeIcon, 665, 15, 40, 40);

		// add timer
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font("Impact", FontWeight.NORMAL, 40));
		gc.fillText(getStringGameTime(), 640, 90);

		/* SET HEALTH BAR */
		gc.setLineWidth(5.0);
		gc.setStroke(a);

		// set red bar
		gc.setFill(Color.RED);
		gc.fillRoundRect(50, 30, 500, 50, 10, 10);
		gc.fillRoundRect(810, 30, 500, 50, 10, 10);

		// set current hp
		gc.setFill(Color.LIGHTGREEN);
		gc.fillRoundRect(50, 30,
				((float) GameLogic.getPlayer().getHp()) / ((float) GameLogic.getPlayer().getMaxHp()) * 500, 50, 10, 10);
		gc.fillRoundRect(810, 30,
				((float) GameLogic.getEnemy().getHp()) / ((float) GameLogic.getEnemy().getMaxHp()) * 500, 50, 10, 10);

		// set border
		gc.strokeRoundRect(50, 30, 500, 50, 10, 10);
		gc.strokeRoundRect(810, 30, 500, 50, 10, 10);
	}

	private void setBottomBar(GraphicsContext gc) {
		// draw button bar
		gc.drawImage(RenderableHolder.bottomBarBackground, 0, 618, 1630, 150);

		// add money
		gc.setFill(Color.BLACK);
		gc.fillText(getPlayerMoney(), 1060, 732);

		/* SET SPAWN BUTTON */
		gc.drawImage(RenderableHolder.jeepIcon, 10, 662, 100, 100);
		gc.drawImage(RenderableHolder.armoredCarIcon, 120, 662, 100, 100);
		gc.drawImage(RenderableHolder.lightTankIcon, 230, 662, 100, 100);
		gc.drawImage(RenderableHolder.heavyTankIcon, 340, 662, 100, 100);
		gc.drawImage(RenderableHolder.howitzerIcon, 450, 662, 100, 100);

		// tempolary to get unit field
		Jeep jeep = new Jeep(Team.Player);
		ArmoredCar armoredCar = new ArmoredCar(Team.Player);
		LightTank lightTank = new LightTank(Team.Player);
		HeavyTank heavyTank = new HeavyTank(Team.Player);
		Howitzer howitzer = new Howitzer(Team.Player);

		// unit cost display
		gc.setFont(Font.font("Impact", FontWeight.NORMAL, 20));
		gc.fillText("" + jeep.getCost(), 50, 760);
		gc.fillText("" + armoredCar.getCost(), 160, 760);
		gc.fillText("" + lightTank.getCost(), 270, 760);
		gc.fillText("" + heavyTank.getCost(), 380, 760);
		gc.fillText("" + howitzer.getCost(), 490, 760);

		Color transparentRed = Color.RED.deriveColor(1, 1, 1, 0.5);
		gc.setFill(transparentRed);

		// money logic
		if (GameLogic.getPlayer().getMoney() < jeep.getCost()) {
			gc.fillRect(10, 662, 100, 100);
		}
		if (GameLogic.getPlayer().getMoney() < armoredCar.getCost()) {
			gc.fillRect(120, 662, 100, 100);
		}
		if (GameLogic.getPlayer().getMoney() < lightTank.getCost()) {
			gc.fillRect(230, 662, 100, 100);
		}
		if (GameLogic.getPlayer().getMoney() < heavyTank.getCost()) {
			gc.fillRect(340, 662, 100, 100);
		}
		if (GameLogic.getPlayer().getMoney() < howitzer.getCost()) {
			gc.fillRect(450, 662, 100, 100);
		}

		// cooldown logic
		float jeepIconBlackRatio = Math.min(1,
				(((float) GameLogic.getCurrentTime() - GameLogic.getTimeSpawnJeep()) / (float) jeep.getSpawnCd()));
		float armoredCarIconBlackRatio = Math.min(1,
				(((float) GameLogic.getCurrentTime() - GameLogic.getTimeSpawnArmoredCar())
						/ (float) armoredCar.getSpawnCd()));
		float lightTankIconBlackRatio = Math.min(1,
				(((float) GameLogic.getCurrentTime() - GameLogic.getTimeSpawnLightTank())
						/ (float) lightTank.getSpawnCd()));
		float heavyTankIconBlackRatio = Math.min(1,
				(((float) GameLogic.getCurrentTime() - GameLogic.getTimeSpawnHeavyTank())
						/ (float) heavyTank.getSpawnCd()));
		float howitzerIconBlackRatio = Math.min(1,
				(((float) GameLogic.getCurrentTime() - GameLogic.getTimeSpawnHowitzer())
						/ (float) howitzer.getSpawnCd()));

		Color transparentBlack = Color.BLACK.deriveColor(1, 1, 1, 0.5);
		gc.setFill(transparentBlack);

		gc.fillRect(10, 662, 100, 100 * (1 - jeepIconBlackRatio));
		gc.fillRect(120, 662, 100, 100 * (1 - armoredCarIconBlackRatio));
		gc.fillRect(230, 662, 100, 100 * (1 - lightTankIconBlackRatio));
		gc.fillRect(340, 662, 100, 100 * (1 - heavyTankIconBlackRatio));
		gc.fillRect(450, 662, 100, 100 * (1 - howitzerIconBlackRatio));

	}

	/* METHOD get value update gui to relate to GameLogic */
	private String getPlayerMoney() {
		GameLogic.getInstance();
		return "Money : " + GameLogic.getPlayer().getMoney();
	}

	private String getStringGameTime() {
		GameLogic.getInstance();
		String min = formatToDoubleDigit(GameLogic.getGameTime() / 60);
		String sec = formatToDoubleDigit(GameLogic.getGameTime() % 60);
		return min + ":" + sec;

	}

	private String formatToDoubleDigit(int x) {
		if (0 <= x && x <= 9) {
			return "0" + x;
		}
		return "" + x;
	}
}