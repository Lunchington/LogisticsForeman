package com.pantsareoffensive.lunchgistics.object;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class BasicInventory extends GameObject implements IStorage {
    protected GameObject[] inventory;

    public BasicInventory(TextureRegion texture, Vector2 pos) {
        super(texture, pos);
    }

    @Override
    public int getInventorySpace() {
        return inventory.length;
    }

    @Override
    public boolean hasSpace() {
        for (GameObject g: inventory) {
            if (g == null)
                return true;
        }
        return false;
    }

    @Override
    public boolean canInsert(GameObject obj) {
        return false;
    }

    @Override
    public boolean canRemove(GameObject obj) {
        return false;
    }

    @Override
    public void putInventory(GameObject obj) {

    }

    public int getAvailableSpace() {
        int i = 0;
        for (GameObject g: inventory) {
            if(g== null)
                i++;
        }
        return i;
    }

    public boolean isEmpty() {
        for (GameObject g: inventory) {
            if(g != null)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Space: " + getAvailableSpace() + "/" + getInventorySpace();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean canMoveByHand() {
        return true;
    }

    @Override
    public int getWeight() {
        return 0;
    }

}
