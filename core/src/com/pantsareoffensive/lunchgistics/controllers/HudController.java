package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;


public class HudController implements EntityListener{
    private LogisticsForeman app;
    private Stage stage;
    private ToolTip toolTip;
    public int count = 0;

    private static HudController INSTANCE = null;

    public static HudController init(LogisticsForeman app, Stage stage) {
        HudController hudCont = new HudController(app, stage);
        INSTANCE = hudCont;
        return hudCont;
    }

    public static HudController get() {
        return INSTANCE;
    }

    public HudController (LogisticsForeman app, Stage stage) {
        this.app = app;
        this.stage = stage;


        this.toolTip = new ToolTip(stage.getViewport().getScreenWidth() / 2, 0);
        stage.addActor(toolTip);
    }
    @Override
    public void entityAdded(Entity entity) {
        count++;
        setToolTip("TESTIES: " + count );
    }

    @Override
    public void entityRemoved(Entity entity) {

    }

    public void setToolTip(String text) {
        toolTip.setText(text);
    }

}
