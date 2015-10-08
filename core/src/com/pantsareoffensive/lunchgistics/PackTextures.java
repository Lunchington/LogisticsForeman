package com.pantsareoffensive.lunchgistics;


import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class PackTextures {
    public static void main (String[] args) throws Exception {
        TexturePacker.process("src/gui", "gui", "gui");
        TexturePacker.process("src/items", "items", "items");
        TexturePacker.process("src/tiles", "tiles", "tiles");
        TexturePacker.process("src/worker", "worker", "worker");


    }
}
