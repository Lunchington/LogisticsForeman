package com.pantsareoffensive.lunchgistics.GameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Box extends GameObject implements IInventoryObject{
    public Box(TextureRegion texture, Vector2 pos) {
       super(texture,pos);
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean canMoveByHand() {
        return true;
    }

    @Override
    public int getWeight() {
        return 0;
    }


}
