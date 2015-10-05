package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;


public class BaseMenuScreen implements Screen {

    public LogisticsForeman app;
    public Table table;
    public Stage stage;
    public Skin skin;
    public TextureAtlas atlas;

    public BaseMenuScreen(LogisticsForeman app) {
        this.app  = app;
        stage = new Stage();

        skin = new Skin(Gdx.files.internal("gui/gui.json"));
        table = new Table(skin);
        table.setFillParent(true);
        stage.addActor(table);
        atlas = new TextureAtlas(Gdx.files.internal("gui/gui.atlas"));

    }

    @Override
    public void show() {
        table.clear();
        Gdx.input.setInputProcessor(stage);
        Drawable splashDrawable =  new Image(new Texture(Gdx.files.internal("logo.png"))).getDrawable();
        table.setBackground(splashDrawable);
        if (LogisticsForeman.preferencesManager.isMusicEnabled()) {
            LogisticsForeman.musicManager.play(MusicManager.GameMusic.MENU);
        }

    }

    @Override
    public void render(float _delta) {

        stage.act();
        stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

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
