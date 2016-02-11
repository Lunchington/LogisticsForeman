package com.pantsareoffensive.lunchgistics.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager.STATE;

public class SplashScreen extends AbstractScreen {


    public SplashScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {

        Image splashImage = new Image(new Texture(Gdx.files.internal("pafSplash.png")));
        splashImage.setFillParent(true);

        splashImage.getColor().a = 0f;

        splashImage.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f), new Action() {
            @Override
            public boolean act(float delta) {
                game.screenManager.setScreen(STATE.MAIN_MENU);
                return true;
            }
        }));
        stage.addActor(splashImage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);

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
