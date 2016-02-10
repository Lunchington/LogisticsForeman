package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.*;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.input.CameraScroll;
import com.pantsareoffensive.lunchgistics.input.GameInput;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;

public class GamePlayScreen extends AbstractScreen {

    private GameMap world;

    private HudController hudController;
    private Stage hudArea;

    private CameraScroll cameraScroll;
    private GameInput gameInput;

    private OrthographicCamera gameCamera;
    private Viewport viewport;

    public GamePlayScreen(Main game) {
        super(game);

        gameCamera = new OrthographicCamera();
        viewport = new ScreenViewport(gameCamera);

        hudArea = new Stage(new ScreenViewport());
        hudController = new HudController(hudArea);

        world = new GameMap(viewport);
        gameInput = new GameInput(game,this);
        cameraScroll = new CameraScroll(world,gameInput);


        gameCamera.setToOrtho(false, Global.WIDTH, Global.HEIGHT);
    }

    public GameMap getWorld() { return world; }
    public HudController getHud(){ return hudController; }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputMultiplexer(cameraScroll, gameInput, hudArea));

        if(game.preferencesManager.isMusicEnabled())
            game.musicManager.play(MusicManager.GameMusic.GAME);
    }

    @Override
    public void render(float delta) {

        hudArea.setDebugAll(Main.DEV_MODE);

        super.render(delta);

        cameraScroll.update(delta);
        world.update(delta);
        hudArea.act(delta);

        game.batch.begin();
            game.batch.setProjectionMatrix(gameCamera.combined);
            world.render(game.batch);

        game.batch.end();

        drawSelection();

        hudArea.draw();


    }

    private void drawSelection() {
        if (gameInput.getClicked() != null) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

            game.shapeRenderer.setProjectionMatrix(gameCamera.combined);

            game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            game.shapeRenderer.setColor(new Color((float)53/255, (float)125/255, (float)173/255, 0.5f));

            Rectangle rec = gameInput.getClickRect();
            game.shapeRenderer.rect(
                    rec.x,
                    rec.y,
                    rec.width,
                    rec.height
            );

            game.shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);

        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        hudArea.getViewport().update(width, height, true);

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
        hudArea.dispose();
    }

}
