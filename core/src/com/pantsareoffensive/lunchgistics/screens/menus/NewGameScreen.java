package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager.STATE;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;

public class NewGameScreen extends BaseMenuScreen {


    public NewGameScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        TextButton newWorld = new TextButton("New World", skin);
        newWorld.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.soundManager.play(SoundManager.GameSound.CLICK);
                game.screenManager.dispose(STATE.GAME);
                game.screenManager.setScreen(STATE.GAME);
            }
        });
        table.add(newWorld);

        table.row();

        TextButton backButton = new TextButton("Back to main menu", skin);
        backButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.soundManager.play(SoundManager.GameSound.CLICK);
                game.screenManager.setScreen(STATE.MAIN_MENU);

            }
        });
        table.row();
        table.add(backButton);
    }

}
