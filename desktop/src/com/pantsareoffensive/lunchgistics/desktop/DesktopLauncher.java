package com.pantsareoffensive.lunchgistics.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.pantsareoffensive.lunchgistics.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Application.TITLE + " v" + Application.VERSION;

		config.width = Application.WIDTH;
		config.height = Application.HEIGHT;


		//TexturePacker.Settings settings = new TexturePacker.Settings();
		//TexturePacker.process(settings, "src/tiles", "tiles", "tiles");
		//TexturePacker.process(settings, "src/gui", "gui", "gui");

		new LwjglApplication(new Application(), config);
	}
}
