package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Global {
    public static final String TITLE = "Logistics Foreman";
    public static final String VERSION ="0.02 pre alpha";
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public static class Art {
        public static final TextureAtlas WORKER_ATLAS = new TextureAtlas(Gdx.files.internal("worker/worker.atlas"));
        public static final TextureAtlas ITEMS_ATLAS = new TextureAtlas(Gdx.files.internal("items/items.atlas"));
        public static final TextureAtlas TILES_ATLAS= new TextureAtlas(Gdx.files.internal("tiles/tiles.atlas"));


        public static  void dispose() {
            WORKER_ATLAS.dispose();
            ITEMS_ATLAS.dispose();
            TILES_ATLAS.dispose();

        }


    }
}
