package main;

import gui.MainMenu;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;

		Parent mainMenu = new MainMenu();
		Scene mainScene = new Scene(mainMenu);
		stage.setTitle("City Siege: Defender's Destiny"); // Set the stage title
		stage.setScene(mainScene);
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}