package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;


public class MenuScreen extends BaseMenuScreen {


    public MenuScreen(LogisticsForeman app) {

        super(app);
    }

    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        if (LogisticsForeman.running) {
            TextButton testButton = new TextButton("Return to game", skin);
            testButton.addListener(new MenuButton(app) {

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    super.touchUp(event, x, y, pointer, button);
                    app.setScreen(app.gameplayScreen);
                }
            });
            table.add(testButton);
            table.row();
        }

        TextButton newGameButton = new TextButton("New game", skin);
        newGameButton.addListener(new MenuButton(app) {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.setScreen(app.newgameScreen);
            }
        });
        table.add(newGameButton);
        table.row();

        TextButton loadGameButton = new TextButton("Load Game", skin);
        table.add(loadGameButton);
        table.row();

        TextButton optionsButton = new TextButton("Options", skin);
        optionsButton.addListener(new MenuButton(app) {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.setScreen(app.optionsScreen);
            }
        });
        table.add(optionsButton);
        table.row();

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.addListener(new MenuButton(app) {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.exit();
            }
        });
        table.add(exitButton);

    }

}
