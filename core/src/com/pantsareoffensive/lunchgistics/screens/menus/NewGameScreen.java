package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.gui.DefaultInputListener;
import com.pantsareoffensive.lunchgistics.systems.SoundManager.GameSound;

public class NewGameScreen extends BaseMenuScreen {

    public NewGameScreen(Application _game) {
        super(_game);
        Table table = super.getTable();
        table.defaults().spaceBottom(10).width(300).height(45);

        // back to Main
        TextButton backButton = new TextButton("Back to main menu", getSkin());
        backButton.addListener(new DefaultInputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.getSoundManager().play(GameSound.CLICK);
                app.setScreen(app.menuScreen);

            }
        });
        table.row();
        table.add(backButton);
    }

    @Override
    public void show() {
        super.show();

    }
}
