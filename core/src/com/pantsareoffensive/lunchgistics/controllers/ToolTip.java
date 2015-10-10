package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class ToolTip extends Label {

	public ToolTip(float centerX, float y) {
		super("TEST", new LabelStyle(new BitmapFont(), Color.WHITE));
		setSize(300, 30);
		setPosition(centerX - getWidth() / 2, y);
		setAlignment(Align.center);
	}
}
