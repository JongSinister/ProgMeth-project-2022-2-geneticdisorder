package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	// main
	public static Image menuWallpaper;
	public static Image bottomBarBackground;
	public static Image gameEndWallpaper;
	public static Image gameInfo;

	// Tank Icon
	public static Image jeepIcon;
	public static Image armoredCarIcon;
	public static Image lightTankIcon;
	public static Image heavyTankIcon;
	public static Image howitzerIcon;

	// tower
	public static Image towerImg1;

	// unit
	public static Image jeepPlayer;

	public static Image ArmoredCarCar;

	public static Image LightTank;

	public static Image playerHeavyTankR1;
	public static Image playerHeavyTankR2;
	public static Image playerHeavyTankR3;
	public static Image playerHeavyTankS1;
	public static Image playerHeavyTankS2;
	public static Image playerHeavyTankF1;
	public static Image playerHeavyTankF2;
	public static Image playerHeavyTankF3;
	public static Image playerHeavyTankF4;
	public static Image playerHeavyTankF5;
	public static Image enemyHeavyTankR1;
	public static Image enemyHeavyTankR2;
	public static Image enemyHeavyTankR3;
	public static Image enemyHeavyTankS1;
	public static Image enemyHeavyTankS2;
	public static Image enemyHeavyTankF1;
	public static Image enemyHeavyTankF2;
	public static Image enemyHeavyTankF3;
	public static Image enemyHeavyTankF4;
	public static Image enemyHeavyTankF5;

	public static Image playerLightTankR1;
	public static Image playerLightTankR2;
	public static Image playerLightTankR3;
	public static Image playerLightTankF1;
	public static Image playerLightTankF2;
	public static Image playerLightTankF3;
	public static Image playerLightTankF4;
	public static Image playerLightTankF5;
	public static Image playerLightTankS1;
	public static Image playerLightTankS2;
	public static Image enemyLightTankR1;
	public static Image enemyLightTankR2;
	public static Image enemyLightTankR3;
	public static Image enemyLightTankF1;
	public static Image enemyLightTankF2;
	public static Image enemyLightTankF3;
	public static Image enemyLightTankF4;
	public static Image enemyLightTankF5;
	public static Image enemyLightTankS1;
	public static Image enemyLightTankS2;

	public static Image playerJeepR1;
	public static Image playerJeepR2;
	public static Image playerJeepR3;
	public static Image playerJeepF1;
	public static Image playerJeepF2;
	public static Image playerJeepF3;
	public static Image playerJeepS1;
	public static Image playerJeepS2;
	public static Image enemyJeepR1;
	public static Image enemyJeepR2;
	public static Image enemyJeepR3;
	public static Image enemyJeepF1;
	public static Image enemyJeepF2;
	public static Image enemyJeepF3;
	public static Image enemyJeepS1;
	public static Image enemyJeepS2;

	public static Image playerArmoredCarR1;
	public static Image playerArmoredCarR2;
	public static Image playerArmoredCarR3;
	public static Image playerArmoredCarF1;
	public static Image playerArmoredCarF2;
	public static Image playerArmoredCarF3;
	public static Image playerArmoredCarS1;
	public static Image playerArmoredCarS2;
	public static Image enemyArmoredCarR1;
	public static Image enemyArmoredCarR2;
	public static Image enemyArmoredCarR3;
	public static Image enemyArmoredCarF1;
	public static Image enemyArmoredCarF2;
	public static Image enemyArmoredCarF3;
	public static Image enemyArmoredCarS1;
	public static Image enemyArmoredCarS2;

	public static Image playerHowizerR1;
	public static Image playerHowizerR2;
	public static Image playerHowizerR3;
	public static Image playerHowizerF1;
	public static Image playerHowizerF2;
	public static Image playerHowizerF3;
	public static Image playerHowizerF4;
	public static Image playerHowizerF5;
	public static Image playerHowizerF6;
	public static Image playerHowizerS1;
	public static Image enemyHowizerR1;
	public static Image enemyHowizerR2;
	public static Image enemyHowizerR3;
	public static Image enemyHowizerF1;
	public static Image enemyHowizerF2;
	public static Image enemyHowizerF3;
	public static Image enemyHowizerF4;
	public static Image enemyHowizerF5;
	public static Image enemyHowizerF6;
	public static Image enemyHowizerS1;

	public static Image homeIcon;
	public static Image blackHomeIcon;
	public static Image restartIcon;
	public static Image backButton;
	public static Image nextButton;

	public static Image artilleryExplode1;
	public static Image artilleryExplode2;
	public static Image artilleryExplode3;
	public static Image artilleryExplode4;
	public static Image artilleryExplode5;

	public static Image bulletShot1;
	public static Image bulletShot2;
	public static Image bulletShot3;
	public static Image bulletShot4;
	public static Image bulletShot5;
	public static Image bulletShot6;
	public static Image bulletShot7;
	public static Image bulletShot8;

	public static Image gameScreenBackground;

	public static Image Howitzer;

	// audio
	public static AudioClip enterGameStage;
	public static AudioClip gunShootingSound;
	public static AudioClip gunShootingSound2;
	public static AudioClip tankShoot1;
	public static AudioClip tankShoot2;
	public static AudioClip howitzerShootingSound;
	public static AudioClip explodeSound;

	// test
	public static Image weedyTest;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {

		// main
		menuWallpaper = new Image(ClassLoader.getSystemResource("main/menuwallpaper.jpg").toString());
		bottomBarBackground = new Image(ClassLoader.getSystemResource("tower/bbb.png").toString());
		gameEndWallpaper = new Image(ClassLoader.getSystemResource("main/gameEndWallpaper.jpg").toString());
		gameInfo = new Image(ClassLoader.getSystemResource("main/gameInfo.jpg").toString());

		// Tank Icon
		jeepIcon = new Image(ClassLoader.getSystemResource("main/jeepIcon.png").toString());
		armoredCarIcon = new Image(ClassLoader.getSystemResource("main/armoredCarIcon.png").toString());
		lightTankIcon = new Image(ClassLoader.getSystemResource("main/lightTankIcon.png").toString());
		heavyTankIcon = new Image(ClassLoader.getSystemResource("main/heavyTankIcon.png").toString());
		howitzerIcon = new Image(ClassLoader.getSystemResource("main/howitzerIcon.png").toString());

		// tower
		towerImg1 = new Image(ClassLoader.getSystemResource("tower/city1.png").toString());

		// unit
		jeepPlayer = new Image(ClassLoader.getSystemResource("unit/tempCar.png").toString());

		playerHeavyTankR1 = new Image(ClassLoader.getSystemResource("unit/HeavyTankR1.png").toString());
		playerHeavyTankR2 = new Image(ClassLoader.getSystemResource("unit/HeavyTankR2.png").toString());
		playerHeavyTankR3 = new Image(ClassLoader.getSystemResource("unit/HeavyTankR3.png").toString());
		playerHeavyTankS1 = new Image(ClassLoader.getSystemResource("unit/HeavyTankS1.png").toString());
		playerHeavyTankS2 = new Image(ClassLoader.getSystemResource("unit/HeavyTankS2.png").toString());
		playerHeavyTankF1 = new Image(ClassLoader.getSystemResource("unit/HeavyTankF1.png").toString());
		playerHeavyTankF2 = new Image(ClassLoader.getSystemResource("unit/HeavyTankF2.png").toString());
		playerHeavyTankF3 = new Image(ClassLoader.getSystemResource("unit/HeavyTankF3.png").toString());
		playerHeavyTankF4 = new Image(ClassLoader.getSystemResource("unit/HeavyTankF4.png").toString());
		playerHeavyTankF5 = new Image(ClassLoader.getSystemResource("unit/HeavyTankF5.png").toString());
		enemyHeavyTankR1 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankR1.png").toString());
		enemyHeavyTankR2 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankR2.png").toString());
		enemyHeavyTankR3 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankR3.png").toString());
		enemyHeavyTankS1 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankS1.png").toString());
		enemyHeavyTankS2 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankS2.png").toString());
		enemyHeavyTankF1 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankF1.png").toString());
		enemyHeavyTankF2 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankF2.png").toString());
		enemyHeavyTankF3 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankF3.png").toString());
		enemyHeavyTankF4 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankF4.png").toString());
		enemyHeavyTankF5 = new Image(ClassLoader.getSystemResource("unit/EHeavyTankF5.png").toString());

		playerLightTankR1 = new Image(ClassLoader.getSystemResource("unit/LightTankR1.png").toString());
		playerLightTankR2 = new Image(ClassLoader.getSystemResource("unit/LightTankR2.png").toString());
		playerLightTankR3 = new Image(ClassLoader.getSystemResource("unit/LightTankR3.png").toString());
		playerLightTankF1 = new Image(ClassLoader.getSystemResource("unit/LightTankF1.png").toString());
		playerLightTankF2 = new Image(ClassLoader.getSystemResource("unit/LightTankF2.png").toString());
		playerLightTankF3 = new Image(ClassLoader.getSystemResource("unit/LightTankF3.png").toString());
		playerLightTankF4 = new Image(ClassLoader.getSystemResource("unit/LightTankF4.png").toString());
		playerLightTankF5 = new Image(ClassLoader.getSystemResource("unit/LightTankF5.png").toString());
		playerLightTankS1 = new Image(ClassLoader.getSystemResource("unit/LightTankS1.png").toString());
		playerLightTankS2 = new Image(ClassLoader.getSystemResource("unit/LightTankS2.png").toString());
		enemyLightTankR1 = new Image(ClassLoader.getSystemResource("unit/ELightTankR1.png").toString());
		enemyLightTankR2 = new Image(ClassLoader.getSystemResource("unit/ELightTankR2.png").toString());
		enemyLightTankR3 = new Image(ClassLoader.getSystemResource("unit/ELightTankR3.png").toString());
		enemyLightTankF1 = new Image(ClassLoader.getSystemResource("unit/ELightTankF1.png").toString());
		enemyLightTankF2 = new Image(ClassLoader.getSystemResource("unit/ELightTankF2.png").toString());
		enemyLightTankF3 = new Image(ClassLoader.getSystemResource("unit/ELightTankF3.png").toString());
		enemyLightTankF4 = new Image(ClassLoader.getSystemResource("unit/ELightTankF4.png").toString());
		enemyLightTankF5 = new Image(ClassLoader.getSystemResource("unit/ELightTankF5.png").toString());
		enemyLightTankS1 = new Image(ClassLoader.getSystemResource("unit/ELightTankS1.png").toString());
		enemyLightTankS2 = new Image(ClassLoader.getSystemResource("unit/ELightTankS2.png").toString());

		playerJeepR1 = new Image(ClassLoader.getSystemResource("unit/JeepR1.png").toString());
		playerJeepR2 = new Image(ClassLoader.getSystemResource("unit/JeepR2.png").toString());
		playerJeepR3 = new Image(ClassLoader.getSystemResource("unit/JeepR3.png").toString());
		playerJeepF1 = new Image(ClassLoader.getSystemResource("unit/JeepF1.png").toString());
		playerJeepF2 = new Image(ClassLoader.getSystemResource("unit/JeepF2.png").toString());
		playerJeepF3 = new Image(ClassLoader.getSystemResource("unit/JeepF3.png").toString());
		playerJeepS1 = new Image(ClassLoader.getSystemResource("unit/JeepS1.png").toString());
		playerJeepS2 = new Image(ClassLoader.getSystemResource("unit/JeepS2.png").toString());
		enemyJeepR1 = new Image(ClassLoader.getSystemResource("unit/EJeepR1.png").toString());
		enemyJeepR2 = new Image(ClassLoader.getSystemResource("unit/EJeepR2.png").toString());
		enemyJeepR3 = new Image(ClassLoader.getSystemResource("unit/EJeepR3.png").toString());
		enemyJeepF1 = new Image(ClassLoader.getSystemResource("unit/EJeepF1.png").toString());
		enemyJeepF2 = new Image(ClassLoader.getSystemResource("unit/EJeepF2.png").toString());
		enemyJeepF3 = new Image(ClassLoader.getSystemResource("unit/EJeepF3.png").toString());
		enemyJeepS1 = new Image(ClassLoader.getSystemResource("unit/EJeepS1.png").toString());
		enemyJeepS2 = new Image(ClassLoader.getSystemResource("unit/EJeepS2.png").toString());

		playerArmoredCarR1 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarR1.png").toString());
		playerArmoredCarR2 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarR2.png").toString());
		playerArmoredCarR3 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarR3.png").toString());
		playerArmoredCarF1 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarF1.png").toString());
		playerArmoredCarF2 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarF2.png").toString());
		playerArmoredCarF3 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarF3.png").toString());
		playerArmoredCarS1 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarS1.png").toString());
		playerArmoredCarS2 = new Image(ClassLoader.getSystemResource("unit/ArmoredCarS2.png").toString());
		enemyArmoredCarR1 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarR1.png").toString());
		enemyArmoredCarR2 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarR2.png").toString());
		enemyArmoredCarR3 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarR3.png").toString());
		enemyArmoredCarF1 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarF1.png").toString());
		enemyArmoredCarF2 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarF2.png").toString());
		enemyArmoredCarF3 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarF3.png").toString());
		enemyArmoredCarS1 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarS1.png").toString());
		enemyArmoredCarS2 = new Image(ClassLoader.getSystemResource("unit/EArmoredCarS2.png").toString());

		playerHowizerR1 = new Image(ClassLoader.getSystemResource("unit/HowizerR1.png").toString());
		playerHowizerR2 = new Image(ClassLoader.getSystemResource("unit/HowizerR2.png").toString());
		playerHowizerR3 = new Image(ClassLoader.getSystemResource("unit/HowizerR3.png").toString());
		playerHowizerS1 = new Image(ClassLoader.getSystemResource("unit/HowizerS1.png").toString());
		playerHowizerF1 = new Image(ClassLoader.getSystemResource("unit/HowizerF1.png").toString());
		playerHowizerF2 = new Image(ClassLoader.getSystemResource("unit/HowizerF2.png").toString());
		playerHowizerF3 = new Image(ClassLoader.getSystemResource("unit/HowizerF3.png").toString());
		playerHowizerF4 = new Image(ClassLoader.getSystemResource("unit/HowizerF4.png").toString());
		playerHowizerF5 = new Image(ClassLoader.getSystemResource("unit/HowizerF5.png").toString());
		playerHowizerF6 = new Image(ClassLoader.getSystemResource("unit/HowizerF6.png").toString());
		enemyHowizerR1 = new Image(ClassLoader.getSystemResource("unit/EHowizerR1.png").toString());
		enemyHowizerR2 = new Image(ClassLoader.getSystemResource("unit/EHowizerR2.png").toString());
		enemyHowizerR3 = new Image(ClassLoader.getSystemResource("unit/EHowizerR3.png").toString());
		enemyHowizerS1 = new Image(ClassLoader.getSystemResource("unit/EHowizerS1.png").toString());
		enemyHowizerF1 = new Image(ClassLoader.getSystemResource("unit/EHowizerF1.png").toString());
		enemyHowizerF2 = new Image(ClassLoader.getSystemResource("unit/EHowizerF2.png").toString());
		enemyHowizerF3 = new Image(ClassLoader.getSystemResource("unit/EHowizerF3.png").toString());
		enemyHowizerF4 = new Image(ClassLoader.getSystemResource("unit/EHowizerF4.png").toString());
		enemyHowizerF5 = new Image(ClassLoader.getSystemResource("unit/EHowizerF5.png").toString());
		enemyHowizerF6 = new Image(ClassLoader.getSystemResource("unit/EHowizerF6.png").toString());

		gameEndWallpaper = new Image(ClassLoader.getSystemResource("main/gameEndWallpaper.jpg").toString());
		homeIcon = new Image(ClassLoader.getSystemResource("main/homeIcon.jpg").toString());
		blackHomeIcon = new Image(ClassLoader.getSystemResource("main/blackHomeIcon.png").toString());
		restartIcon = new Image(ClassLoader.getSystemResource("main/restartIcon.png").toString());
		backButton = new Image(ClassLoader.getSystemResource("main/backButton.png").toString());
		nextButton = new Image(ClassLoader.getSystemResource("main/nextButton.png").toString());
		gameScreenBackground = new Image(ClassLoader.getSystemResource("main/background.png").toString());

		artilleryExplode1 = new Image(ClassLoader.getSystemResource("effect/explode1.png").toString());
		artilleryExplode2 = new Image(ClassLoader.getSystemResource("effect/explode2.png").toString());
		artilleryExplode3 = new Image(ClassLoader.getSystemResource("effect/explode3.png").toString());
		artilleryExplode4 = new Image(ClassLoader.getSystemResource("effect/explode4.png").toString());
		artilleryExplode5 = new Image(ClassLoader.getSystemResource("effect/explode5.png").toString());

		bulletShot1 = new Image(ClassLoader.getSystemResource("effect/shot1.png").toString());
		bulletShot2 = new Image(ClassLoader.getSystemResource("effect/shot2.png").toString());
		bulletShot3 = new Image(ClassLoader.getSystemResource("effect/shot3.png").toString());
		bulletShot4 = new Image(ClassLoader.getSystemResource("effect/shot4.png").toString());
		bulletShot5 = new Image(ClassLoader.getSystemResource("effect/shot5.png").toString());
		bulletShot6 = new Image(ClassLoader.getSystemResource("effect/shot6.png").toString());
		bulletShot7 = new Image(ClassLoader.getSystemResource("effect/shot7.png").toString());
		bulletShot8 = new Image(ClassLoader.getSystemResource("effect/shot8.png").toString());

		// audio
		enterGameStage = new AudioClip(ClassLoader.getSystemResource("audio/enterGameStage.wav").toString());
		gunShootingSound = new AudioClip(ClassLoader.getSystemResource("audio/gunShootingSound.wav").toString());
		gunShootingSound2 = new AudioClip(ClassLoader.getSystemResource("audio/gunShootingSound2.wav").toString());
		tankShoot1 = new AudioClip(ClassLoader.getSystemResource("audio/tankShoot1.wav").toString());
		tankShoot2 = new AudioClip(ClassLoader.getSystemResource("audio/tankShoot2.wav").toString());
		howitzerShootingSound = new AudioClip(ClassLoader.getSystemResource("audio/howitzerShootingSound.wav").toString());
		explodeSound = new AudioClip(ClassLoader.getSystemResource("audio/explodeSound.wav").toString());
		
		// test
		weedyTest = new Image(ClassLoader.getSystemResource("audio/weedyTest.jpg").toString());
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void clear() {
		entities = new ArrayList<IRenderable>();
	}

	public void update() {
		Collections.sort(entities, comparator);
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed() || !entities.get(i).isVisible())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

}
