package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.view.WorkerActor;

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

            WorkerActor w = new WorkerActor(Global.Art.WORKER_ATLAS,position);
            stage.addActor(w);
            app.gameplayScreen.addtoEngine(w.getWorker());
            return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int key) {
        switch (key) {
            case Input.Keys.ESCAPE:
                app.setScreen(app.menuScreen);
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
