package com.pantsareoffensive.lunchgistics.managers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.IntMap;
import com.pantsareoffensive.lunchgistics.screens.GamePlayScreen;
import com.pantsareoffensive.lunchgistics.screens.SplashScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.MenuScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.NewGameScreen;
import com.pantsareoffensive.lunchgistics.screens.menus.OptionsScreen;

public class ScreenManager {

    private Game game;
    private IntMap<Screen> screens;

    private static ScreenManager INSTANCE = null;

    public static ScreenManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ScreenManager();
        return INSTANCE;
    }

    public void init(Game game ) {
        screens = new IntMap<Screen>();
        this.game = game;
    }

    private ScreenManager() {}

    public void show(GameScreens screen) {
        if (screen == null) return;
        if(!screens.containsKey(screen.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        game.setScreen(screens.get(screen.ordinal()));
    }

    public void dispose(GameScreens screen) {
        if (!screens.containsKey(screen.ordinal())) return;
        screens.remove(screen.ordinal()).dispose();
    }

    public void dispose() {
        for (com.badlogic.gdx.Screen screen : screens.values()) {
            screen.dispose();
        }
        screens.clear();
        INSTANCE = null;
    }


    public Screen getScreen(GameScreens screen) {
        return screens.get(screen.ordinal());
    }




    public enum GameScreens {

        SPLASH {
            @Override
            protected com.badlogic.gdx.Screen getScreenInstance() {
                return new SplashScreen();
            }
        },

        MAIN_MENU {
            @Override
            protected com.badlogic.gdx.Screen getScreenInstance() {
                return new MenuScreen();
            }
        },

        OPTIONS {
            @Override
            protected com.badlogic.gdx.Screen getScreenInstance() {
                return new OptionsScreen();
            }
        },
        GAME {
            @Override
            protected com.badlogic.gdx.Screen getScreenInstance() {
                return new GamePlayScreen();
            }
        },

        NEW_GAME {
            @Override
            protected com.badlogic.gdx.Screen getScreenInstance() {
                return new NewGameScreen();
            }
        };

        protected abstract com.badlogic.gdx.Screen getScreenInstance();

    }
}

