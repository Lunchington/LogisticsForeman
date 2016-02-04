package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraScroll extends InputAdapter{
    private GameCamera camera;
    private Vector2 move = new Vector2(0,0);

    public float zoomSpeed = 0.2f;

    private float zoomAmt = 1f;
    private float minZoom = 0.4f;
    private float maxZoom = 3f;



    private float delta;

    public CameraScroll(GameCamera camera) { this.camera = camera; }

    @Override
    public boolean keyDown(int key) {
        switch (key) {
            case Input.Keys.A:
                move.add(-1, 0);
                return true;

            case Input.Keys.D:
                move.add(1, 0);
                return true;

            case Input.Keys.W:
                move.add(0, 1);
                return true;

            case Input.Keys.S:
                move.add(0, -1);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int key) {
        switch (key) {
            case Input.Keys.A:
                move.add(1, 0);
                return true;

            case Input.Keys.D:
                move.add(-1, 0);
                return true;

            case Input.Keys.W:
                move.add(0, -1);
                return true;

            case Input.Keys.S:
                move.add(0, 1);
                return true;

            default:
                return false;
        }
    }


    @Override
    public boolean scrolled(int amount) {
        if(amount>0) zoomAmt = camera.zoom + zoomSpeed;
        if(amount<0) zoomAmt = camera.zoom - zoomSpeed;
        return false;
    }


    public void update(float delta) {
        float scrollSpeed = 500f;
        Vector2 movement = move.cpy().nor().scl(scrollSpeed * delta);
        camera.translateSafe(movement.x , movement.y);
    }


}
