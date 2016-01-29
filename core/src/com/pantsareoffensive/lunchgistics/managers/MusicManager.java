package com.pantsareoffensive.lunchgistics.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;

public class MusicManager implements Disposable {
    private GameMusic musicBeingPlayed;
    private float volume = 1f;
    private boolean enabled = true;

    private static MusicManager INSTANCE = null;

    public static  MusicManager getInstance() {
        if (INSTANCE == null) {
            synchronized (MusicManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MusicManager();
                }
            }
        }
        return INSTANCE;
    }

    private  MusicManager() {}

    public enum GameMusic {
        MENU("sounds/menuLoop.mp3"),
        GAME("sounds/gameLoop.mp3");

        private String fileName;
        private Music musicResource;

        GameMusic(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }

        public Music getMusicResource() {
            return musicResource;
        }

        public void setMusic(Music musicBeingPlayed) {
            this.musicResource = musicBeingPlayed;
        }
    }


    public void play(GameMusic music) {
        if (!enabled) return;

        if (musicBeingPlayed == music) return;


        stop();

        FileHandle musicFile = Gdx.files.internal(music.getFileName());
        Music musicResource = Gdx.audio.newMusic(musicFile);
        musicResource.setVolume(volume);
        musicResource.setLooping(true);
        musicResource.play();

        musicBeingPlayed = music;
        musicBeingPlayed.setMusic(musicResource);

    }

    /**
     * Stops and disposes the current music being played, if any.
     */
    public void stop() {
        if (musicBeingPlayed != null) {
            Music musicResource = musicBeingPlayed.getMusicResource();
            musicResource.stop();
            musicResource.dispose();
            musicBeingPlayed = null;
        }
    }

    public void setVolume(float volume) {

        // check and set the new volume
        if (volume < 0 || volume > 1f) { throw new IllegalArgumentException("The volume must be inside the range: [0,1]"); }
        this.volume = volume;

        // if there is a music being played, change its volume
        if (musicBeingPlayed != null) {
            musicBeingPlayed.getMusicResource().setVolume(volume);
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        // if the music is being deactivated, stop any music being played
        if (!enabled) {
            stop();
        }
    }

    @Override
    public void dispose() {
        stop();
    }

}
