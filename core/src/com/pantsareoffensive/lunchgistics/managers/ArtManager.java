package com.pantsareoffensive.lunchgistics.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ArtManager extends AssetManager {
    private String WORKER = "worker/worker.atlas";
    private String ITEMS = "items/items.atlas";
    private String TILES = "tiles/tiles.atlas";


    // Static REsource Cache
    public static TextureAtlas WORKER_ATLAS;
    public static TextureAtlas ITEMS_ATLAS;
    public static TextureAtlas TILES_ATLAS;


    private AssetManager assetManager= new AssetManager();


    public void load(){
        assetManager.load(WORKER, TextureAtlas.class);
        assetManager.load(ITEMS, TextureAtlas.class);
        assetManager.load(TILES, TextureAtlas.class);

        while(!assetManager.update())
        {
            System.out.println("Loaded: " + assetManager.getProgress() *100 + "%");
        }

        init();

    }

    public void init() {
        WORKER_ATLAS = assetManager.get(WORKER, TextureAtlas.class);
        ITEMS_ATLAS = assetManager.get(ITEMS, TextureAtlas.class);
        TILES_ATLAS = assetManager.get(TILES, TextureAtlas.class);
    }
}
