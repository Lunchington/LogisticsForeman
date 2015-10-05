package com.pantsareoffensive.lunchgistics.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pantsareoffensive.lunchgistics.Global;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;

import javax.xml.bind.annotation.XmlElementDecl;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Global.TITLE + " v" + Global.VERSION;

		config.width = Global.WIDTH;
		config.height = Global.HEIGHT;


		//TexturePacker.Settings settings = new TexturePacker.Settings();
		//TexturePacker.process(settings, "src/tiles", "tiles", "tiles");
		//TexturePacker.process(settings, "src/gui", "gui", "gui");

		new LwjglApplication(new LogisticsForeman(), config);
	}
}
