package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.controllers.HudController;
import com.pantsareoffensive.lunchgistics.model.Worker;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;

public class WorkerActor extends Group {
    public TextureAtlas atlas;

    private BodyPart head;
    private BodyPart body;

    private Worker model;

    private Vector2 previous;


    public WorkerActor(TextureAtlas atlas, Vector2 position) {
        setSize(32, 32);
        setPosition(position.x, position.y, Align.center);
        setName(RandomNames.get().getName());

        this.atlas = atlas;
        this.head = new BodyPart(this,"head");
        this.body = new BodyPart(this,"body");

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
                HudController.get().setToolTip("");


            }

        });
    }

    @Override
    public void act(float delta) {
        previous = new Vector2(getX(),getY());
        super.act(delta);
    }

    public Entity getEntity() {
        return model;
    }

    public Vector2 getPrevious() {
        return previous;
    }



}
