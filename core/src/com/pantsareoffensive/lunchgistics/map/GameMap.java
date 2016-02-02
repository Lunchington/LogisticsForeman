package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.pantsareoffensive.lunchgistics.object.Entitiy;

import java.util.ArrayList;

public class GameMap {
    protected MapData map;
    protected ArrayList<Entitiy> entitiyList =new ArrayList<Entitiy>();

    private OrthographicCamera camera;

    public GameMap(OrthographicCamera camera) {
        this.camera = camera;
        this.map = new MapData().getBlank(100,80);

    }

    public void update(float delta ) {

        int mapLeft = 0;
        int mapRight =map.width * 32;
        int mapBottom = 0;
        int mapTop = map.height * 32;

        float cameraHalfWidth = camera.viewportWidth * .5f * camera.zoom;
        float cameraHalfHeight = camera.viewportHeight * .5f * camera.zoom;

        float cameraLeft = camera.position.x - cameraHalfWidth;
        float cameraRight = camera.position.x + cameraHalfWidth;
        float cameraBottom = camera.position.y - cameraHalfHeight;
        float cameraTop = camera.position.y + cameraHalfHeight;


// Horizontal axis
        if(cameraLeft <= mapLeft)
        {
            camera.position.x = mapLeft + cameraHalfWidth;
        }
        else if(cameraRight >= mapRight)
        {
            camera.position.x = mapRight - cameraHalfWidth;
        }

// Vertical axis
        if(cameraBottom <= mapBottom)
        {
            camera.position.y = mapBottom + cameraHalfHeight;
        }
        else if(cameraTop >= mapTop)
        {
            camera.position.y = mapTop - cameraHalfHeight;
        }
        camera.update();
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);

        int startX = (int)(camera.position.x - camera.viewportWidth/2 * camera.zoom)/ 32;
        if (startX < 0) startX = 0;

        int startY = (int)(camera.position.y - camera.viewportHeight/2* camera.zoom) / 32;
        if (startY < 0) startY = 0;

        int endX = (int)(camera.position.x + camera.viewportWidth/2* camera.zoom) / 32 + 2;
        if (endX > map.width) endX = map.width;

        int endY = (int)(camera.position.y + camera.viewportHeight/2* camera.zoom) / 32 + 2;
        if (endY > map.height) endY = map.height;


        /*for(int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {*/
        for(int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                batch.draw(map.tiles[x][y].getTexture(), x*32, y*32);
            }
        }

        if (entitiyList.size() > 0) {
            for (Entitiy e : entitiyList) {
                e.render(batch);
            }
        }

    }

    public void addEntity(Entitiy e,Vector2 pos) {
        Vector3 newV = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(),0));
        e.setPosition(new Vector2(newV.x,newV.y));
        entitiyList.add(e);
    }
}
