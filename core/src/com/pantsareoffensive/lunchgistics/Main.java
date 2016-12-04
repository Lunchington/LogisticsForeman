package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pantsareoffensive.lunchgistics.managers.*;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;

public class Main extends Game {
    public static boolean DEV_MODE = false;

    public ScreenManager screenManager;
    public static ArtManager assetManager;

    public MusicManager musicManager;
    public SoundManager soundManager;
    public PreferencesManager preferencesManager;

    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;

    public Main() {}

    public void create() {

        batch = new SpriteBatch();
        shapeRenderer =  new ShapeRenderer();

        assetManager = new ArtManager();
        assetManager.load();

        musicManager = new MusicManager();
        soundManager = new SoundManager();
        preferencesManager = new PreferencesManager();


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

    public static ArtManager getAssetManager() { return assetManager; }



}
