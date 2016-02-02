package com.pantsareoffensive.lunchgistics.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pantsareoffensive.lunchgistics.Global;

public class Worker extends Entitiy {
    public Worker() {
        super(Global.Art.WORKER_ATLAS.findRegion("head_f"));
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(Global.Art.WORKER_ATLAS.findRegion("head_f"),position.x-16,position.y-16);
        batch.draw(Global.Art.WORKER_ATLAS.findRegion("body_f"),position.x-16,position.y-16);
    }
}
