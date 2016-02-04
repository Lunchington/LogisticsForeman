package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pantsareoffensive.lunchgistics.object.Entity;

import java.util.ArrayList;

public class GameMap {
    protected MapData map;
    protected ArrayList<Entity> entitiyList =new ArrayList<Entity>();

    private  Viewport view;

    public GameMap(Viewport view) {
        this.view = view;
        this.map = new MapData().getBlank(100,80);
    }

    public void update(float delta ) {
        for (Entity e : entitiyList) {
            e.update(delta);
        }

    }

    public void render(SpriteBatch batch) {
        Camera camera = view.getCamera();
        int startX = (int)(camera.position.x - camera.viewportWidth/2)/ 32;
        if (startX < 0) startX = 0;

        int startY = (int)(camera.position.y - camera.viewportHeight/2) / 32;
        if (startY < 0) startY = 0;

        int endX = (int)(camera.position.x + camera.viewportWidth/2) / 32 + 2;
        if (endX > map.width) endX = map.width;

        int endY = (int)(camera.position.y + camera.viewportHeight/2) / 32 + 2;
        if (endY > map.height) endY = map.height;


        for(int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                batch.draw(map.tiles[x][y].getTexture(), x*32, y*32);
            }
        }

        for (Entity e : entitiyList) {
            e.render(batch);
        }


    }

    public void addEntity(Entity e, Vector2 pos) {
        Vector3 newV = view.unproject(new Vector3(pos.x, pos.y,0));
        e.setPosition(new Vector2(newV.x,newV.y));
        entitiyList.add(e);
    }

    public ArrayList<Entity> getEntities() {return entitiyList;}

    public int getMapWidth() {return map.width; }
    public int getMapHeight() {return map.height; }

}
