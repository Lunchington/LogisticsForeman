package com.pantsareoffensive.lunchgistics.controllers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.FloatAction;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.managers.SoundManager;
import com.pantsareoffensive.lunchgistics.map.World;
import com.sun.javafx.binding.StringFormatter;


public class HudController {
    private Stage stage;
    private World world;
    private Main game;
    public Table topTable,bottomTable,iconsTable;
    public Skin skin;

    public ImageButton units,test1,test2,test3;

    public Label money, workers, day, toolTip;

    public HudController(Main game, World world, Stage stage) {
        this.stage = stage;
        this.game = game;
        this.world = world;
        this.skin = new Skin(Gdx.files.internal("gui/gui.json"));
        this.topTable = new Table(skin);
        this.bottomTable = new Table(skin);
        this.iconsTable = new Table(skin);

        init();

    }

    public void init() {
        //DEFAULTS--------------
        topTable.setFillParent(true);
        topTable.center().top();
        topTable.defaults().pad(5f);

        topTable.columnDefaults(0).left().minWidth(100f);
        topTable.columnDefaults(1).center().minWidth(100f);
        topTable.columnDefaults(2).right().minWidth(100f);

        bottomTable.setFillParent(true);
        bottomTable.right().bottom();
        bottomTable.defaults().pad(5f);

        iconsTable.setFillParent(true);
        iconsTable.left().bottom();
        iconsTable.defaults().pad(5f);
        //-------------------

        toolTip = new Label("",skin);

        workers = new Label("",skin.get("bg",LabelStyle.class));
        day = new Label("",skin.get("bg",LabelStyle.class));
        money = new Label("",skin.get("bg",LabelStyle.class));

        units = new ImageButton(skin.get("units",ImageButtonStyle.class));
        units.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y )
            {
                super.clicked(event,x,y);
                game.soundManager.play(SoundManager.GameSound.CLICK);
            }
        });

        topTable.add(day);
        topTable.add(money);
        topTable.add(workers);

        toolTip.setAlignment(Align.center);

        day.setAlignment(Align.center);
        money.setAlignment(Align.center);
        workers.setAlignment(Align.center);

        iconsTable.add(units);

        bottomTable.add(toolTip);

        stage.addActor(topTable);
        stage.addActor(bottomTable);
        stage.addActor(iconsTable);


    }

    public void setToolTip(String text) {
        toolTip.setText(text);
    }

    public void update(float delta) {
        day.setText(String.format("Day %s %s:%s (%sx)",world.getDay(),world.getHour(),world.getMinute(),world.getTimeMultiplier()));
        workers.setText("Workers: " +world.getWorkers().size());
        money.setText(String.format("$%s", world.getMoney()));
        stage.act(delta);


    }


}
