package gui;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

public class GameEnd extends BorderPane {
	private Scene scene;

	public GameEnd() {
		super();
		this.setPrefSize(1360, 768);

		Canvas canvas = new Canvas();
		canvas.setHeight(768);
		canvas.setWidth(1360);

		GraphicsContext gcm = canvas.getGraphicsContext2D();

		gcm.drawImage(RenderableHolder.gameEndWallpaper, 0, 0, 1360, 768);
		this.getChildren().addAll(canvas);

		/* set component */
		VBox centerBox = new VBox(20);
		centerBox.setAlignment(Pos.CENTER);

		Font font = Font.font("Impact", FontWeight.MEDIUM, 50);
		Font titleFont = Font.font("Impact", FontWeight.EXTRA_BOLD, 70);

		// win scenario
		if (GameLogic.isWin()) {
			Text title = new Text("CONGRATULATION YOU WIN!");
			title.setFont(titleFont);
			title.setFill(Color.SNOW);
			centerBox.getChildren().addAll(title);
		}
		if (GameLogic.isLose()) {
			Text title = new Text("MISSION FAILED");
			title.setFont(titleFont);
			title.setFill(Color.SNOW);
			centerBox.getChildren().addAll(title);
		}
		
		Text timeUse = new Text("At time " + getStringGameTime());
		timeUse.setFont(titleFont);
		timeUse.setFill(Color.SNOW);
		
		Text newGameText = new Text("> NEW GAME <");
		newGameText.setFont(font);
		newGameText.setFill(Color.SNOW);
		newGameText.setOpacity(0.7);
		
		Text exitText = new Text("> EXIT <");
		exitText.setFont(font);
		exitText.setFill(Color.SNOW);
		exitText.setOpacity(0.7);

		centerBox.getChildren().addAll(timeUse,newGameText,exitText);

		setCenter(centerBox);
		
		/* Event handle */
		newGameText.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				newGameText.setOpacity(1);
			}
		});

		newGameText.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				newGameText.setOpacity(0.7);
			}
		});
		
		newGameText.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				toGameScreen();
			}
		});
		
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
				if (GameLogic.isWin() || GameLogic.isLose()) {
					gameScreen.paintComponenet();
					this.stop();
				}
			}
		};
		animation.start();
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
