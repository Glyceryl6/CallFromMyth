package com.glyceryl6.myth.entity.monster;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Hunter extends HumanoidMob {

    public Hunter(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

}