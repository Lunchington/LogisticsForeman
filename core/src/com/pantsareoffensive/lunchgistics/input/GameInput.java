package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.EntityFactory;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;

public class GameInput extends InputAdapter {
    private Stage stage;
    private LogisticsForeman app;

    public GameInput(LogisticsForeman app, Stage stage) {
        this.stage = stage;
        this.app = app;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean keyUp(int key) {
        Vector2 position;

        switch (key) {
            case Input.Keys.ESCAPE:
                app.setScreen(LogisticsForeman.menuScreen);
                return true;
            case Input.Keys.NUM_1:
                position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
                stage.screenToStageCoordinates(position);
                EntityFactory.addWorker(position);
                return true;

            case Input.Keys.NUM_2:
                position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
                stage.screenToStageCoordinates(position);
                EntityFactory.addSkid(position);
                return true;

            default:
                return false;
        }
    }

    @Override
    public boolean keyDown(int key) {
        switch (key) {
            default:
                return false;
        }
    }
}
