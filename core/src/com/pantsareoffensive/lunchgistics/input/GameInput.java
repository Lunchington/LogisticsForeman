package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.object.Box;
import com.pantsareoffensive.lunchgistics.object.GameObject;
import com.pantsareoffensive.lunchgistics.object.Skid;
import com.pantsareoffensive.lunchgistics.object.Worker;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;
import com.pantsareoffensive.lunchgistics.map.GameMap;

public class GameInput extends InputAdapter {
    private GameMap map;

    private Vector2 clicked;
    private GameObject selected;

    private Rectangle clickRect;

    public GameInput(GameMap map) {
        this.map = map;
    }

    @Override
    public boolean keyUp(int key) {

        switch (key) {
            case Input.Keys.ESCAPE:
                ScreenManager.getInstance().show(ScreenManager.GameScreens.MAIN_MENU);
                return true;
            case Input.Keys.NUM_1:
                map.add(new Worker(), new Vector2(Gdx.input.getX(), Gdx.input.getY()));
                return true;

            case Input.Keys.NUM_2:
                map.add(new Skid(), new Vector2(Gdx.input.getX(), Gdx.input.getY()));
                return true;
            case Input.Keys.NUM_3:
                map.add(new Box(), new Vector2(Gdx.input.getX(), Gdx.input.getY()));
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
            selected = map.getObjectAtMouse(clicked);
            clickRect = calcClickRect(x,y);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            clicked = null;
            clickRect = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged (int screenX, int screenY, int pointer) {
        if(clicked != null) {
            clickRect = calcClickRect(screenX,screenY);
            return true;
        }
        return false;
    }

    public Vector2 getClicked() { return clicked;}
    public GameObject getSelected() { return selected;}

    public Rectangle calcClickRect(int screenX, int screenY) {
        Vector3 newVec = map.getView().unproject(new Vector3(getClicked(), 0));
        Vector3 mPos = map.getView().unproject(new Vector3(screenX, screenY, 0));
        Vector3 drawVec = newVec.cpy();

        float w;
        float h;

        if (newVec.x > mPos.x) {
            drawVec.x = mPos.x;
            w = newVec.x - mPos.x;
        } else
            w = mPos.x - newVec.x;

        if (newVec.y > mPos.y) {
            drawVec.y = mPos.y;
            h = newVec.y - mPos.y;
        }else
            h = mPos.y - newVec.y;

        return new Rectangle(drawVec.x,drawVec.y,w,h);
    }

    public Rectangle getClickRect() {
        return clickRect;
    }


}
