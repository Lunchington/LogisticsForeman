package com.pantsareoffensive.lunchgistics;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.pantsareoffensive.lunchgistics.ECS.components.MovementComponent;
import com.pantsareoffensive.lunchgistics.ECS.components.TextureComponent;
import com.pantsareoffensive.lunchgistics.ECS.components.TransformComponent;

public class EntityFactory {

    public static final Entity createWorker(int x, int y) {
        Entity ent = new Entity();

        TransformComponent transformComponent = new TransformComponent();
        TextureComponent textureComponent = new TextureComponent();
        MovementComponent movementComponent = new MovementComponent();

        transformComponent.position = new Vector2(x,y);

        ent.add(movementComponent);
        ent.add(textureComponent);
        ent.add(transformComponent);

        return ent;
    }

	
}