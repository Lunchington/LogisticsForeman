package com.pantsareoffensive.lunchgistics.screens.menus;

import java.util.Locale;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.pantsareoffensive.lunchgistics.Application;
import com.pantsareoffensive.lunchgistics.gui.DefaultInputListener;
import com.pantsareoffensive.lunchgistics.systems.MusicManager.GameMusic;
import com.pantsareoffensive.lunchgistics.systems.SoundManager.GameSound;


public class OptionsScreen extends BaseMenuScreen {
    private Label musicVolumeValue;
    private Label soundVolumeValue;

    public OptionsScreen(Application _game) {
        super(_game);
    }

    @Override
    public void show() {
        super.show();

        Table table = super.getTable();

        table.defaults().spaceBottom(30);
        table.columnDefaults(0).padRight(0);

        table.add("Options").colspan(4).padTop(50).padRight(0);

        // Sound Check Box
        final CheckBox soundEffectsCheckbox = new CheckBox("", getSkin());

        soundEffectsCheckbox.setChecked(app.getPreferencesManager().isSoundEnabled());
        soundEffectsCheckbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean enabled = soundEffectsCheckbox.isChecked();
                app.getPreferencesManager().setSoundEnabled(enabled);
                app.getSoundManager().setEnabled(enabled);
                app.getSoundManager().play(GameSound.CLICK);
            }
        });

        // Sound Slider
        Slider soundVolumeSlider = new Slider(0f, 1f, 0.1f, false, getSkin());
        soundVolumeSlider.setValue(app.getPreferencesManager().getSoundVolume());
        soundVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                app.getPreferencesManager().setSoundVolume(value);
                app.getSoundManager().setVolume(value);
                updateSoundVolumeLabel();
            }

        });

        soundVolumeValue = new Label("", getSkin());
        updateSoundVolumeLabel();

        table.row();
        table.add("Sound");
        table.add(soundEffectsCheckbox);
        table.add(soundVolumeSlider);
        table.add(soundVolumeValue).width(40);

        // Music Check Box
        final CheckBox musicCheckbox = new CheckBox("", getSkin());
        musicCheckbox.setChecked(app.getPreferencesManager().isMusicEnabled());
        musicCheckbox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                boolean enabled = musicCheckbox.isChecked();
                app.getPreferencesManager().setMusicEnabled(enabled);
                app.getMusicManager().setEnabled(enabled);
                app.getSoundManager().play(GameSound.CLICK);

                // if the music is now enabled, start playing the menu music
                if (enabled) app.getMusicManager().play(GameMusic.MENU);
            }
        });

        // Music Slider
        Slider musicVolumeSlider = new Slider(0f, 1f, 0.1f, false, getSkin());
        musicVolumeSlider.setValue(app.getPreferencesManager().getMusicVolume());
        musicVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                app.getPreferencesManager().setMusicVolume(value);
                app.getMusicManager().setVolume(value);
                updateMusicVolumeLabel();
            }

        });

        musicVolumeValue = new Label("", getSkin());
        updateMusicVolumeLabel();

        table.row();
        table.add("Music");
        table.add(musicCheckbox);
        table.add(musicVolumeSlider);
        table.add(musicVolumeValue).width(40);

        // back to Main
        TextButton backButton = new TextButton("Back to main menu", getSkin());
        backButton.addListener(new DefaultInputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                app.getSoundManager().play(GameSound.CLICK);
                app.setScreen(new MenuScreen(app));

            }
        });
        table.row();
        table.add(backButton).size(300, 45).colspan(4).padRight(0);
    }

    private void updateMusicVolumeLabel() {
        float volume = (app.getPreferencesManager().getMusicVolume() * 100);
        musicVolumeValue.setText(String.format(Locale.US, "%1.0f%%", volume));
    }

    private void updateSoundVolumeLabel() {
        float volume = (app.getPreferencesManager().getSoundVolume() * 100);
        soundVolumeValue.setText(String.format(Locale.US, "%1.0f%%", volume));
    }
}
