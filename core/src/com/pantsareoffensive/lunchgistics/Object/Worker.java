package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;


public class Worker extends Entity {

    public Worker(Vector2 pos) {
        super(Global.Art.WORKER_ATLAS.findRegion("worker_f"),pos);
        this.atlas = (Global.Art.WORKER_ATLAS);
        this.region ="f";
        this.name = RandomNames.getInstance().getName();
        this.objWidth = 20;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (position.y > prevPosition.y)
            region = "b";
        else {
            if (position.y < prevPosition.y) {
                region = "f";
            }

            if (position.x > prevPosition.x) {
                region = "s";
                flip = false;

            }

            if (position.x < prevPosition.x) {
                region = "s";
                flip = true;
            }
        }
        texture = Global.Art.WORKER_ATLAS.findRegion("worker_" + this.region);

        if(flip && !texture.isFlipX())
            texture.flip(true,false);

    }

    @Override
    public String toString() {
        return this.name;
    }
}
