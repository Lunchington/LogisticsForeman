package com.pantsareoffensive.lunchgistics;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.screens.SplashScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.MenuScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.NewGameScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.OptionsScreen;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;

public class LogisticsForeman extends Game {
	public static boolean DEV_MODE = false;

	public static PreferencesManager preferencesManager;
	public static MusicManager musicManager;
	public static SoundManager soundManager;

	public GamePlayScreen gameplayScreen;
	public SplashScreen splashScreen;
	public MenuScreen menuScreen;
	public OptionsScreen optionsScreen;
	public NewGameScreen newgameScreen;

	private FPSLogger fpsLogger;

	public LogisticsForeman() {}

	public void create() {

		preferencesManager = new PreferencesManager();

		musicManager = new MusicManager();
		musicManager.setVolume(preferencesManager.getMusicVolume());
		musicManager.setEnabled(preferencesManager.isMusicEnabled());

		soundManager = new SoundManager();
		soundManager.setVolume(preferencesManager.getSoundVolume());
		soundManager.setEnabled(preferencesManager.isSoundEnabled());


		fpsLogger = new FPSLogger();

		splashScreen = new SplashScreen(this);
		menuScreen = new MenuScreen(this);
		gameplayScreen = new GamePlayScreen(this);
		newgameScreen = new NewGameScreen(this);
		 optionsScreen = new OptionsScreen(this);

		setScreen(splashScreen);
	}

    @Override
	public void dispose() {
		super.dispose();
		musicManager.dispose();
		soundManager.dispose();

		splashScreen.dispose();
		menuScreen.dispose();
		gameplayScreen.dispose();
		newgameScreen.dispose();
		optionsScreen.dispose();
	}

	public static void toggleDevMode() {
		DEV_MODE = !DEV_MODE;
	}


}
