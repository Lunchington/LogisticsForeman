package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;

public enum Tile {
    DIRT,
    EDGE,
    GRASS,
    ROAD,
    WALL;


    public TextureRegion getTexture() {

        switch (this) {
            case DIRT:
                return ArtManager.TILES_ATLAS.findRegion("dirt");
            case EDGE:
                return ArtManager.TILES_ATLAS.findRegion("edge");
            case GRASS:
                return ArtManager.TILES_ATLAS.findRegion("grass");
            case ROAD:
                return ArtManager.TILES_ATLAS.findRegion("road");
            default:
                return null;
        }
    }

    public boolean getPassable() { return this != WALL; }

}
