package com.pantsareoffensive.lunchgistics.object;

import com.pantsareoffensive.lunchgistics.Global;

public class Skid extends Entity {
    public Skid() {
        super(Global.Art.ITEMS_ATLAS.findRegion("skids_t"));
    }
}
