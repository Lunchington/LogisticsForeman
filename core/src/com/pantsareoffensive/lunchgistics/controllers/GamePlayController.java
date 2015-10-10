package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GamePlayController implements EntityListener{
    private Stage stage;


    public GamePlayController (Stage stage) { this.stage = stage;

        stage.addActor(new ToolTip(stage.getViewport().getScreenWidth() / 2, 60));
    }


    @Override
    public void entityAdded(Entity entity) {

    }

    @Override
    public void entityRemoved(Entity entity) {

    }
}
