package com.pantsareoffensive.lunchgistics.object;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends GameObject{
    protected Vector2 position;
    protected  Vector2 prevPosition;
    protected Vector2 origin;


    protected boolean flip = false;

    protected TextureAtlas atlas;
    protected  String region;

    protected TextureRegion texture;

    public Entity(TextureRegion texture, Vector2 pos) {
        this.position = pos;
        this.texture = texture;
    }

    public Entity(TextureRegion texture) {
        this(texture,Vector2.Zero);
    }

    public Entity() {
        this(null);
    }

    public void update(float delta) {}

    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x-16,position.y-16);
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
        this.prevPosition = pos;
    }

    public void setOrigin(Vector2 pos) {
        this.origin = pos;
    }


}
