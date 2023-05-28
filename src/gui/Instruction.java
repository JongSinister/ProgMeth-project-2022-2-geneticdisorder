package gui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.Main;
import sharedObject.RenderableHolder;

public class Instruction extends BorderPane {

	private Scene scene;

	public Instruction() {
		super();
		this.setPrefSize(1360, 768);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));

		VBox centerBox = new VBox(20);
		centerBox.setAlignment(Pos.CENTER);
		Font font = Font.font("Impact", FontWeight.MEDIUM, 50);
		Font detail = Font.font("Times New Roman", FontWeight.LIGHT, 20);

		Text instructionText = new Text("INSTRUCTION");
		instructionText.setFont(font);
		instructionText.setFill(Color.WHITE);
		BorderPane.setAlignment(instructionText, Pos.TOP_CENTER);
		BorderPane.setMargin(instructionText, new javafx.geometry.Insets(0, 0, 0, 0));

		Text intro1 = new Text(
				" Welcome to the epic battlefield of \"City Siege: Defender's Destiny\"! Prepare to take command as a fearless \n general in the midst of a war-torn land. As the enemy forces relentlessly advance towards our cherished \n city, it is up to you to lead our brave troops in the ultimate battle for survival. \n"
						+ "\n "
						+ "Your strategic prowess and tactical genius will be put to the test as you deploy and maneuver our forces \n across the treacherous terrain. From commanding infantry squads and armored divisions to calling in \n devastating airstrikes and artillery barrages, every decision you make will shape the outcome of this \n crucial conflict. \n"
						+ "\n"
						+ " But beware, the enemy's forces are formidable and cunning. They will employ a variety of tactics, unleash \n fearsome war machines, and even infiltrate our city's defenses. It will take strategic brilliance and quick \n thinking to outmaneuver and overcome their relentless assault. \n"
						+ "\n"
						+ " The fate of our city rests in your hands, General. Lead with honor, bravery, and unwavering determination. \n Rally our troops, forge alliances, and prove yourself as a legendary commander on the battlefield. \n"
						+ "\n"
						+ " Remember, victory will require not only military might but also wise decision-making and resource \n management. Are you ready to take up arms, defend our city, and ensure our people's survival? The battle \n awaits, General. Lead us to glory!\n"
						+ "");
		intro1.setFont(detail);
		intro1.setFill(Color.WHITE);
		BorderPane.setAlignment(intro1, Pos.TOP_CENTER);
		BorderPane.setMargin(intro1, new javafx.geometry.Insets(120, 0, 0, 0));

		centerBox.getChildren().addAll(instructionText, intro1);
		setCenter(centerBox);

		Canvas canvas = new Canvas();
		canvas.setHeight(768);
		canvas.setWidth(1360);
		GraphicsContext gcm = canvas.getGraphicsContext2D();

		gcm.drawImage(RenderableHolder.homeIcon, 640, 10, 80, 80);
		gcm.drawImage(RenderableHolder.nextButton, 1230, 20, 60, 60);

		this.getChildren().add(canvas);

		this.setOnMouseClicked(event -> {
			double mouseX = event.getX();
			double mouseY = event.getY();

			if (mouseX >= 640 && mouseX <= 720 && mouseY >= 10 && mouseY <= 90) {
				toMenu();
			}

			if (mouseX >= 1230 && mouseX <= 1290 && mouseY >= 20 && mouseY <= 80) {
				toGameInformation();
			}
		});

	}

	public void toMenu() {
		MainMenu back = new MainMenu();
		scene = new Scene(back);
		Main.stage.setScene(scene);
	}

	public void toGameInformation() {
		GameInformation gameInformation = new GameInformation(1360, 768);
		Group group = new Group(gameInformation);
		scene = new Scene(group);
		Main.stage.setScene(scene);

		gameInformation.requestFocus();
	}
}