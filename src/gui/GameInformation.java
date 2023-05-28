package gui;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Main;
import sharedObject.RenderableHolder;

public class GameInformation extends Canvas {

	private Scene scene;

	public GameInformation(double width, double height) {
		super(width, height);
		this.setVisible(true);

		GraphicsContext gc = this.getGraphicsContext2D();

		gc.setFill(Color.BLACK);
		gc.drawImage(RenderableHolder.gameInfo, 0, 0, 1360, 768);
		gc.drawImage(RenderableHolder.homeIcon, 1230, 10, 80, 80);
		gc.drawImage(RenderableHolder.backButton, 130, 20, 60, 60);

		this.setOnMouseClicked(event -> {
			double mouseX = event.getX();
			double mouseY = event.getY();

			if (mouseX >= 1230 && mouseX <= 1310 && mouseY >= 10 && mouseY <= 90) {
				toMenu();
			}

			if (mouseX >= 130 && mouseX <= 190 && mouseY >= 20 && mouseY <= 80) {
				toInstruction();
			}
		});

	}

	public void toMenu() {
		MainMenu back = new MainMenu();
		scene = new Scene(back);
		Main.stage.setScene(scene);
	}

	public void toInstruction() {
		Instruction instruction = new Instruction();
		scene = new Scene(instruction);
		Main.stage.setScene(scene);
	}

}