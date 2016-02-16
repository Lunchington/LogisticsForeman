package com.pantsareoffensive.lunchgistics.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.pantsareoffensive.lunchgistics.Main;
import com.pantsareoffensive.lunchgistics.gui.UIButton;
import com.pantsareoffensive.lunchgistics.managers.ArtManager;
import com.pantsareoffensive.lunchgistics.map.World;


public class HudController {
    private Stage stage;
    private World world;
    private Main game;
    public Table timeTable,moneyTable,infoTable,iconsTable;
    public Skin skin;

    public UIButton units;

    public Label money, workers, day, toolTip;


    public HudController(Main game, World world, Stage stage) {
        this.stage = stage;
        this.game = game;
        this.world = world;
        this.skin = ArtManager.GUI_SKIN;

        this.timeTable = new Table(skin);
        this.moneyTable = new Table(skin);

        this.infoTable = new Table(skin);
        this.iconsTable = new Table(skin);


        init();

    }

    public void init() {
        skin.getFont("default-font").getData().markupEnabled = true;
        skin.getFont("small-font").getData().markupEnabled = true;

        //DEFAULTS--------------
        timeTable.setFillParent(true);
        timeTable.top().left();
        timeTable.defaults().pad(5f);

        moneyTable.setFillParent(true);
        moneyTable.top().right();
        moneyTable.defaults().pad(5f);

        infoTable.setFillParent(true);
        infoTable.bottom().right();
        infoTable.defaults().pad(5f);

        iconsTable.setFillParent(true);
        iconsTable.bottom().left();
        iconsTable.defaults().pad(5f);


        //-------------------


        toolTip = new Label("",skin);

        workers = new Label("",skin);
        day = new Label("",skin);
        money = new Label("",skin);

        units = new UIButton(game, skin,"units","Units");

        timeTable.add(day);
        timeTable.add(workers);

        moneyTable.add(money);

        toolTip.setAlignment(Align.center);

        day.setAlignment(Align.center);
        money.setAlignment(Align.center);
        workers.setAlignment(Align.center);


        iconsTable.add(units);

        infoTable.add(toolTip);

        stage.addActor(timeTable);
        stage.addActor(moneyTable);

        stage.addActor(iconsTable);
        stage.addActor(infoTable);


    }

    public void setToolTip(String text) {
        toolTip.setText(text);
    }

    public void update(float delta) {
        day.setText(String.format("Day %s %s:%s [GREEN](%sx)",world.getDay(),world.getHour(),world.getMinute(),world.getTimeMultiplier()));
        workers.setText("Workers: " +world.getWorkers().size());
        money.setText(String.format("$%s", world.getMoney()));
        stage.act(delta);


    }


}
