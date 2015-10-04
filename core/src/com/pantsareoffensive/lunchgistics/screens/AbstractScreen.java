package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pantsareoffensive.lunchgistics.Application;


public abstract class AbstractScreen implements Screen {
    public InputMultiplexer inputMultiplexer = new InputMultiplexer();

    protected final Application app;
    protected final Stage stage;

    private Skin skin;
    private TextureAtlas atlas;
    private Table table;


    public AbstractScreen(Application app) {
        this.app = app;
        this.stage = new Stage();

        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    public TextureAtlas getAtlas() {
        if (atlas == null) {
            atlas = new TextureAtlas(Gdx.files.internal("gui/gui.atlas"));
        }
        return atlas;
    }


    protected boolean isGameScreen() {
        return false;
    }

    protected String getName() {
        return getClass().getSimpleName();
    }

    protected Skin getSkin() {
        if (skin == null) {
            FileHandle skinFile = Gdx.files.internal("gui/gui.json");
            skin = new Skin(skinFile);
        }
        return skin;
    }

    protected Table getTable() {
        if (table == null) {
            table = new Table(getSkin());
            table.setFillParent(true);


            stage.addActor(table);
        }
        return table;
    }

    @Override
    public void render(float _delta) {
        stage.act(_delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getTable().setDebug(false);


        if (Application.DEV_MODE) {
            getTable().setDebug(true);
            getTable().debug();
        }


    }

    public void renderTable() {

        stage.draw();
    }



    @Override
    public void show() {
        inputMultiplexer.addProcessor(stage);

    }

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(Application.LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
        stage.getViewport().update(width, height, true);


    }

    @Override
    public void dispose() {
        app.batch.dispose();

    }

}
