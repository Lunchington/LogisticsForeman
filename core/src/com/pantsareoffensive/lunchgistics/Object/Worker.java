package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pantsareoffensive.lunchgistics.Global;


public class Worker extends Entity {

    public Worker() {
        super();
        this.atlas = (Global.Art.WORKER_ATLAS);
        this.region ="f";
    }

    @Override
    public void update(float delta) {
        position.x -= 50*delta;

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
        prevPosition = position.cpy();

    }

    @Override
    public void render(SpriteBatch batch) {


        TextureRegion h = Global.Art.WORKER_ATLAS.findRegion("head_" + this.region);
        TextureRegion b = Global.Art.WORKER_ATLAS.findRegion("body_" + this.region);

        if ((flip) && !h.isFlipX()){
            h.flip(true,false);
            b.flip(true,false);
        }

        batch.draw(h,position.x-16,position.y-16);
        batch.draw(b,position.x-16,position.y-16);
    }
}
