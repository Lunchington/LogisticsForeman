package com.pantsareoffensive.lunchgistics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.map.GameWorld;


public class GamePlayScreen extends AbstractScreen {

    public GameWorld gWorld;
    public Table actionButtons;

    public GamePlayScreen(Application app) {
        super(app);


        gWorld = new GameWorld(app);

    }

    @Override
    public void render(float _delta) {
        super.render(_delta);
        handleInput(_delta);

        app.camera.update();
        gWorld.update();

        gWorld.render(_delta);
        renderTable();
    }

    private void handleInput(float delta) {
        if ((app.camera.viewportWidth == gWorld.getMap().widthPixels) && (app.camera.viewportHeight == gWorld.getMap().heightPixels)) return;

        Vector3 movement = new Vector3();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            movement.x = -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            movement.x = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            movement.y = -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            movement.y = 1;
        }

        movement.nor();
        movement.x *= 10f;
        movement.y *= 10f;

        app.camera.position.x += movement.x;
        app.camera.position.y += movement.y;

        locktoMap();
    }

    public void locktoMap() {

        if (app.camera.position.x < Application.WIDTH / 2) app.camera.position.x = Application.WIDTH / 2;
        if (app.camera.position.x > gWorld.getMap().widthPixels - Application.WIDTH / 2) app.camera.position.x = gWorld.getMap().widthPixels - Application.WIDTH / 2;

        if (app.camera.position.y < Application.HEIGHT / 2) app.camera.position.y = Application.HEIGHT / 2;
        if (app.camera.position.y > gWorld.getMap().heightPixels - Application.HEIGHT / 2) app.camera.position.y = gWorld.getMap().heightPixels - Application.HEIGHT / 2;
    }

    @Override
    public void show() {
        super.show();

    }

    @Override
    public void dispose() {

    }

}
