package com.pantsareoffensive.lunchgistics.controllers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;


public class HudController {
    private Stage stage;
    private ToolTip toolTip;
    public Table topTable;
    public Table bottomTable;
    public Skin skin;

    private static HudController INSTANCE = null;

    public static HudController getInstance() {
        if (INSTANCE == null) {
            synchronized (HudController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HudController();
                }
            }
        }
        return INSTANCE;
    }

    public HudController() {
        skin = new Skin(Gdx.files.internal("gui/gui.json"));
        topTable = new Table(skin);
        topTable.setFillParent(true);
        topTable.defaults().growX();
        topTable.center().top();

        bottomTable = new Table(skin);
        bottomTable.setFillParent(true);
        bottomTable.defaults().expandX().fillX();

        bottomTable.columnDefaults(0).left().width(200f);
        bottomTable.columnDefaults(1).center();
        bottomTable.columnDefaults(2).right().width(200f);

        bottomTable.center().bottom();
    }

    public void init(Stage stage) {
        this.stage = stage;
        stage.addActor(topTable);
        stage.addActor(bottomTable);

        this.toolTip = new ToolTip();
        this.bottomTable.add(this.toolTip).center();




    }

    public void setToolTip(String text) {
        toolTip.setText(text);
    }

}
