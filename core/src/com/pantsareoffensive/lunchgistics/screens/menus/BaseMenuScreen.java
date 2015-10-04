package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.screens.AbstractScreen;
import com.pantsareoffensive.lunchgistics.systems.MusicManager;


public class BaseMenuScreen extends AbstractScreen {

    public BaseMenuScreen(Application _game) {
        super(_game);
    }

    @Override
    public void show() {
        super.show();

        Table table = super.getTable();

        Drawable splashDrawable =  new Image(new Texture(Gdx.files.internal("logo.png"))).getDrawable();
        table.setBackground(splashDrawable);

        //game.getMusicManager().play(MusicManager.ParadigmMusic.MENU);

    }

    @Override
    public void render(float _delta) {
        super.render(_delta);
        renderTable();
    }
}
