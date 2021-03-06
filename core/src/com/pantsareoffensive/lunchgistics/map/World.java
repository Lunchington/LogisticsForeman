package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pantsareoffensive.lunchgistics.GameObjects.Entity;
import com.pantsareoffensive.lunchgistics.GameObjects.GameObject;
import com.pantsareoffensive.lunchgistics.GameObjects.Worker;

import java.util.ArrayList;

public class World {
    protected MapData mapData;
    protected WorldData worldData;

    protected ArrayList<GameObject> gameObjects =new ArrayList<GameObject>();
    protected ArrayList<Entity> entities =new ArrayList<Entity>();

    private  Viewport view;

    public int getMapWidth() {return mapData.width; }
    public int getMapHeight() {return mapData.height; }

    public int getMapPixelWidth() {return getMapWidth()* 32; }
    public int getMapPixelHeight() {return getMapHeight() * 32; }

    public World(Viewport view) {
        this.view = view;
        this.mapData = new MapData().getBlank(100,80);
        this.worldData = new WorldData();
    }

    public void update(float delta ) {
        worldData.setTime(delta);
        for (GameObject e : entities) {
            e.update(delta);
        }

    }

    public void render(SpriteBatch batch) {
        OrthographicCamera camera = (OrthographicCamera) view.getCamera();
        int startX = (int)(camera.position.x - camera.zoom *camera.viewportWidth/2)/ 32;
        if (startX < 0) startX = 0;

        int startY = (int)(camera.position.y - camera.zoom *camera.viewportHeight/2) / 32;
        if (startY < 0) startY = 0;

        int endX = (int)(camera.position.x + camera.zoom * camera.viewportWidth/2) / 32 +2;
        if (endX > mapData.width) endX = mapData.width;

        int endY = (int)(camera.position.y + camera.zoom * camera.viewportHeight/2) / 32 + 2;
        if (endY > mapData.height) endY = mapData.height;


        for(int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                batch.draw(mapData.getTileRegion(x,y), x * 32, y * 32);
            }
        }

        for (GameObject e : gameObjects) {
           if(e.getRight() >= startX*32 && e.getX() <= endX*32 && e.getBottom() >= startY *32 && e.getY() <= endY*32) {
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

    private boolean isCollideWithTile(Rectangle r) {
        int minX = (int) r.x /32;
        int minY = (int) r.y /32;

        int maxX = ((int) r.x + (int) r.getWidth()) /32;
        int maxY = ((int) r.y + (int) r.getHeight()) /32;


        Tile tLeft = mapData.getTile(minX,maxY);
        Tile tRight = mapData.getTile(maxX,maxY);

        Tile bLeft = mapData.getTile(minX,minY);
        Tile bRight = mapData.getTile(maxX,minY);

        return (!tLeft.getPassable() || !tRight.getPassable() || !bLeft.getPassable() || !bRight.getPassable());

    }

    private boolean isCollideWithObject(Rectangle r) {
        for (GameObject g: gameObjects) {
            if (g.getBounds().overlaps(r))
                return true;
        }
        return false;
    }

    private boolean isOverlapping(GameObject e) {
        return isCollideWithTile(e.getBounds()) || isCollideWithObject(e.getBounds());
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

    public ArrayList<Worker> getWorkers() {
        ArrayList<Worker> workers = new ArrayList<Worker>();

        for (Entity e: entities) {
            if (e instanceof Worker)
                workers.add((Worker) e);
        }
        return workers;
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

    public void setTile(Vector2 pos, Tile tile) {
        int x = (int) (pos.x / 32);
        int y = (int) (pos.y / 32);

        int tileX = x*32;
        int tileY = y *32;
        Rectangle tBounds = new Rectangle(tileX,tileY,32,32);

        if(!isCollideWithObject(tBounds))
            mapData.setTile(x,y,tile);
    }


    public int getDay() {
        return worldData.getDay();
    }
    public int getHour() {
        return worldData.getHour();
    }

    public int getMinute() {
        return worldData.getMinute();
    }

    public int getMoney() {
        return worldData.getMoney();
    }

    public void increaseSpeed(int i) {
        worldData.increaseSpeed(i);
    }

    public int getTimeMultiplier() {
        return worldData.getTimeMultiplier();
    }
}
