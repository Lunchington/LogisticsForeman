package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BodyPart extends Actor{
    private String region;
    private WorkerActor parent;
    private TextureRegion textureRegion;

    public BodyPart(WorkerActor parent, String region) {
        setColor(Color.RED);

        this.region = region;
        this.parent = parent;
        this.textureRegion = parent.atlas.findRegion(region+"_f");
    }

    @Override
    public void draw(Batch batch, float alpha) {

        if (parent.getY() > parent.getPrevious().y) {
            textureRegion = parent.atlas.findRegion(region + "_b");
        }
        else {
            if (parent.getY() < parent.getPrevious().y) {
                textureRegion = parent.atlas.findRegion(region + "_f");
            }

            if (parent.getX() > parent.getPrevious().x) {
                textureRegion = parent.atlas.findRegion(region + "_s");
                if (textureRegion.isFlipX())
                    textureRegion.flip(true, false);
            }
            if (parent.getX() < parent.getPrevious().x) {
                textureRegion = parent.atlas.findRegion(region + "_s");
                if (!textureRegion.isFlipX())
                    textureRegion.flip(true, false);
            }
        }
        batch.draw(textureRegion,0,0);


    }

}
