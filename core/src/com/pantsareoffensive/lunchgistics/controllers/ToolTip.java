package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class ToolTip extends Label {
	public ToolTip() {
		super("", new LabelStyle(new BitmapFont(), Color.WHITE));
		setAlignment(Align.center, Align.center);

	}

}
