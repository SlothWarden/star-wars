package com.starwars;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ShockBaton extends Item {
    public ShockBaton(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        BlockPos frontOfPlayer = user.blockPosition().relative(user.getDirection(), 4);
        BlockPos frontOfPlayer2 = user.blockPosition().relative(user.getDirection(), 5);
        BlockPos frontOfPlayer3 = user.blockPosition().relative(user.getDirection(), 6);
        BlockPos frontOfPlayer4 = user.blockPosition().relative(user.getDirection(), 7);
        BlockPos frontOfPlayer5 = user.blockPosition().relative(user.getDirection(), 8);
        BlockPos frontOfPlayer6 = user.blockPosition().relative(user.getDirection(), 9);
        BlockPos frontOfPlayer7 = user.blockPosition().relative(user.getDirection(), 10);
        BlockPos frontOfPlayer8 = user.blockPosition().relative(user.getDirection(), 11);


        // Spawn the lightning bolt.
        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        LightningBolt lightningBolt2 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        LightningBolt lightningBolt3 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);

        LightningBolt lightningBolt4 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        // Spawn the lightning bolt.
        LightningBolt lightningBolt5 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        LightningBolt lightningBolt6 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        LightningBolt lightningBolt7  = new LightningBolt(EntityType.LIGHTNING_BOLT, level);

        LightningBolt lightningBolt8 = new LightningBolt(EntityType.LIGHTNING_BOLT, level);


        lightningBolt.setPos(frontOfPlayer.getCenter());
        level.addFreshEntity(lightningBolt);
        lightningBolt2.setPos(frontOfPlayer2.getCenter());
        level.addFreshEntity(lightningBolt2);
        lightningBolt3.setPos(frontOfPlayer3.getCenter());
        level.addFreshEntity(lightningBolt3);
        lightningBolt4.setPos(frontOfPlayer4.getCenter());
        level.addFreshEntity(lightningBolt4);


        lightningBolt5.setPos(frontOfPlayer.getCenter());
        level.addFreshEntity(lightningBolt5);
        lightningBolt6.setPos(frontOfPlayer2.getCenter());
        level.addFreshEntity(lightningBolt6);
        lightningBolt7.setPos(frontOfPlayer3.getCenter());
        level.addFreshEntity(lightningBolt7);
        lightningBolt8.setPos(frontOfPlayer4.getCenter());
        level.addFreshEntity(lightningBolt8);


        return InteractionResult.SUCCESS;
    }
}