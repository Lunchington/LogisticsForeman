package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;

public class BoxSmall extends Box {
    public BoxSmall(Vector2 pos) {
        super(ArtManager.ITEMS_ATLAS.findRegion("box_s"), pos);
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
