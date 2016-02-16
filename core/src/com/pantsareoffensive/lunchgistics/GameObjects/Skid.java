package com.pantsareoffensive.lunchgistics.GameObjects;


import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;

public class Skid extends BasicInventory {

    public Skid(Vector2 pos) {
        super(ArtManager.ITEMS_ATLAS.findRegion("skid_t"), pos);
        this.inventory = new GameObject[4];
        objHeight = 28;
        objWidth = 28;
    }

    @Override
    public boolean canMoveByHand(){
        return isEmpty();
    }


}
