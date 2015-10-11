package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.models.Worker;


public class GameInput extends InputAdapter {
    Stage stage;


    public GameInput(Stage stage) { this.stage = stage; }
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
}
