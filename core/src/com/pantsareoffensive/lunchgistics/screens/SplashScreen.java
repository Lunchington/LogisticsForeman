package com.pantsareoffensive.lunchgistics.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.screens.menus.MenuScreen;

public class SplashScreen extends AbstractScreen {

    private Image splashImage;

    public SplashScreen(Application game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        // start playing the menu music

        // retrieve the splash image's region from the atlas

        // here we create the splash image actor; its size is set when the
        // resize() method gets called
        splashImage = new Image(new Texture(Gdx.files.internal("pafSplash.png")));
        splashImage.setFillParent(true);

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent
        splashImage.getColor().a = 0f;

        // configure the fade-in/out effect on the splash image
        splashImage.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f), new Action() {
            @Override
            public boolean act(float delta) {
                // the last action will move to the next screen
                app.setScreen(new MenuScreen(app));
                return true;
            }
        }));

        // and finally we add the actor to the stage
        stage.addActor(splashImage);
    }

    @Override
    public void render(float _delta) {
        super.render(_delta);
        renderTable();
    }

}
