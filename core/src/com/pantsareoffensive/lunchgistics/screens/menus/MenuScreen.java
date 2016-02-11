package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager.STATE;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;


public class MenuScreen extends BaseMenuScreen {


    public MenuScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        if (game.screenManager.isScreen(STATE.GAME)) {
            TextButton testButton = new TextButton("Return to game", skin);
            testButton.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    super.touchUp(event, x, y, pointer, button);
                    game.soundManager.play(SoundManager.GameSound.CLICK);
                    game.screenManager.setScreen(STATE.GAME);
                }
            });
            table.add(testButton);
            table.row();
        }

        TextButton newGameButton = new TextButton("New game", skin);
        newGameButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.soundManager.play(SoundManager.GameSound.CLICK);
                game.screenManager.setScreen(STATE.NEW_GAME);
            }
        });
        table.add(newGameButton);
        table.row();

        TextButton loadGameButton = new TextButton("Load Game", skin);
        table.add(loadGameButton);
        table.row();

        TextButton optionsButton = new TextButton("Options", skin);
        optionsButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.soundManager.play(SoundManager.GameSound.CLICK);
                game.screenManager.setScreen(STATE.OPTIONS);
            }
        });
        table.add(optionsButton);
        table.row();

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                game.soundManager.play(SoundManager.GameSound.CLICK);
                Gdx.app.exit();
            }
        });
        table.add(exitButton);

    }

}
