package com.pantsareoffensive.lunchgistics.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.model.Skid;


public class SkidActor extends ItemActor {

    public SkidActor (TextureRegion region, Vector2 position ) {
        super(region,position);
        this.model = new Skid();

    }


}
