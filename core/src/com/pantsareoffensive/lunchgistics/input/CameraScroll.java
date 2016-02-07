package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.pantsareoffensive.lunchgistics.map.GameMap;

public class CameraScroll extends InputAdapter{
    private GameMap map;
    private OrthographicCamera camera;
    private GameInput input;
    private Vector2 move = new Vector2(0,0);

    public float zoomSpeed = 0.2f;

    private float zoomAmt = 1f;
    private float minZoom = 0.2f;
    private float maxZoom = 1f;
    float scrollSpeed = 500f;


    public CameraScroll(GameMap map, GameInput input) {
        this.map = map;
        this.input = input;
        this.camera = (OrthographicCamera) map.getView().getCamera();
    }

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


        Vector2 movement = move.cpy().nor().scl(scrollSpeed * delta);

        if(input.getClicked() != null) {
            input.setClickedRect();
        }

        camera.translate(movement.x , movement.y);
        attemptZoom(zoomAmt);
        ensureBounds();
    }


    public void ensureBounds() {
        float minX = camera.zoom * (camera.viewportWidth /2);
        float maxX = map.getMapPixelWidth() - minX;

        float minY = camera.zoom *(camera.viewportHeight /2);
        float maxY = map.getMapPixelHeight() - minY;

        camera.position.set(
                MathUtils.clamp(camera.position.x, minX,maxX),
                MathUtils.clamp(camera.position.y, minY,maxY),
                0);
        camera.update();
    }

    public void attemptZoom(float newZoom)
    {
        camera.zoom = MathUtils.clamp(newZoom,minZoom,maxZoom);

    }

}
