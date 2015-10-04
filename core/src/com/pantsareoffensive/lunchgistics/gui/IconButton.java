package com.pantsareoffensive.lunchgistics.gui;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class IconButton extends ImageButton {
    private String tooltip;
    private Label label;

    public IconButton(String tooltip, Label info, Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
        this.tooltip = tooltip;
        this.label = info;
        this.addListener(new DefaultInputListener());
    }

    public void setLabel() {
        label.setText(getTooltip());
    }
    public String getTooltip() {
        return tooltip;
    }

}
