package com.pantsareoffensive.lunchgistics.model;

import com.badlogic.ashley.core.Entity;
import com.pantsareoffensive.lunchgistics.model.components.JobComponent;

public class Worker extends Entity {
    public  Worker() {
        add(new JobComponent());

    }
}
