package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.model.Worker;

public class WorkerActor extends Group {
    public TextureAtlas atlas;
    private String name;

    private BodyPart head;
    private BodyPart body;

    private Worker model;

    private Vector2 previous;


    public WorkerActor(TextureAtlas atlas, Vector2 position) {
        setSize(32, 32);
        setPosition(position.x, position.y, Align.center);
        this.atlas = atlas;

        this.head = new BodyPart(this,"head");
        this.body = new BodyPart(this,"body");

        this.name = LogisticsForeman.randomNames.getName();

        model = new Worker();

        addActor(this.body);
        addActor(this.head);
        addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer,
                              Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                HudController.get().setToolTip(getName());


            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer,
                             Actor toActor) {
                super.exit(event, x, y, pointer, toActor);

            }

        });
    }

    @Override
    public void act(float delta) {
        previous = new Vector2(getX(),getY());
        super.act(delta);
    }

    public Entity getWorker() {
        return model;
    }

    public Vector2 getPrevious() {
        return previous;
    }

    public String getName() {
        return name;
    }


}
