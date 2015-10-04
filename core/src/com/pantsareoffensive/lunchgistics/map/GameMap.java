package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.pantsareoffensive.lunchgistics.Application;

public class GameMap {
    public Tile[][] tiles;

    public int width;
    public int height;
    public int heightPixels;
    public int widthPixels;
    

    public GameMap(Tile[][] _tiles) {
        tiles = _tiles;
        width = _tiles.length;
        height = _tiles[0].length;
        heightPixels = height * GameWorld.tileSize;
        widthPixels = width * GameWorld.tileSize;

    }

   

    public Tile getTile(int x, int y) {
        return tiles[x][y];

    }

}
