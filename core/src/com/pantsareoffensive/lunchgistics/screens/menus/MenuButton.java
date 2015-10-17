package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;

public class MenuButton extends InputListener {
    LogisticsForeman app;

    public MenuButton(LogisticsForeman app) {
        this.app = app;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }
    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        app.soundManager.play(SoundManager.GameSound.CLICK);
    }
}
