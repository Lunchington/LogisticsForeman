package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.model.Worker;
import com.pantsareoffensive.lunchgistics.Global;

public class WorkerActor extends Group {
    public TextureAtlas atlas;

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

        model = new Worker();

        addActor(this.body);
        addActor(this.head);

        addAction(Actions.moveTo(MathUtils.random(0,Global.WIDTH*2), MathUtils.random(0,Global.HEIGHT*2), 10));
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
}
