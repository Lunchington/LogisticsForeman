package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
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

    private GameWorld world;

    private Stage hudArea;
    private Stage gamePlayArea;
    private Engine engine;

    private CameraScroll cameraScroll;
    private GameInput gameInput;

    private OrthographicCamera camera;

    private BitmapFont font;
    private SpriteBatch batch;

    public GamePlayScreen(LogisticsForeman app) {
        this.app = app;
        font = new BitmapFont();
        batch = new SpriteBatch();

        Global.Art.init();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Global.WIDTH, Global.HEIGHT);

        hudArea = new Stage(new StretchViewport(Global.WIDTH, Global.HEIGHT));
        gamePlayArea = new Stage(new StretchViewport(Global.WIDTH, Global.HEIGHT,camera));

        engine = new Engine();

        world = new GameWorld(camera);
        cameraScroll = new CameraScroll(camera);

        gameInput = new GameInput(app,gamePlayArea);

        engine.addEntityListener(HudController.init(hudArea));
        engine.addEntityListener(new GamePlayController(gamePlayArea));
        LogisticsForeman.running = true;

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(gamePlayArea, cameraScroll, gameInput, hudArea));

        if(app.preferencesManager.isMusicEnabled())
            app.musicManager.play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraScroll.update(delta);
        engine.update(delta);
        gamePlayArea.act(delta);
        hudArea.act(delta);

        world.update(delta);

        world.render();
        gamePlayArea.draw();
        hudArea.draw();

        batch.begin();
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        gamePlayArea.getViewport().update(width, height, false);
        hudArea.getViewport().update(width, height, false);
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

    public void addtoEngine(Entity e) {
        engine.addEntity(e);
    }

}
