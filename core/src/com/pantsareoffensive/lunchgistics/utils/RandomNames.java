package com.pantsareoffensive.lunchgistics.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RandomNames {

    private List<String> first;
    private List<String> last;

    private static RandomNames INSTANCE = null;

    public static RandomNames init() {
        RandomNames randomNames = new RandomNames();
        INSTANCE = randomNames;
        return randomNames;
    }

    public static RandomNames get() {
        return INSTANCE;
    }


    public RandomNames() {

        FileHandle file  = Gdx.files.internal("names_first.dat");
        String text = file.readString();
        String firstN[] = text.split("\\n");
        first =  new ArrayList<String>(Arrays.asList(firstN));

        file  = Gdx.files.internal("names_last.dat");
        text = file.readString();
        String lastN[] = text.split("\\n");
        last = new ArrayList<String>(Arrays.asList(lastN));

    }


    public String getName() {
        return first.get(MathUtils.random(first.size()-1)) + " " + last.get(MathUtils.random(last.size()-1));
    }
}
