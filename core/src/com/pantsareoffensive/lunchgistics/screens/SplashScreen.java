package com.pantsareoffensive.lunchgistics.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;

public class SplashScreen implements Screen {

    private Image splashImage;
    private Stage stage;


    public SplashScreen() {
        stage = new Stage();
    }

    @Override
    public void show() {

        splashImage = new Image(new Texture(Gdx.files.internal("pafSplash.png")));
        splashImage.setFillParent(true);

        splashImage.getColor().a = 0f;

        splashImage.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f), new Action() {
            @Override
            public boolean act(float delta) {
                ScreenManager.getInstance().show(ScreenManager.GameScreens.MAIN_MENU);
                return true;
            }
        }));
        stage.addActor(splashImage);
    }

    @Override
    public void render(float _delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
