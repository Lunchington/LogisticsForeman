package com.pantsareoffensive.lunchgistics.object;

public interface IInventoryObject {
    //How many inventory spaces it takes up
    int getSize();

    //can you move it by hand?
    boolean canMovebyHand();

    //how heavy is it?
    int getWeight();

}
