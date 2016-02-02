package com.pantsareoffensive.lunchgistics.object;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Entitiy extends GameObject{
    protected Vector2 position;
    protected TextureRegion texture;

    public Entitiy(TextureRegion texture, Vector2 pos) {
        this.position = pos;
        this.texture = texture;
    }

    public Entitiy(TextureRegion texture) {
        this(texture,Vector2.Zero);
    }
    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x-16,position.y-16);
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
    }
}
