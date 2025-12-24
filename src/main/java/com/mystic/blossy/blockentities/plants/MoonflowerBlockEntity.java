package com.mystic.blossy.blockentities.plants;

import com.mystic.blossy.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class MoonflowerBlockEntity extends GeneralPlantBlockEntity<MoonflowerBlockEntity> {
    public MoonflowerBlockEntity(BlockPos targetPos, BlockState targetState) {
        super(BlockEntityInit.MOONFLOWER, "moonflower_controller", targetPos, targetState);
    }
}