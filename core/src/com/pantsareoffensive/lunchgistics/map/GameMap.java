package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.object.Entity;
import com.pantsareoffensive.lunchgistics.object.GameObject;

import java.util.ArrayList;

public class GameMap {
    protected MapData mapData;
    protected ArrayList<GameObject> gameObjects =new ArrayList<GameObject>();
    protected ArrayList<Entity> entities =new ArrayList<Entity>();



    private  Viewport view;


    public int getMapWidth() {return mapData.width; }
    public int getMapHeight() {return mapData.height; }

    public int getMapPixelWidth() {return getMapWidth()* 32; }
    public int getMapPixelHeight() {return getMapHeight() * 32; }

    public GameMap(Viewport view) {
        this.view = view;
        this.mapData = new MapData().getBlank(100,80);
    }

    public void update(float delta ) {
        for (GameObject e : entities) {
            e.update(delta);
        }

    }

    public void render(SpriteBatch batch) {
        Camera camera = view.getCamera();
        int startX = (int)(camera.position.x - camera.viewportWidth/2)/ 32;
        if (startX < 0) startX = 0;

        int startY = (int)(camera.position.y - camera.viewportHeight/2) / 32;
        if (startY < 0) startY = 0;

        int endX = (int)(camera.position.x + camera.viewportWidth/2) / 32 +2;
        if (endX > mapData.width) endX = mapData.width;

        int endY = (int)(camera.position.y + camera.viewportHeight/2) / 32 + 2;
        if (endY > mapData.height) endY = mapData.height;


        for(int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                batch.draw(mapData.getTileRegion(x,y), x * 32, y * 32);
            }
        }

        for (GameObject e : gameObjects) {
           if(e.getX() >= startX*32 && e.getRight() <= endX*32 && e.getY() >= startY *32 && e.getTop() <= endY*32) {
               e.render(batch);
           }
        }
    }

    public void add(GameObject e) {

        if (isOverlapping(e))
            return;

        gameObjects.add(e);
        if (e instanceof Entity) {
            entities.add((Entity) e);
        }
    }

    private boolean isOverlapping(GameObject e) {
        for (GameObject g: gameObjects) {
            if (g.isInBounds(e))
                    return true;
        }
        return false;
    }

    public ArrayList<GameObject> getObjects() {
        ArrayList<GameObject> ents = new ArrayList<GameObject>();
        for (GameObject e : gameObjects)
            if(!(e instanceof Entity))
                ents.add(e);
        return ents;
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }


    public GameObject getObjectAtMouse(Vector2 clicked) {
        Vector2 v = clicked.cpy();
        for (GameObject g: gameObjects) {
            if (g.isInBounds(v)) {
                return g;
            }
        }
        return null;
    }

    public Viewport getView() {
        return view;
    }

    public MapData getMapData() {
        return mapData;
    }

}
