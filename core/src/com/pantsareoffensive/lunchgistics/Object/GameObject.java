package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    protected int ID;
    protected String name;
    protected Vector2 position;
    protected Rectangle bounds;

    protected float width;
    protected float height;

    protected TextureRegion texture;

    protected boolean selected = false;

    public GameObject(TextureRegion texture) {
        this.texture = texture;
        this.width = texture.getRegionWidth();
        this.height = texture.getRegionHeight();
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
        this.bounds = new Rectangle(position.x,position.y,width,height);
    }


    public Vector2 getPosition() { return this.position; }

    public float getX() {
        return position.x;
    }
    public float getY() {
        return position.y;
    }

    public float getWidth() {return width; }
    public float getHeight() {return height; }

    public Rectangle getBounds() {
        return new Rectangle(position.x,position.y,width,height);
    }

    public boolean getSelected() { return selected; }
    public void setSelected(boolean b) { this.selected = b; }

    public float getRight() { return getX() + getWidth(); }
    public float getTop() { return getY() + getHeight(); }

    public Vector2 getOrigin() { return new Vector2(getX() - getWidth()/2,getY() - getWidth()/2); }

    public void update(float delta) {}

    public void render(SpriteBatch batch) {
        batch.draw(texture,getX(),getY());
    }

    public boolean isInBounds(Vector2 compare) {
        return compare.x >= getX() && compare.x <= getRight() && compare.y >= getY() && compare.y <= getTop();
    }

    public String toString() {
        return this.ID + " " + this.name + " " + this.position;
    }

    public boolean isInBounds(GameObject g) {
            return bounds.overlaps(g.getBounds());
    }
}
