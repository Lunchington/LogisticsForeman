package com.pantsareoffensive.lunchgistics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Global {
    public static  final String TITLE = "Logistics Foreman";
    public static final String VERSION ="0.01 pre alpha";
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public static class Art {
        public static TextureAtlas WORKER_ATLAS;
        public static TextureAtlas ITEMS_ATLAS;
        public static TextureAtlas TILES_ATLAS;


        public static void init() {
            WORKER_ATLAS  = new TextureAtlas(Gdx.files.internal("worker/worker.atlas"));
            ITEMS_ATLAS  = new TextureAtlas(Gdx.files.internal("items/items.atlas"));
            TILES_ATLAS  = new TextureAtlas(Gdx.files.internal("tiles/tiles.atlas"));

        }
        public static  void dispose() {
            WORKER_ATLAS.dispose();
            ITEMS_ATLAS.dispose();
            TILES_ATLAS.dispose();

        }


    }
}
