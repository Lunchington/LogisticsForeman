package com.pantsareoffensive.lunchgistics.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomNames {

    private List<String> first = new ArrayList<String>();
    private List<String> last = new ArrayList<String>();

    public RandomNames() {

        FileHandle file  = Gdx.files.internal("names_first.dat");
        try {
            Scanner s = new Scanner(file.file());
            while (s.hasNext()){
                first.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        file  = Gdx.files.internal("names_last.dat");
        try {
            Scanner s = new Scanner(file.file());
            while (s.hasNext()){
                last.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return first.get(MathUtils.random(first.size()-1)) + " " + last.get(MathUtils.random(last.size()-1));
    }
}
