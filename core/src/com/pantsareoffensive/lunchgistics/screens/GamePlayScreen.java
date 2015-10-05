package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;
import com.pantsareoffensive.lunchgistics.map.GameWorld;


public class GamePlayScreen implements Screen {
    private LogisticsForeman app;

    private Stage hudStage;
    private Stage gamePlayArea;
    private Engine engine;

    public GamePlayScreen(LogisticsForeman app) {
        this.app = app;

        hudStage = new Stage(new ScreenViewport());
        gamePlayArea = new Stage(new ScreenViewport());
        engine = new Engine();

        GameWorld gworld = new GameWorld(new GameMap());
        GameWorld.init(gworld);

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(gamePlayArea));

        if(LogisticsForeman.preferencesManager.isMusicEnabled())
            LogisticsForeman.musicManager.play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
