package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class HudController implements EntityListener{
    private Stage stage;
    private ToolTip toolTip;

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

    public void init(Stage stage) {
        this.stage = stage;
        this.toolTip = new ToolTip(this.stage.getViewport().getScreenWidth() / 2, 0);
        this.stage.addActor(this.toolTip);
    }

    @Override
    public void entityAdded(Entity entity) {

    }

    @Override
    public void entityRemoved(Entity entity) {

    }

    public void setToolTip(String text) {
        toolTip.setText(text);
    }

}
