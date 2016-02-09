package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;

public class Entity extends GameObject{
    protected  Vector2 prevPosition;

    protected boolean flip = false;

    protected TextureAtlas atlas;
    protected String region;

    public Entity(TextureRegion texture, Vector2 pos) {
        super(texture, pos);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        prevPosition = position.cpy();
    }

}
