package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pantsareoffensive.lunchgistics.Global;

public enum Tile {
    DIRT(Global.Art.TILES_ATLAS.findRegion("dirt")),
    EDGE(Global.Art.TILES_ATLAS.findRegion("edge")),
    GRASS(Global.Art.TILES_ATLAS.findRegion("grass")),
    ROAD(Global.Art.TILES_ATLAS.findRegion("road")),
    WALL();


    protected int id;
    protected boolean passable;
    protected TextureRegion region;

    Tile (TextureRegion region) {
        this.region = region;
    }
    Tile() {}

    public TextureRegion getTexture() {
        return this.region;
    }

}
