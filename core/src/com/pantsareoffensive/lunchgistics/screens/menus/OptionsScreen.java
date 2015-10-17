package com.pantsareoffensive.lunchgistics.screens.menus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.pantsareoffensive.lunchgistics.LogisticsForeman;
import com.pantsareoffensive.lunchgistics.managers.MusicManager.GameMusic;
import com.pantsareoffensive.lunchgistics.managers.SoundManager.GameSound;


public class OptionsScreen extends BaseMenuScreen {
    private Label musicVolumeValue;
    private Label soundVolumeValue;

    public OptionsScreen(LogisticsForeman app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();

        table.defaults().spaceBottom(30);
        table.columnDefaults(0).padRight(0);

        table.add("Options").colspan(4).padTop(50).padRight(0);

        // Sound Check Box
        final CheckBox soundEffectsCheckbox = new CheckBox("", skin);

        soundEffectsCheckbox.setChecked(app.preferencesManager.isSoundEnabled());
        soundEffectsCheckbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean enabled = soundEffectsCheckbox.isChecked();
                app.preferencesManager.setSoundEnabled(enabled);
                app.soundManager.setEnabled(enabled);
                app.soundManager.play(GameSound.CLICK);
            }
        });

        // Sound Slider
        Slider soundVolumeSlider = new Slider(0f, 1f, 0.1f, false, skin);
        soundVolumeSlider.setValue(app.preferencesManager.getSoundVolume());
        soundVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                app.preferencesManager.setSoundVolume(value);
                app.soundManager.setVolume(value);
                updateSoundVolumeLabel();
            }

        });

        soundVolumeValue = new Label("",skin);
        updateSoundVolumeLabel();

        table.row();
        table.add("Sound");
        table.add(soundEffectsCheckbox);
        table.add(soundVolumeSlider);
        table.add(soundVolumeValue).width(40);

        // Music Check Box
        final CheckBox musicCheckbox = new CheckBox("", skin);
        musicCheckbox.setChecked(app.preferencesManager.isMusicEnabled());
        musicCheckbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean enabled = musicCheckbox.isChecked();
                app.preferencesManager.setMusicEnabled(enabled);
                app.musicManager.setEnabled(enabled);
                app.soundManager.play(GameSound.CLICK);

                // if the music is now enabled, start playing the menu music
                if (enabled)app.musicManager.play(GameMusic.MENU);
            }
        });

        // Music Slider
        Slider musicVolumeSlider = new Slider(0f, 1f, 0.1f, false, skin);
        musicVolumeSlider.setValue(app.preferencesManager.getMusicVolume());
        musicVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                app.preferencesManager.setMusicVolume(value);
                app.musicManager.setVolume(value);
                updateMusicVolumeLabel();
            }

        });

        musicVolumeValue = new Label("", skin);
        updateMusicVolumeLabel();

        table.row();
        table.add("Music");
        table.add(musicCheckbox);
        table.add(musicVolumeSlider);
        table.add(musicVolumeValue).width(40);

        // back to Main
        TextButton backButton = new TextButton("Back to main menu", skin);
        backButton.addListener(new MenuButton(app) {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.setScreen(app.menuScreen);

            }
        });
        table.row();
        table.add(backButton).size(300, 45).colspan(4).padRight(0);
    }


    private void updateMusicVolumeLabel() {
        float volume = (app.preferencesManager.getMusicVolume() * 100);
        musicVolumeValue.setText(String.format("%1.0f%%", volume));
    }

    private void updateSoundVolumeLabel() {
        float volume = (app.preferencesManager.getSoundVolume() * 100);
        soundVolumeValue.setText(String.format("%1.0f%%", volume));
    }
}
