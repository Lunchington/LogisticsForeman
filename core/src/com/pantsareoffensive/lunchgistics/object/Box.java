package com.pantsareoffensive.lunchgistics.object;

import com.pantsareoffensive.lunchgistics.Global;

public class Box extends GameObject {
    public Box() {
        super(Global.Art.ITEMS_ATLAS.findRegion("box_s"));
    }

    @Override
    public String toString() {
        return "Small Box";
    }
}
