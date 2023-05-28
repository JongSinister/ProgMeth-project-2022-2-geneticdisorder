package gui;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.GameLogic;
import main.Main;
import sharedObject.RenderableHolder;

public class MainMenu extends BorderPane {

	private Scene scene;

	public MainMenu() {
		super();
		this.setPrefSize(1360, 768);

		Canvas canvas = new Canvas();
		canvas.setHeight(768);
		canvas.setWidth(1360);

		GraphicsContext gcm = canvas.getGraphicsContext2D();

		gcm.drawImage(RenderableHolder.menuWallpaper, 0, 0, 1360, 768);

		this.getChildren().addAll(canvas);

		/* set component */
		VBox centerBox = new VBox(20);
		centerBox.setAlignment(Pos.CENTER);

		Font font = Font.font("Impact", FontWeight.MEDIUM, 50);

		Text logo = new Text("City Siege: Defender's Destiny");
		logo.setFont(Font.font("Impact", FontWeight.BOLD, 70));
		logo.setFill(Color.WHITE);

		Text playText = new Text("PLAY");
		playText.setFont(font);
		playText.setFill(Color.WHITE);
		playText.setOpacity(0.7);

		Text instructionText = new Text("INSTRUCTION");
		instructionText.setFont(font);
		instructionText.setFill(Color.WHITE);
		instructionText.setOpacity(0.7);

		Text exitText = new Text("EXIT");
		exitText.setFont(font);
		exitText.setFill(Color.WHITE);
		exitText.setOpacity(0.7);

		centerBox.getChildren().addAll(logo, playText, instructionText, exitText);
		setCenter(centerBox);

		// set action playText
		playText.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				playText.setOpacity(1);
			}
		});

		playText.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				playText.setOpacity(0.7);
			}
		});

		playText.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				toGameScreen();
			}
		});

		// set action instructionText
		instructionText.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				instructionText.setOpacity(1);
			}
		});

		instructionText.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				instructionText.setOpacity(0.7);
			}
		});

		// set action exitText
		exitText.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				exitText.setOpacity(1);
			}
		});

		exitText.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				exitText.setOpacity(0.7);
			}
		});

		exitText.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.exit(0);
			}
		});

		instructionText.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				toInstruction();
			}
		});
	}

	public void toGameScreen() {
		RenderableHolder.enterGameStage.play();
		GameScreen gameScreen = new GameScreen(1360, 768);
		Group group = new Group(gameScreen);
		scene = new Scene(group);
		RenderableHolder.getInstance().clear();
		GameLogic.getInstance().gameStart();
		Main.stage.setScene(scene);

		gameScreen.requestFocus();

		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponenet();
				GameLogic.setCurrentTime(now);
				GameLogic.getInstance().gameUpdate();
				RenderableHolder.getInstance().update();
				if (GameLogic.isEnd()) {
					gameScreen.paintComponenet();
					this.stop();
				}
			}
		};
		animation.start();
	}

	public void toInstruction() {
		Instruction instruction = new Instruction();
		scene = new Scene(instruction);
		Main.stage.setScene(scene);
	}
}