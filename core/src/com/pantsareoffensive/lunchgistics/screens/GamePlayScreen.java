package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.controllers.GamePlayController;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.input.CameraScroll;
import com.pantsareoffensive.lunchgistics.input.GameInput;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;
import com.pantsareoffensive.lunchgistics.view.SkidActor;
import com.pantsareoffensive.lunchgistics.view.WorkerActor;


public class GamePlayScreen implements Screen {

    private GameMap world;

    private Stage hudArea;
    private Stage gamePlayArea;
    private Engine engine;

    private CameraScroll cameraScroll;
    private GameInput gameInput;


    private BitmapFont font;
    private SpriteBatch batch;

    public GamePlayScreen() {
        font = new BitmapFont();
        batch = new SpriteBatch();

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Global.WIDTH, Global.HEIGHT);

        hudArea = new Stage(new StretchViewport(Global.WIDTH, Global.HEIGHT));
        gamePlayArea = new Stage(new StretchViewport(Global.WIDTH, Global.HEIGHT, camera));

        engine = new Engine();

        world = new GameMap(camera);
        cameraScroll = new CameraScroll(camera);

        gameInput = new GameInput(gamePlayArea);

        HudController.getInstance().init(hudArea);
        GamePlayController.getInstance().init(gamePlayArea);

        engine.addEntityListener(HudController.getInstance());
        engine.addEntityListener(GamePlayController.getInstance());

        LogisticsForeman.running = true;

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(gamePlayArea, cameraScroll, gameInput, hudArea));

        if(PreferencesManager.getInstance().isMusicEnabled())
            MusicManager.getInstance().play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraScroll.update(delta);
        engine.update(delta);
        world.update(delta);

        gamePlayArea.act(delta);
        hudArea.act(delta);

        batch.begin();

        world.render(batch);

        batch.setProjectionMatrix(hudArea.getCamera().combined);

        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);

        batch.end();


        gamePlayArea.draw();
        hudArea.draw();

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

    }

    public void addtoEngine(WorkerActor e) {
        gamePlayArea.addActor(e);
        engine.addEntity(e.getEntity());
    }

    public void addtoEngine(SkidActor e) {
        gamePlayArea.addActor(e);
        engine.addEntity(e.getEntity());
    }

}
