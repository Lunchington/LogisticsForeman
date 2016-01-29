package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.managers.PreferencesManager;


public class BaseMenuScreen implements Screen {

    public Table table;
    public Stage stage;
    public Skin skin;

    public BaseMenuScreen() {
        stage = new Stage();

        skin = new Skin(Gdx.files.internal("gui/gui.json"));
        table = new Table(skin);
        table.setFillParent(true);
        stage.addActor(table);

    }

    @Override
    public void show() {
        table.clear();
        Gdx.input.setInputProcessor(stage);
        Drawable splashDrawable =  new Image(new Texture(Gdx.files.internal("logo.png"))).getDrawable();
        table.setBackground(splashDrawable);
        if (PreferencesManager.getInstance().isMusicEnabled()) {
            MusicManager.getInstance().play(MusicManager.GameMusic.MENU);
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