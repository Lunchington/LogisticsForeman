package com.pantsareoffensive.lunchgistics.object;


import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Global;

public class Skid extends BasicInventory {

    public Skid(Vector2 pos) {
        super(Global.Art.ITEMS_ATLAS.findRegion("skids_t"), pos);
        this.inventory = new GameObject[4];
    }

    @Override
    public boolean canMovebyHand(){
        return isEmpty();
    }


}
