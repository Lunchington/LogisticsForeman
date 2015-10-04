package com.pantsareoffensive.lunchgistics.gui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class DefaultInputListener extends InputListener {

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        System.out.println("down");

        return true;
    }

    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        System.out.println("Over");

        if (event.getListenerActor() instanceof IconButton) {
            
            System.out.println(((IconButton) event.getListenerActor()).getTooltip());
            ((IconButton) event.getListenerActor()).setLabel();
        }

    }

}
