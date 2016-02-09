package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;


public class Worker extends Entity {

    public Worker(Vector2 pos) {
        super(Global.Art.WORKER_ATLAS.findRegion("head_f"),pos);
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

    }

    @Override
    public void render(SpriteBatch batch) {


        TextureRegion h = Global.Art.WORKER_ATLAS.findRegion("head_" + this.region);
        TextureRegion b = Global.Art.WORKER_ATLAS.findRegion("body_" + this.region);

        this.height = h.getRegionWidth();
        this.width = h.getRegionHeight();

        if ((flip) && !h.isFlipX()){
            h.flip(true,false);
            b.flip(true,false);
        }

        batch.draw(h,getX(),getY());
        batch.draw(b,getX(),getY());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
