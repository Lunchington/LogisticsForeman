package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.math.MathUtils;

public class GameMapBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;


    public GameMapBuilder(int _width, int _height) {

        width = _width;
        height = _height;
        tiles = new Tile[_width][_height];

    }

    public GameMap build() {
        return new GameMap(tiles);
    }

    
    public GameMapBuilder generateRandom() {
        this.clearToTile(0);
        return this;
    }
    
    
    public GameMapBuilder makeBlank() {
        return this.clearToTile(0);
    }

    public GameMapBuilder clearToTile(int _tileID) {
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                tiles[x][y] = new Tile(MathUtils.random(0, 2));

        tiles[0][0].setID(3);
        return this;
    }
}
