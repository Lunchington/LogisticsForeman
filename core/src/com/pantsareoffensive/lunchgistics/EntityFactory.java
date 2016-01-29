package com.pantsareoffensive.lunchgistics;


import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager;
import com.pantsareoffensive.lunchgistics.view.SkidActor;
import com.pantsareoffensive.lunchgistics.view.WorkerActor;

public class EntityFactory {


    public static void addWorker(Vector2 position) {
        WorkerActor e = new WorkerActor(Global.Art.WORKER_ATLAS, position);
        GamePlayScreen  gScreen = (GamePlayScreen) ScreenManager.getInstance().getScreen(ScreenManager.GameScreens.GAME);
        gScreen.addtoEngine(e);

    }

    public static void addSkid(Vector2 position) {
        SkidActor e = new SkidActor(Global.Art.ITEMS_ATLAS.findRegion("skids_t"),position);
        GamePlayScreen  gScreen = (GamePlayScreen) ScreenManager.getInstance().getScreen(ScreenManager.GameScreens.GAME);
        gScreen.addtoEngine(e);
    }

}
