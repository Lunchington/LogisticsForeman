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

		config.vSyncEnabled = false; // Setting to false disables vertical sync
		config.foregroundFPS = 0; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 0; // Setting to 0 disables background fps throttling

		new LwjglApplication(new LogisticsForeman(), config);
	}
}
