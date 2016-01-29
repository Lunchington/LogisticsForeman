package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

public class ItemActor extends Actor {
    private TextureRegion textureRegion;
    protected Entity model;

    public ItemActor(TextureRegion textureRegion, Vector2 position) {
        setSize(32, 32);
        setPosition(position.x, position.y, Align.center);
        this.textureRegion = textureRegion;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(textureRegion,this.getX(),this.getY());
    }

    public Entity getEntity() {
        return model;
    }
}
