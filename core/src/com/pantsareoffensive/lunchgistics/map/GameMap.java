package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.object.Entity;
import com.pantsareoffensive.lunchgistics.object.GameObject;

import java.util.ArrayList;

public class GameMap {
    protected MapData map;
    protected ArrayList<GameObject> gameObjects =new ArrayList<GameObject>();
    protected ArrayList<Entity> entities =new ArrayList<Entity>();

    private  Viewport view;


    public int getMapWidth() {return map.width; }
    public int getMapHeight() {return map.height; }

    public int getMapPixelWidth() {return map.width * 32; }
    public int getMapPixelHeight() {return map.height * 32; }

    public GameMap(Viewport view) {
        this.view = view;
        this.map = new MapData().getBlank(100,80);
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
        if (endX > map.width) endX = map.width;

        int endY = (int)(camera.position.y + camera.viewportHeight/2) / 32 + 2;
        if (endY > map.height) endY = map.height;


        for(int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                batch.draw(map.tiles[x][y].getTexture(), x*32, y*32);
            }
        }

        for (GameObject e : gameObjects) {
           if(e.getX() >= startX*32 && e.getRight() <= endX*32 && e.getY() >= startY *32 && e.getTop() <= endY*32) {
               e.render(batch);
           }
        }


    }

    public void add(GameObject e, Vector2 pos) {
        Vector3 newV = view.unproject(new Vector3(pos.x, pos.y,0));
        e.setPosition(new Vector2(newV.x-16,newV.y-16));
        gameObjects.add(e);
        if (e instanceof Entity) {
            entities.add((Entity) e);
        }
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
        view.unproject(v);
        for (GameObject g: gameObjects) {
            if (g.isInBounds(v)) {
                HudController.getInstance().setToolTip(g.toString());
                return g;
            }
        }
        HudController.getInstance().setToolTip("");
        return null;
    }

    public Viewport getView() {
        return view;
    }
}
