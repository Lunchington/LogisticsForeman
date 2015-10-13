package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;

public class CameraScroll extends InputAdapter{
    private Camera camera;
    private Vector2 move = new Vector2(0,0);
    private float scrollSpeed = 8f;

    public CameraScroll(Camera camera) { this.camera = camera; }

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
    public void update(float delta) {
        Vector2 movement = move.cpy().nor().scl(scrollSpeed);
        camera.translate((int) movement.x, (int) movement.y, 0);
        camera.update();
    }

    public Camera getCam() {
        return this.camera;
    }
}
