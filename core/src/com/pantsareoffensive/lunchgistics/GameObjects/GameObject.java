package com.pantsareoffensive.lunchgistics.GameObjects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;
import com.pantsareoffensive.lunchgistics.map.World;

public abstract class GameObject {
    protected static ArtManager assetManager;
    protected BitmapFont font;
    protected World world;

    protected int ID;
    protected String name;
    protected Vector2 position;
    protected Rectangle bounds;

    protected float width;
    protected float height;

    protected float objWidth;
    protected float objHeight;

    protected TextureRegion texture;

    protected boolean selected = false;


    public GameObject(World world, TextureRegion texture, Vector2 pos) {
        this.world = world;
        assetManager = Main.getAssetManager();
        this.texture = texture;
        this.width = texture.getRegionWidth();
        this.height = texture.getRegionHeight();

        this.position = new Vector2(pos.x - width/2, pos.y - height/2);
        this.bounds = new Rectangle(position.x,position.y,width,height);
        font = ArtManager.GUI_SKIN.getFont("small-font");
    }


    public void setObjSize(int w,int h) {
        this.objWidth = w;
        this.objHeight = h;
    }

    public float getX() {
        return position.x;
    }
    public float getY() {
        return position.y;
    }

    public float getWidth() {return width; }
    public float getHeight() {return height; }

    public float getObjWidth() {
        if (objWidth > 0)
                return objWidth;
        return width;
    }
    public float getObjHeight() {
        if (objHeight > 0)
            return objHeight;
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(
                getCenter().x - getObjWidth()/2,
                getCenter().y - getObjHeight()/2,
                getObjWidth(),
                getObjHeight());
    }

    public boolean getSelected() { return selected; }
    public void setSelected(boolean b) { this.selected = b; }

    public float getRight() { return getX() + getWidth(); }
    public float getBottom() { return getY() + getHeight(); }

    public Vector2 getCenter() { return new Vector2(getX() + 16,getY() + 16); }

    public void update(float delta) {}

    public void render(SpriteBatch batch) {
        batch.draw(texture,getX(),getY());
    }

    public boolean isInBounds(Vector2 compare) {
        return compare.x >= getX() && compare.x <= getRight() && compare.y >= getY() && compare.y <= getBottom();
    }

    public String toString() {
        return this.ID + " " + this.name + " " + this.position;
    }

    public boolean isInBounds(GameObject g) {
            return getBounds().overlaps(g.getBounds());
    }

}
