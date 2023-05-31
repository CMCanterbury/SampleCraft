package com.mrmacky.samplecraft;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ShrimpBlock extends Block {
    public static final BooleanProperty ROTTEN = BooleanProperty.create("rotten");

    //Constructor
    public ShrimpBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ROTTEN, false));
    }

    //StepOn
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
//        double d0 = Math.abs(entity.getDeltaMovement().y);
//        if (d0 < 0.1D && !entity.isSteppingCarefully()) {
//            double d1 = 0.4D + d0 * 0.2D;
//            entity.setDeltaMovement(entity.getDeltaMovement().multiply(d1, 1.0D, d1));
//        }

//        double upMultiplier = (entity.getDeltaMovement().y > 0) ? 100.0D : -100.0D;

//        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0D, upMultiplier, 1.0D));

        if (!state.getValue(ROTTEN)) {
            entity.setDeltaMovement(0, 100, 0);
            level.setBlock(pos, state.setValue(ROTTEN, true), 3);
        }

        super.stepOn(level, pos, state, entity);
    }

    //Define Block States
    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ROTTEN);
    }

}
