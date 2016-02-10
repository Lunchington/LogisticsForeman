package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pantsareoffensive.lunchgistics.Global;

public enum Tile {
    DIRT,
    EDGE,
    GRASS,
    ROAD,
    WALL;


    public TextureRegion getTexture() {

        switch (this) {
            case DIRT:
                return Global.Art.TILES_ATLAS.findRegion("dirt");
            case EDGE:
                return Global.Art.TILES_ATLAS.findRegion("edge");
            case GRASS:
                return Global.Art.TILES_ATLAS.findRegion("grass");
            case ROAD:
                return Global.Art.TILES_ATLAS.findRegion("road");
            default:
                return null;
        }
    }

    public boolean getPassable() { return this != WALL; }

}
