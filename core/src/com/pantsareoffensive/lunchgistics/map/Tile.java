package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    private static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("tiles/tiles.atlas"));
    public static TextureRegion DIRT = atlas.findRegion("dirt");
    public static TextureRegion GRASS = atlas.findRegion("grass");
    public static TextureRegion ROAD = atlas.findRegion("road");
    public static TextureRegion EDGE = atlas.findRegion("edge");

    private int tileid;

    public Tile() {
        tileid = 0;
    }

    public Tile(int _tileid) {
        this.tileid = _tileid;

    }

    public void setID(int id) {
        tileid = id;
    }

    public TextureRegion getRegion() {
        if (this.tileid == 0) return DIRT;
        if (this.tileid == 1) return GRASS;
        if (this.tileid == 2) return ROAD;
        if (this.tileid == 3) return EDGE;
        return null;
    }
}
