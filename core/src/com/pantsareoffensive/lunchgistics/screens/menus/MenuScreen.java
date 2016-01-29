package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;


public class MenuScreen extends BaseMenuScreen {


    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        if (LogisticsForeman.running) {
            TextButton testButton = new TextButton("Return to game", skin);
            testButton.addListener(new MenuButton() {

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    super.touchUp(event, x, y, pointer, button);
                    ScreenManager.getInstance().show(ScreenManager.GameScreens.GAME);
                }
            });
            table.add(testButton);
            table.row();
        }

        TextButton newGameButton = new TextButton("New game", skin);
        newGameButton.addListener(new MenuButton() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                ScreenManager.getInstance().show(ScreenManager.GameScreens.NEW_GAME);
            }
        });
        table.add(newGameButton);
        table.row();

        TextButton loadGameButton = new TextButton("Load Game", skin);
        table.add(loadGameButton);
        table.row();

        TextButton optionsButton = new TextButton("Options", skin);
        optionsButton.addListener(new MenuButton() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                ScreenManager.getInstance().show(ScreenManager.GameScreens.OPTIONS);
            }
        });
        table.add(optionsButton);
        table.row();

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.addListener(new MenuButton() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.exit();
            }
        });
        table.add(exitButton);

    }

}
