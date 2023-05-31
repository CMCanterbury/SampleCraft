package com.mrmacky.samplecraft;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class Yoink {

    public static void yeet(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == SCItems.SHRIMP.get()) {
                SampleCraft.LOGGER.debug("Player is Holding a Shrimp");
                event.getEntity().setDeltaMovement(0, 2, 0);
//                event.setCanceled(true);
            }
        }
    }

}
