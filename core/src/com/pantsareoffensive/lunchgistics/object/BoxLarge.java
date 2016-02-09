package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Global;

/**
 * Created by abeha.
 */
public class BoxLarge extends Box {
    public BoxLarge(Vector2 pos) {
        super(Global.Art.ITEMS_ATLAS.findRegion("box_l"), pos);
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
