package com.pantsareoffensive.lunchgistics.map;

public class GameWorld {
    private static GameWorld INSTANCE = null;
    public static GameWorld get() { return INSTANCE; }

   // public GameMap map;


    public GameWorld() {

    }

    public  static void init(GameWorld world) { INSTANCE = world; }
/*
    public void drawDebug() {
        if (!LogisticsForeman.DEV_MODE)
            return;

        app.font.draw(app.batch, "MOUSE X: " + Gdx.input.getX() + " Y: " + Gdx.input.getY(), 16, LogisticsForeman.HEIGHT - 16);

        Vector3 wCoords =  app.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        app.font.draw(app.batch, "WORLD X: " + wCoords.x + " Y: " + wCoords.y, 16, LogisticsForeman.HEIGHT - 16*2);

        String leftPushed = "FALSE";
        String rightPushed = "FALSE";

        if (Gdx.input.isButtonPressed(0)) {
            leftPushed = "TRUE";
        }

        if (Gdx.input.isButtonPressed(1)) {
            rightPushed = "TRUE";
        }
        app.font.draw(app.batch,
                "LEFT BUTTON PRESS: " + leftPushed +
                        " RIGHT BUTTON PRESS: " + rightPushed
                , 16, LogisticsForeman.HEIGHT - 16 * 3);
    }
 */
}
