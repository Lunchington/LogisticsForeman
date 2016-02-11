package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;

public class Main extends Game {
    public static boolean DEV_MODE = false;

    public ScreenManager screenManager;
    public AssetManager assetManager;

    public MusicManager musicManager;
    public SoundManager soundManager;
    public PreferencesManager preferencesManager;

    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;

    public Main() {}

    public void create() {
        batch = new SpriteBatch();
        shapeRenderer =  new ShapeRenderer();

        musicManager = new MusicManager();
        soundManager = new SoundManager();
        preferencesManager = new PreferencesManager();

        assetManager = new AssetManager();

        musicManager.setVolume(preferencesManager.getMusicVolume());
        musicManager.setEnabled(preferencesManager.isMusicEnabled());

        soundManager.setVolume(preferencesManager.getSoundVolume());
        soundManager.setEnabled(preferencesManager.isSoundEnabled());

        screenManager = new ScreenManager(this);

        RandomNames.init();

    }

    @Override
    public void dispose() {
        super.dispose();

        musicManager.dispose();
        soundManager.dispose();

        batch.dispose();
        shapeRenderer.dispose();
        screenManager.dispose();
        assetManager.dispose();

    }

    public void toggleDevMode() {
        DEV_MODE = !DEV_MODE;
    }




}
