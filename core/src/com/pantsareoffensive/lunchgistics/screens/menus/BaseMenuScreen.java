package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.MusicManager;
import com.pantsareoffensive.lunchgistics.screens.AbstractScreen;


public class BaseMenuScreen extends AbstractScreen {

    public Table table;
    public Skin skin;

    public BaseMenuScreen(Main game) {
        super(game);
        skin = new Skin(Gdx.files.internal("gui/gui.json"));
        table = new Table(skin);
        table.setFillParent(true);
        stage.addActor(table);

    }

    @Override
    public void show() {
        super.show();
        table.clear();
        Drawable splashDrawable =  new Image(new Texture(Gdx.files.internal("logo.png"))).getDrawable();
        table.setBackground(splashDrawable);
        if (game.preferencesManager.isMusicEnabled()) {
            game.musicManager.play(MusicManager.GameMusic.MENU);
        }

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
        super.dispose();
    }
}