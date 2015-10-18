package com.pantsareoffensive.lunchgistics.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;
import com.pantsareoffensive.lunchgistics.managers.SoundManager.GameSound;
import com.pantsareoffensive.lunchgistics.utils.LRUCache;
import com.pantsareoffensive.lunchgistics.utils.LRUCache.CacheEntryRemovedListener;

public class SoundManager implements CacheEntryRemovedListener<GameSound, Sound>, Disposable {
    /**
     * The available sound files.
     */
    public enum GameSound {
        CLICK("sounds/click.wav");

        private final String fileName;

        GameSound(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    /**
     * The volume to be set on the sound.
     */
    private float volume = 1f;

    /**
     * Whether the sound is enabled.
     */
    private boolean enabled = true;

    /**
     * The sound cache.
     */
    private final LRUCache<GameSound, Sound> soundCache;

    /**
     * Creates the sound manager.
     */
    public SoundManager() {
        soundCache = new LRUCache<SoundManager.GameSound, Sound>(10);
        soundCache.setEntryRemovedListener(this);
    }

    /**
     * Plays the specified sound.
     */
    public void play(GameSound sound) {
        // check if the sound is enabled
        if (!enabled) return;

        // try and get the sound from the cache
        Sound soundToPlay = soundCache.get(sound);
        if (soundToPlay == null) {
            FileHandle soundFile = Gdx.files.internal(sound.getFileName());
            soundToPlay = Gdx.audio.newSound(soundFile);
            soundCache.add(sound, soundToPlay);
        }

        soundToPlay.play(volume);
    }

    /**
     * Sets the sound volume which must be inside the range [0,1].
     */
    public void setVolume(float volume) {

        if (volume < 0 || volume > 1f) { throw new IllegalArgumentException("The volume must be inside the range: [0,1]"); }
        this.volume = volume;
    }

    /**
     * Enables or disabled the sound.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // EntryRemovedListener implementation

    @Override
    public void notifyEntryRemoved(GameSound key, Sound value) {
        value.dispose();
    }

    /**
     * Disposes the sound manager.
     */
    public void dispose() {
        for (Sound sound : soundCache.retrieveAll()) {
            sound.stop();
            sound.dispose();
        }
    }
}
