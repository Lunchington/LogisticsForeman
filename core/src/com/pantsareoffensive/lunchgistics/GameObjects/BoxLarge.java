package com.pantsareoffensive.lunchgistics.GameObjects;

import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;
import com.pantsareoffensive.lunchgistics.map.World;


public class BoxLarge extends Box {
    public BoxLarge(World world, Vector2 pos) {
        super(world, ArtManager.ITEMS_ATLAS.findRegion("box_l"), pos);
        setObjSize(14,14);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public int getWeight() {
        return 6;
    }

}
