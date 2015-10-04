package com.pantsareoffensive.lunchgistics.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Entity {
    private Vector2 position;
    //For animations / textures arrays
    // 0 = left
    // 1 = right

    private TextureAtlas atlas;
    
    //animations
    private TextureRegion curFrame;

    private TextureRegion[] idle = new TextureRegion[2];

    private Animation[] walk = new Animation[2];
    private Animation[] shoot = new Animation[2];
    //
    
    public Entity(Vector2 position, TextureAtlas atlas) {
        this.position = position;
        this.atlas = atlas;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Vector3 getPosition() {
        return new Vector3(position.x, position.y, 0);
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

}
