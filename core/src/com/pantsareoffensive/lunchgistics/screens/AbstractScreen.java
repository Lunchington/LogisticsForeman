package com.pantsareoffensive.lunchgistics.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;

public abstract class AbstractScreen implements Screen {
    protected final Main game;

    public AbstractScreen(Main game) {
        this.game = game;
    }
    
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
