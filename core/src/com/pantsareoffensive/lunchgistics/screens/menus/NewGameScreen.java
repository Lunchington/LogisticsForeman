package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;

public class NewGameScreen extends BaseMenuScreen {


    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        TextButton newWorld = new TextButton("New World", skin);
        newWorld.addListener(new MenuButton() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                ScreenManager.getInstance().dispose(ScreenManager.GameScreens.GAME);
                ScreenManager.getInstance().show(ScreenManager.GameScreens.GAME);
            }
        });
        table.add(newWorld);

        table.row();

        TextButton backButton = new TextButton("Back to main menu", skin);
        backButton.addListener(new MenuButton() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                ScreenManager.getInstance().show(ScreenManager.GameScreens.MAIN_MENU);

            }
        });
        table.row();
        table.add(backButton);
    }

}
