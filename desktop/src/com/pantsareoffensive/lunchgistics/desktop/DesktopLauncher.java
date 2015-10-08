package com.pantsareoffensive.lunchgistics.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Global.TITLE + " v" + Global.VERSION;

		config.width = Global.WIDTH;
		config.height = Global.HEIGHT;


		//PackTextures.Settings settings = new PackTextures.Settings();
		//PackTextures.process(settings, "src/tiles", "tiles", "tiles");
		//PackTextures.process(settings, "src/gui", "gui", "gui");

		new LwjglApplication(new LogisticsForeman(), config);
	}
}
