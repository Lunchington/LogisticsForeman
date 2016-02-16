package com.pantsareoffensive.lunchgistics.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ArtManager extends AssetManager {
    private String WORKER = "worker/worker.atlas";
    private String ITEMS = "items/items.atlas";
    private String TILES = "tiles/tiles.atlas";
    private String GUI = "gui/gui.json";


    // Static REsource Cache
    public static TextureAtlas WORKER_ATLAS;
    public static TextureAtlas ITEMS_ATLAS;
    public static TextureAtlas TILES_ATLAS;
    public static Skin GUI_SKIN;

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

        GUI_SKIN = new Skin();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/rimouski.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();

        parameter.size = 16;
        BitmapFont font16 = generator.generateFont(parameter); // font size 12 pixels

        parameter.size = 12;
        BitmapFont font10 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();

        GUI_SKIN.add("default-font", font16, BitmapFont.class);
        GUI_SKIN.add("small-font", font10, BitmapFont.class);

        GUI_SKIN.addRegions(new TextureAtlas(Gdx.files.internal("gui/gui.atlas")));
        GUI_SKIN.load(Gdx.files.internal(GUI));


    }
}
