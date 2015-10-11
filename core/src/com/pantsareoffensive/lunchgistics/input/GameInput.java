package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.models.Worker;


public class GameInput extends InputAdapter {
    private Stage stage;
    private LogisticsForeman app;


    public GameInput(LogisticsForeman app, Stage stage) {
        this.stage = stage;
        this.app = app;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (Input.Buttons.MIDDLE == button) {

            Vector2 position = new Vector2(screenX, screenY);
            stage.screenToStageCoordinates(position);
            stage.addActor(new Worker(position));
            return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int key) {
        switch (key) {
            case Input.Keys.ESCAPE:
                app.setScreen(app.menuScreen);
            default:
                return false;
        }
    }

}
