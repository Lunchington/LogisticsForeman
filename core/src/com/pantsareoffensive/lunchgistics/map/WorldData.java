package com.pantsareoffensive.lunchgistics.map;

import com.badlogic.gdx.math.MathUtils;

public class WorldData {
    private float time  = 0;
    private float lastMinute = 1;

    private int day = 0;
    private int hour = 0;
    private int minute =0;

    private int money = 0;

    private int timeMultiplier = 1;
    private int speed = 1;

    public int getTimeElapsed() {
        return (int) Math.floor(time) +1;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setTime(float delta) {
        this.time += delta * timeMultiplier;

        if (getTimeElapsed() - lastMinute >= 1) {
            minute += 1;
            lastMinute = time;
        }

        if (minute >= 60) {
            hour += 1;
            minute = 0;
        }
        if (hour >= 24) {
            day += 1;
            hour = 0;
            minute = 0;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDay() {
        return day;
    }

    public void increaseSpeed(int s) {
        speed += s;
        speed = MathUtils.clamp(speed,1,5);

        timeMultiplier = speed * speed;
    }

    public int getTimeMultiplier() {
        return timeMultiplier;
    }

}
