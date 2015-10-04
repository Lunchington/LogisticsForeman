package com.pantsareoffensive.lunchgistics.utils;


import com.badlogic.gdx.math.MathUtils;

public class Util {

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = MathUtils.random(clazz.getEnumConstants().length-1);
        return clazz.getEnumConstants()[x];
    }

}
