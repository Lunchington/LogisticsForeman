package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.controllers.GamePlayController;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.input.CameraScroll;
import com.pantsareoffensive.lunchgistics.input.GameInput;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.map.GameWorld;



public class GamePlayScreen implements Screen {
    private LogisticsForeman app;

    private Stage hudArea;
    private Stage gamePlayArea;
    private Engine engine;

    private CameraScroll cameraScroll;

    public GamePlayScreen(LogisticsForeman app) {
        this.app = app;
        Global.Art.init();

        hudArea = new Stage(new FitViewport(Global.WIDTH, Global.HEIGHT));
        gamePlayArea = new Stage(new FitViewport(Global.WIDTH, Global.HEIGHT));

        engine = new Engine();


        GameWorld gworld = new GameWorld();
        GameWorld.init(gworld);

        cameraScroll = new CameraScroll(gamePlayArea.getCamera());

        engine.addEntityListener(HudController.init(app, hudArea));
        engine.addEntityListener(new GamePlayController(gamePlayArea));
        LogisticsForeman.running = true;

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(gamePlayArea, cameraScroll,new GameInput(app,gamePlayArea),hudArea));

        if(LogisticsForeman.preferencesManager.isMusicEnabled())
            LogisticsForeman.musicManager.play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cameraScroll.update(delta);

        engine.update(delta);

        gamePlayArea.act(delta);
        hudArea.draw();

        gamePlayArea.draw();
        hudArea.draw();


    }

    @Override
    public void resize(int width, int height) {
        gamePlayArea.getViewport().update(width,height,false);
        hudArea.getViewport().update(width,height,false);
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
        LogisticsForeman.running = false;
        gamePlayArea.dispose();
        hudArea.dispose();
        Global.Art.dispose();

    }

}
