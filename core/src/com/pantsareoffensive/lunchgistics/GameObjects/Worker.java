package com.pantsareoffensive.lunchgistics.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;
import com.pantsareoffensive.lunchgistics.map.World;
import com.pantsareoffensive.lunchgistics.utils.RandomNames;


public class Worker extends Entity {

    public Worker(World world, Vector2 pos) {
        super(world, ArtManager.WORKER_ATLAS.findRegion("worker_f"),pos);
        this.atlas = (ArtManager.WORKER_ATLAS);
        this.region ="f";
        this.name = RandomNames.getInstance().getName();
        this.objWidth = 20;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        this.position.x += 50f*  delta * world.getTimeMultiplier();
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
        texture = ArtManager.WORKER_ATLAS.findRegion("worker_" + this.region);

        if(flip && !texture.isFlipX())
            texture.flip(true,false);

    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
        font.draw(batch,name, getX() - name.length(),getBottom() + 16);

    }

    @Override
    public String toString() {
        return this.name;
    }
}
