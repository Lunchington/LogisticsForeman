package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.SoundManager.GameSound;

public class NewGameScreen extends BaseMenuScreen {

    public NewGameScreen(LogisticsForeman app) {  super(app); }

    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);


        TextButton testButton = new TextButton("TEST WORLD", skin);
        testButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                LogisticsForeman.soundManager.play(GameSound.CLICK);
                app.setScreen(app.gameplayScreen);
            }
        });
        table.add(testButton);

        table.row();

        // back to Main
        TextButton backButton = new TextButton("Back to main menu", skin);
        backButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                LogisticsForeman.soundManager.play(GameSound.CLICK);
                app.setScreen(app.menuScreen);

            }
        });
        table.row();
        table.add(backButton);
    }

}
