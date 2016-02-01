package com.pantsareoffensive.lunchgistics.map;

public class MapData {
    protected Tile[][] tiles;
    protected int width;
    protected int height;

    public MapData() {}

    public MapData(Tile[][] tiles, int width, int height) {
        this.tiles = tiles;
        this.height = height;
        this.width = width;

    }

    public MapData getBlank(int width, int height) {
        Tile[][] newTiles = new Tile[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newTiles[x][y] = Tile.DIRT;
            }
        }
        newTiles[0][0] = Tile.EDGE;
        newTiles[width-1][0] = Tile.EDGE;
        newTiles[0][height-1] = Tile.EDGE;
        newTiles[width-1][height-1] = Tile.EDGE;

        return new MapData(newTiles, width, height);
    }
}
