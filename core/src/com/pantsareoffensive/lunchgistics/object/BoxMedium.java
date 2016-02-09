package com.pantsareoffensive.lunchgistics.object;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Global;


public class BoxMedium extends Box {
    public BoxMedium(Vector2 pos) {
        super(Global.Art.ITEMS_ATLAS.findRegion("box_m"), pos);
        setObjSize(10,10);

    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public int getWeight() {
        return 4;
    }
}
