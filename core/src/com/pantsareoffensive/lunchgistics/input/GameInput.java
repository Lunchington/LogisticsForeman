package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.object.Skid;
import com.pantsareoffensive.lunchgistics.object.Worker;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;

public class GameInput extends InputAdapter {
    private GameMap map;

    private Vector2 clicked;

    public GameInput(GameMap map) {
        this.map = map;
    }

    @Override
    public boolean keyUp(int key) {
        Vector2 position;

        switch (key) {
            case Input.Keys.ESCAPE:
                ScreenManager.getInstance().show(ScreenManager.GameScreens.MAIN_MENU);
                return true;
            case Input.Keys.NUM_1:
                map.addEntity(new Worker(), new Vector2(Gdx.input.getX(), Gdx.input.getY()));
                return true;

            case Input.Keys.NUM_2:
                map.addEntity(new Skid(), new Vector2(Gdx.input.getX(), Gdx.input.getY()));
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

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            clicked = new Vector2(x,y);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            clicked = null;
            return true;
        }
        return false;
    }

    public Vector2 getClicked() { return clicked;}
}
