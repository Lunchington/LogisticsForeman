package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pantsareoffensive.lunchgistics.Global;

import java.util.HashMap;
import java.util.Map;

public class MapData {
    protected Tile[][] tiles;
    protected int width;
    protected int height;

    protected Map<Integer,Integer> tileKey = new HashMap<Integer, Integer>() {{
        put(2,1);       put(8, 2);      put(10 , 3);    put(11 , 4);
        put(16 , 5);    put(18 , 6);    put(22 , 7);    put(24 , 8);
        put(26 , 9);    put(27 , 10);   put(30 , 11);   put(31 , 12);
        put(64 , 13);   put(66 , 14);   put(72 , 15);   put(74 , 16);
        put(75 , 17);   put(80 , 18);   put(82 , 19);   put(86 , 20);
        put(88 , 21);   put(90 , 22);   put(91 , 23);   put(94 , 24);
        put(95 , 25);   put(104 , 26);  put(106 , 27);  put(107 , 28);
        put(120 , 29);  put(122 , 30);  put(123 , 31);  put(126 , 32);
        put(127 , 33);  put(208 , 34);  put(210 , 35);  put(214 , 36);
        put(216 , 37);  put(218 , 38);  put(219 , 39);  put(222 , 40);
        put(223 , 41);  put(248 , 42);  put(250 , 43);  put(251 , 44);
        put(254 , 45);  put(255 , 46);  put(0 , 47);
    }};



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
        return new MapData(newTiles, width, height);
    }

    public Tile getTile(int x, int y) {
        if (isTile(x,y))
            return tiles[x][y];
        return null;
    }

    public boolean isTile(int x, int y) {
        return ( x >= 0 && y >= 0 && x < tiles.length && y < tiles[0].length);
    }

    public Tile getTileAdjacent(int x, int y, int direction) {

        switch(direction) {
            case TileValue.North:
                return getTile(x, y+1) ;
            case TileValue.South:
                return getTile(x, y-1);
            case TileValue.East:
                return getTile(x+1, y);
            case TileValue.West:
                return getTile(x-1, y);

            case TileValue.NorthEast:
                return getTile(x+1,y+1);
            case TileValue.NorthWest:
                return getTile(x-1,y+1);

            case TileValue.SouthEast:
                return getTile(x+1,y-1);
            case TileValue.SouthWest:
                return getTile(x-1,y-1);

            default:
                return null;
        }
    }

    public boolean isType(Tile tile,Tile type) {
        return tile == type;
    }

    public boolean isTileAdjacentSameType(int x, int y, int direction, Tile isType) {
        Tile checkTile = getTileAdjacent(x,y,direction);
        return checkTile != null && isType(checkTile, isType);
    }

    public TextureRegion getTileRegion(int x, int y) {
        Tile t = getTile(x,y);
        if (t == Tile.WALL) {
            int tileValue = getTileValue(x,y);
            if(tileKey.containsKey(tileValue))
                tileValue = tileKey.get(tileValue);
            return Global.Art.TILES_ATLAS.findRegion("walls"+tileValue) ;
        }

        return t.getTexture();
    }

    public int getTileValue(int x, int y) {
        Tile t = getTile(x,y);

        int value = 0;

        if(isTileAdjacentSameType(x,y,TileValue.NorthWest,t)) {
            if (isTileAdjacentSameType(x-1,y+1,TileValue.East,t) && isTileAdjacentSameType(x-1,y+1,TileValue.South,t))
                value += TileValue.NorthWest;
        }

        if(isTileAdjacentSameType(x,y,TileValue.North,t))
            value += TileValue.North;

        if(isTileAdjacentSameType(x,y,TileValue.NorthEast,t)) {
            if (isTileAdjacentSameType(x + 1, y + 1, TileValue.West, t) && isTileAdjacentSameType(x + 1, y + 1, TileValue.South, t))
                value += TileValue.NorthEast;
        }

        if(isTileAdjacentSameType(x,y,TileValue.West,t))
            value += TileValue.West;

        if(isTileAdjacentSameType(x,y,TileValue.East,t))
            value += TileValue.East;


        if(isTileAdjacentSameType(x,y,TileValue.SouthWest,t)) {
            if (isTileAdjacentSameType(x - 1, y - 1, TileValue.East, t) && isTileAdjacentSameType(x - 1, y - 1, TileValue.North, t))
                value += TileValue.SouthWest;
        }

        if(isTileAdjacentSameType(x,y,TileValue.South,t))
            value += TileValue.South;

        if(isTileAdjacentSameType(x,y,TileValue.SouthEast,t)) {
            if (isTileAdjacentSameType(x + 1, y - 1, TileValue.West, t) && isTileAdjacentSameType(x + 1, y - 1, TileValue.North, t))
                value += TileValue.SouthEast;
        }

        return value;
    }

    public void setTile(int x, int y, Tile t) {
        tiles[x][y] = t;
    }
}
