package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    enum TYPE { DIRT, GRASS, ROAD, EDGE }

    private static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("tiles/tiles.atlas"));
    public static TextureRegion DIRT = atlas.findRegion("dirt");
    public static TextureRegion GRASS = atlas.findRegion("grass");
    public static TextureRegion ROAD = atlas.findRegion("road");
    public static TextureRegion EDGE = atlas.findRegion("edge");


    private TYPE type;

    public Tile(TYPE type) {
        this.type = type;

    }

    public TextureRegion getRegion() {
        if (this.type == TYPE.DIRT) return DIRT;
        if (this.type == TYPE.GRASS) return GRASS;
        if (this.type == TYPE.ROAD) return ROAD;
        if (this.type == TYPE.EDGE) return EDGE;
        return null;
    }
}
