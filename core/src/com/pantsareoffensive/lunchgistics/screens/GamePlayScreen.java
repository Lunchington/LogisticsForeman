package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.*;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.input.CameraScroll;
import com.pantsareoffensive.lunchgistics.input.GameInput;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;



public class GamePlayScreen implements Screen {

    private GameMap world;

    private Stage hudArea;

    private CameraScroll cameraScroll;
    private GameInput gameInput;

    private BitmapFont font;
    private SpriteBatch batch;
    private ShapeRenderer selectionBox = new ShapeRenderer();


    private OrthographicCamera gameCamera;
    private Viewport viewport;

    public GamePlayScreen() {
        font = new BitmapFont();
        batch = new SpriteBatch();

        gameCamera = new OrthographicCamera();
        viewport = new ScreenViewport(gameCamera);

        hudArea = new Stage(new ScreenViewport());

        world = new GameMap(viewport);
        gameInput = new GameInput(world);
        cameraScroll = new CameraScroll(world,gameInput);

        HudController.getInstance().init(hudArea);

        gameCamera.setToOrtho(false, Global.WIDTH, Global.HEIGHT);

        LogisticsForeman.running = true;
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(cameraScroll, gameInput, hudArea));
        if(PreferencesManager.getInstance().isMusicEnabled())
            MusicManager.getInstance().play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraScroll.update(delta);
        world.update(delta);
        hudArea.act(delta);

        batch.begin();
            batch.setProjectionMatrix(gameCamera.combined);
            world.render(batch);

        batch.end();

        drawSelection();

        hudArea.draw();


    }

    @Override
    public void resize(int width, int height) {
        hudArea.getViewport().update(width, height, true);
        HudController.getInstance().update();
        viewport.update(width, height);

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
        hudArea.dispose();

    }

    private void drawSelection() {
        if (gameInput.getClicked() != null) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

            selectionBox.setProjectionMatrix(gameCamera.combined);

            selectionBox.begin(ShapeRenderer.ShapeType.Filled);
            selectionBox.setColor(new Color((float)53/255, (float)125/255, (float)173/255, 0.5f));

            Rectangle rec = gameInput.getClickRect();
            selectionBox.rect(
                    rec.x,
                    rec.y,
                    rec.width,
                    rec.height
            );

            selectionBox.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);

        }
    }

}
