package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

import com.pantsareoffensive.lunchgistics.managers.ScreenManager;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;

public class LogisticsForeman extends Game {
	public static boolean DEV_MODE = false;

    public static boolean running = false;

	private FPSLogger fpsLogger;

	public LogisticsForeman() {}

	public void create() {

		MusicManager.getInstance().setVolume(PreferencesManager.getInstance().getMusicVolume());
        MusicManager.getInstance().setEnabled(PreferencesManager.getInstance().isMusicEnabled());

		SoundManager.getInstance().setVolume(PreferencesManager.getInstance().getSoundVolume());
        SoundManager.getInstance().setEnabled(PreferencesManager.getInstance().isSoundEnabled());

        ScreenManager.getInstance().init(this);

		fpsLogger = new FPSLogger();

		RandomNames.init();

        ScreenManager.getInstance().show(ScreenManager.GameScreens.SPLASH)
;	}

    @Override
	public void dispose() {
		super.dispose();
        MusicManager.getInstance().dispose();
        SoundManager.getInstance().dispose();

	    ScreenManager.getInstance().dispose();
	}

	public static void toggleDevMode() {
		DEV_MODE = !DEV_MODE;
	}




}
