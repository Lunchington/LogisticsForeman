package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.screens.SplashScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.MenuScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.NewGameScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.OptionsScreen;
import com.pantsareoffensive.lunchgistics.systems.MusicManager;
import com.pantsareoffensive.lunchgistics.systems.PreferencesManager;
import com.pantsareoffensive.lunchgistics.systems.SoundManager;

public class Application extends Game {
	public static final String LOG = Application.class.getSimpleName();
	public static boolean DEV_MODE = false;

    public static  final String TITLE = "Lunchgistics";
    public  static final String VERSION ="1.0 pre alpha";
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public OrthographicCamera camera;
    public SpriteBatch batch;
    public BitmapFont font;

	private PreferencesManager preferencesManager;
	private MusicManager musicManager;
	private SoundManager soundManager;

	public GamePlayScreen gameplayScreen;
	public SplashScreen splashScreen;
	public MenuScreen menuScreen;
	public OptionsScreen optionsScreen;
	public NewGameScreen newgameScreen;

	private FPSLogger fpsLogger;

	public Application() {}

	public void create() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false,Application.WIDTH,Application.HEIGHT);
        batch = new SpriteBatch();
        font = new BitmapFont();

		Gdx.app.log(Application.LOG, "Creating game on " + Gdx.app.getType());

		preferencesManager = new PreferencesManager();

		musicManager = new MusicManager();
		musicManager.setVolume(preferencesManager.getMusicVolume());
		musicManager.setEnabled(preferencesManager.isMusicEnabled());

		soundManager = new SoundManager();
		soundManager.setVolume(preferencesManager.getSoundVolume());
		soundManager.setEnabled(preferencesManager.isSoundEnabled());

		gameplayScreen = new GamePlayScreen(this);
		splashScreen = new SplashScreen(this);
		menuScreen = new MenuScreen(this);
		optionsScreen = new OptionsScreen(this);
		newgameScreen = new NewGameScreen(this);

		fpsLogger = new FPSLogger();

		setScreen(splashScreen);
	}

	@Override
	public void render() {
		super.render();

		if (Gdx.input.isKeyJustPressed(Input.Keys.F1))
			toggleDevMode();

		// output the current FPS
		if (DEV_MODE) fpsLogger.log();
	}

	@Override
	public void pause() {
		super.pause();
		Gdx.app.log(Application.LOG, "Pausing game");

	}

	@Override
	public void resume() {
		super.resume();
		Gdx.app.log(Application.LOG, "Resuming game");
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
		Gdx.app.log(Application.LOG, "Setting screen: " + screen.getClass().getSimpleName());
	}
    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
        camera.setToOrtho(false, width, height);
    }

    @Override
	public void dispose() {
		super.dispose();
		Gdx.app.log(Application.LOG, "Disposing game");

		musicManager.dispose();
		soundManager.dispose();

	}

	public static void toggleDevMode() {
		DEV_MODE = !DEV_MODE;
	}


	public PreferencesManager getPreferencesManager() {
		return preferencesManager;
	}
	public MusicManager getMusicManager() {
		return musicManager;
	}
	public SoundManager getSoundManager()
	{
		return soundManager;
	}

}
