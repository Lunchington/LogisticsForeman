package com.pantsareoffensive.lunchgistics.GameObjects;

import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;
import com.pantsareoffensive.lunchgistics.map.World;

public class BoxSmall extends Box {
    public BoxSmall(World world, Vector2 pos) {
        super(world, ArtManager.ITEMS_ATLAS.findRegion("box_s"), pos);
        setObjSize(8,8);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public int getWeight() {
        return 2;
    }
}
