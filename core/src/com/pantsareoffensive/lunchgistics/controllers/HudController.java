package com.pantsareoffensive.lunchgistics.controllers;


import com.badlogic.gdx.scenes.scene2d.Stage;


public class HudController {
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


    public void update() {
        this.toolTip.setPosition(this.stage.getViewport().getScreenWidth() / 2- this.toolTip.getWidth()/2, 0);

    }



    public void setToolTip(String text) {
        toolTip.setText(text);
    }

}
