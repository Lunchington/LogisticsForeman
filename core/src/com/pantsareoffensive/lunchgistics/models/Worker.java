package com.pantsareoffensive.lunchgistics.models;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.Global;

public class Worker extends Group {
    public TextureAtlas atlas;

    private BodyPart head;
    private BodyPart body;

    public Vector2 previous;


    public Worker (TextureAtlas atlas, Vector2 position) {
        setSize(32, 32);
        setPosition(position.x, position.y, Align.center);
        this.atlas = atlas;

        this.head = new BodyPart(this,"head");
        this.body = new BodyPart(this,"body");
        addActor(this.body);
        addActor(this.head);

        addAction(Actions.moveTo(MathUtils.random(0,Global.WIDTH), MathUtils.random(0,Global.HEIGHT), 10));
    }

    @Override
    public void act(float delta) {
        previous = new Vector2(getX(),getY());
        super.act(delta);
    }
}
