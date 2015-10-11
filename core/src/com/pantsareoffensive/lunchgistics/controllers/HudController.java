package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;


public class HudController implements EntityListener{
    private LogisticsForeman game;
    private Stage stage;
    private ToolTip toolTip;

    private static HudController INSTANCE = null;

    public static HudController init(LogisticsForeman game, Stage stage) {
        HudController hudCont = new HudController(game, stage);
        INSTANCE = hudCont;
        return hudCont;
    }

    public static HudController get() {
        return INSTANCE;
    }

    public HudController (LogisticsForeman game, Stage stage) {
        this.game = game;
        this.stage = stage;


        this.toolTip = new ToolTip(stage.getViewport().getScreenWidth() / 2, 0);
        stage.addActor(toolTip);
    }
    @Override
    public void entityAdded(Entity entity) {

    }

    @Override
    public void entityRemoved(Entity entity) {

    }
}
