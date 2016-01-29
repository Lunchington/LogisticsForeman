package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GamePlayController implements EntityListener{
    private Stage stage;

    private static GamePlayController INSTANCE = null;

    public static GamePlayController getInstance() {
        if (INSTANCE == null) {
            synchronized (GamePlayController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GamePlayController();
                }
            }
        }
        return INSTANCE;
    }

    public void init(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void entityAdded(Entity entity) {

    }

    @Override
    public void entityRemoved(Entity entity) {

    }
}
