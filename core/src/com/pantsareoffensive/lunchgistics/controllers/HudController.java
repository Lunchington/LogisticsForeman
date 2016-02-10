package com.pantsareoffensive.lunchgistics.controllers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;


public class HudController {
    private Stage stage;
    private TextTooltip toolTip;
    public Table topTable;
    public Table bottomTable;
    public Skin skin;


    public HudController(Stage stage) {
        this.stage = stage;
        this.skin = new Skin(Gdx.files.internal("gui/gui.json"));
        this.topTable = new Table(skin);
        this.bottomTable = new Table(skin);
        this.toolTip = new TextTooltip("",skin);
        init();

    }

    public void init() {
        topTable.setFillParent(true);
        topTable.defaults().growX();
        topTable.center().top();

        bottomTable.setFillParent(true);
        bottomTable.defaults().expandX().fillX();

        bottomTable.columnDefaults(0).left().width(200f);
        bottomTable.columnDefaults(1).center();
        bottomTable.columnDefaults(2).right().width(200f);

        bottomTable.center().bottom();

        stage.addActor(topTable);
        stage.addActor(bottomTable);

        toolTip.getActor().setAlignment(Align.center);
        bottomTable.add(toolTip.getActor()).center();
    }

    public void setToolTip(String text) {
        toolTip.getActor().setText(text);
    }

}
