package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.gui.DefaultInputListener;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.systems.SoundManager.GameSound;


public class MenuScreen extends BaseMenuScreen {

    public MenuScreen(Application _game) {
        super(_game);
    }

    @Override
    public void show() {
        super.show();
        Table table = super.getTable();

        table.defaults().spaceBottom(10).width(300).height(45);

        TextButton newGameButton = new TextButton("New game", getSkin());
        newGameButton.addListener(new DefaultInputListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.getSoundManager().play(GameSound.CLICK);
                app.getMusicManager().stop();
                app.setScreen(new GamePlayScreen(app));

            }
        });
        table.add(newGameButton).padTop(50);
        table.row();

        TextButton loadGameButton = new TextButton("Load Game", getSkin());
        table.add(loadGameButton);
        table.row();

        TextButton optionsButton = new TextButton("Options", getSkin());
        optionsButton.addListener(new DefaultInputListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.getSoundManager().play(GameSound.CLICK);
                app.setScreen(new OptionsScreen(app));

            }
        });
        table.add(optionsButton);
        table.row();

        TextButton exitButton = new TextButton("Exit", getSkin());
        exitButton.addListener(new DefaultInputListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.getSoundManager().play(GameSound.CLICK);
                Gdx.app.exit();
            }
        });
        table.add(exitButton);

    }

}
