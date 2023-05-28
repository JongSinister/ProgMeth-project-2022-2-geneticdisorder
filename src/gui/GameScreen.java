package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import main.Main;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas {
	private Scene scene;
	private Boolean isGameEnd = false;

	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);

		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.gameScreenBackground, 0, 0, 1360, 768);
		this.setOnMouseClicked(event -> {
			double mouseX = event.getX();
			double mouseY = event.getY();
			if (mouseX >= 10 && mouseX <= 110 && mouseY >= 662 && mouseY <= 772) {
				GameLogic.getInstance().spawnJeep();
			}
			if (mouseX >= 120 && mouseX <= 220 && mouseY >= 662 && mouseY <= 772) {
				GameLogic.getInstance().spawnArmoredCar();
			}
			if (mouseX >= 230 && mouseX <= 330 && mouseY >= 662 && mouseY <= 772) {
				GameLogic.getInstance().spawnLightTank();
			}
			if (mouseX >= 340 && mouseX <= 440 && mouseY >= 662 && mouseY <= 772) {
				GameLogic.getInstance().spawnHeavyTank();
			}
			if (mouseX >= 450 && mouseX <= 550 && mouseY >= 662 && mouseY <= 772) {
				GameLogic.getInstance().spawnHowitzer();
			}
			if (mouseX >= 665 && mouseX <= 705 && mouseY >= 15 && mouseY <= 55) {
				GameLogic.getInstance();
				GameLogic.setEnd(true);
				toMenu();
			}
		});
	}

	public void paintComponenet() {
		GraphicsContext gc = this.getGraphicsContext2D();
		GameLogic.getInstance();
		gc.drawImage(RenderableHolder.gameScreenBackground, 0, 0, 1360, 768);
		/* add IRenderable */
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			entity.draw(gc);
		}

		if (GameLogic.isWin() || GameLogic.isLose()) {
			toGameEnd();
		}
	}

	public void toGameEnd() {
		if (isGameEnd == false) {
			isGameEnd = true;

			// change to GameEnd
			GameEnd ge = new GameEnd();
			scene = new Scene(ge);
			Main.stage.setScene(scene);
		}

	}

	public void toMenu() {
		MainMenu back = new MainMenu();
		scene = new Scene(back);
		Main.stage.setScene(scene);
	}
}