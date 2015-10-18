package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class GameWorld {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private int mapHeight;
    private int mapWidth;
    int tilePixelWidth; //size of each tile
    int tilePixelHeight;

    public GameWorld(OrthographicCamera camera) {
        map = new TmxMapLoader().load("maps/testing.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);

        mapHeight = map.getProperties().get("height", Integer.class);
        mapWidth = map.getProperties().get("width", Integer.class);

        tilePixelWidth =  map.getProperties().get("tilewidth", Integer.class);
        tilePixelHeight  = map.getProperties().get("tileheight", Integer.class);

        this.camera = camera;
    }

    public void update(float delta ) {

        int mapLeft = 0;
        int mapRight =mapWidth * tilePixelWidth;
        int mapBottom = 0;
        int mapTop = mapHeight * tilePixelHeight;

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
    public void render() {
        renderer.setView(camera);
        renderer.render();
    }

}
