package com.pantsareoffensive.lunchgistics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.ScreenManager.STATE;
import com.pantsareoffensive.lunchgistics.map.Tile;
import com.pantsareoffensive.lunchgistics.object.*;
import com.pantsareoffensive.lunchgistics.map.GameMap;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;

public class GameInput extends InputAdapter {
    private GamePlayScreen screen;

    private Vector2 clicked;
    private GameObject selected;

    private Rectangle clickRect;

    private Main game;
    private GameMap map;

    public GameInput(Main game, GamePlayScreen screen) {
        this.game = game;
        this.screen = screen;
        this.map = screen.getWorld();
    }

    @Override
    public boolean keyUp(int key) {
        Vector2 pos = map.getView().unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
        switch (key) {
            case Input.Keys.ESCAPE:
                game.screenManager.setScreen(STATE.MAIN_MENU);
                return true;
            case Input.Keys.NUM_1:
                map.add(new Worker(pos));
                return true;
            case Input.Keys.NUM_2:
                map.add(new Skid(pos));
                return true;
            case Input.Keys.NUM_3:
                map.add(new BoxSmall(pos));
            case Input.Keys.NUM_4:
                map.add(new BoxMedium(pos));
                return true;
            case Input.Keys.NUM_5:
                map.add(new BoxLarge(pos));
                return true;
            case Input.Keys.NUM_6:
                map.setTile(pos,Tile.WALL);
                return true;
            case Input.Keys.F5:
                game.toggleDevMode();
            default:
                return false;
        }
    }

    @Override
    public boolean keyDown(int key) {
        switch (key) {
            default:
                return false;
        }
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            clicked = map.getView().unproject(new Vector2(x,y));

            GameObject oldSelected = selected;
            selected = map.getObjectAtMouse(clicked);

            clickRect = calcClickRect(x,y);

            if(oldSelected != null)
                oldSelected.setSelected(false);

            String t ="";
            if(selected != null) {
                selected.setSelected(true);
                t = selected.toString();
            }

            screen.getHud().setToolTip(t);
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            clicked = null;
            clickRect = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged (int screenX, int screenY, int pointer) {
        if(clicked != null) {
            clickRect = calcClickRect(screenX,screenY);
            return true;
        }
        return false;
    }

    public Vector2 getClicked() { return clicked;}

    public GameObject getSelected() { return selected;}

    public Rectangle calcClickRect() {
        return calcClickRect(Gdx.input.getX(), Gdx.input.getY());
    }

    public Rectangle calcClickRect(int screenX, int screenY) {
        Vector2 newVec = getClicked().cpy();
        Vector2 mPos = map.getView().unproject(new Vector2(screenX, screenY));
        Vector2 drawVec = newVec.cpy();

        float w;
        float h;

        if (newVec.x > mPos.x) {
            drawVec.x = mPos.x;
            w = newVec.x - mPos.x;
        } else
            w = mPos.x - newVec.x;

        if (newVec.y > mPos.y) {
            drawVec.y = mPos.y;
            h = newVec.y - mPos.y;
        }else
            h = mPos.y - newVec.y;

        return new Rectangle(drawVec.x,drawVec.y,w,h);
    }

    public Rectangle getClickRect() {
        return clickRect;
    }


    public void setClickedRect() { clickRect = calcClickRect(); }
}
