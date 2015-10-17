package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;

public class NewGameScreen extends BaseMenuScreen {

    public NewGameScreen(LogisticsForeman app) {  super(app); }

    @Override
    public void show() {
        super.show();
        table.defaults().spaceBottom(10).width(300).height(45);

        TextButton newWorld = new TextButton("New World", skin);
        newWorld.addListener(new MenuButton(app) {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.gameplayScreen = new GamePlayScreen(app);
                app.setScreen(app.gameplayScreen);
            }
        });
        table.add(newWorld);

        table.row();

        TextButton backButton = new TextButton("Back to main menu", skin);
        backButton.addListener(new MenuButton(app) {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.setScreen(app.menuScreen);

            }
        });
        table.row();
        table.add(backButton);
    }

}
