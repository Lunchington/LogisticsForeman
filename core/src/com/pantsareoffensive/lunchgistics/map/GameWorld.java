package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.entities.Entity;

public class GameWorld {
    private GameMap map;

    public static int tileSize = 32;
    private int startX, endX, startY, endY;


    private Application app;

    private Array<Entity> entities = new Array<Entity>();
    private Array<Entity> toRemove = new Array<Entity>();

    public GameWorld(Application app) {
        this.map = new GameMapBuilder(100, 100).generateRandom().build();
        this.app = app;

    }

    public GameMap getMap() {
        return map;
    }

    public void update() {

    }

    public void render(float delta) {
        app.camera.update();

        startX = MathUtils.floor(app.camera.frustum.planePoints[0].x / (float) tileSize) - 1;
        startY = MathUtils.floor(app.camera.frustum.planePoints[0].y / (float)tileSize) - 1;
        endX = MathUtils.floor(app.camera.frustum.planePoints[2].x / (float)tileSize) + 1;
        endY = MathUtils.floor(app.camera.frustum.planePoints[2].y / (float)tileSize) + 1;

        // Restrict the grid coordinates to realistic values
        if (startX < 0) startX = 0;
        if (endX > map.width) endX =map. width;
        if (startY < 0) startY = 0;
        if (endY > map.height) endY = map.height;

        app.batch.setProjectionMatrix(app.camera.combined);
        app.batch.begin();

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                app.batch.draw(map.tiles[x][y].getRegion(), x * tileSize, y * tileSize);
            }
        }


        app.batch.end();
        // End the map drawing
        //NOW draw the UI

        Matrix4 uiMatrix = app.camera.combined.cpy();
        uiMatrix.setToOrtho2D(0, 0, Application.WIDTH, Application.HEIGHT);
        app.batch.setProjectionMatrix(uiMatrix);
        app.batch.begin();
        //begin UI draw


            drawDebug();
        app.batch.end();

    }

    public void drawDebug() {
        if (!Application.DEV_MODE)
            return;

        app.font.draw(app.batch, "MOUSE X: " + Gdx.input.getX() + " Y: " + Gdx.input.getY(), 16, Application.HEIGHT - 16);

        Vector3 wCoords =  app.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        app.font.draw(app.batch, "WORLD X: " + wCoords.x + " Y: " + wCoords.y, 16, Application.HEIGHT - 16*2);

        String leftPushed = "FALSE";
        String rightPushed = "FALSE";

        if (Gdx.input.isButtonPressed(0)) {
            leftPushed = "TRUE";
        }

        if (Gdx.input.isButtonPressed(1)) {
            rightPushed = "TRUE";
        }
        app.font.draw(app.batch,
                "LEFT BUTTON PRESS: " + leftPushed +
                        " RIGHT BUTTON PRESS: " + rightPushed
                , 16, Application.HEIGHT - 16 * 3);
    }
}
