package com.pantsareoffensive.lunchgistics.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.Global;

public class Worker extends Actor {
    private Texture texture;

    public Worker (Vector2 position) {
        setSize(32,32);
        setPosition(position.x, position.y, Align.center);

        this.texture = Global.Art.worker;
    }

    @Override
    public void act(float delta) {
        setPosition(getX() + MathUtils.random(-1,1), getY() + MathUtils.random(-1,1));

    }


    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());

    }
}
