package com.pantsareoffensive.lunchgistics.map;

import com.pantsareoffensive.lunchgistics.utils.Util;

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
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                tiles[x][y] = new Tile(Util.randomEnum(Tile.TYPE.class));
        return this;
    }


    public GameMapBuilder makeBlank() {
        return this.clearToTile(Tile.TYPE.DIRT);
    }

    public GameMapBuilder clearToTile(Tile.TYPE type) {
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                tiles[x][y] = new Tile(type);
        return this;
    }
}
