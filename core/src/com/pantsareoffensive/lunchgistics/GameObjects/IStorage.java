package com.pantsareoffensive.lunchgistics.GameObjects;

public interface IStorage extends IInventoryObject{
    int getInventorySpace();
    boolean hasSpace();
    boolean canInsert(GameObject obj);
    boolean canRemove(GameObject obj);
    void putInventory(GameObject obj);
}
