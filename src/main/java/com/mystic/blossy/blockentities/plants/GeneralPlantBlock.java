package com.mystic.blossy.blockentities.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class GeneralPlantBlock<T extends GeneralPlantBlockEntity<?>> extends BushBlock implements EntityBlock {

    private final RegistryObject<BlockEntityType<T>> type;

    public GeneralPlantBlock(RegistryObject<BlockEntityType<T>> type) {
        super(BlockBehaviour.Properties.of()
                .noOcclusion()
                .noCollission()
                .sound(SoundType.GRASS)
                .strength(0.3f, 0.5f)
                .randomTicks());
        this.type = type;
    }
    
    @Override
    public RenderShape getRenderShape(BlockState targetState) {
        return RenderShape.MODEL;
    }

    @Override
    protected boolean mayPlaceOn(BlockState targetState, BlockGetter getter, BlockPos targetPos) {
        return !targetState.getCollisionShape(getter, targetPos).getFaceShape(Direction.UP).isEmpty() || targetState.isFaceSturdy(getter, targetPos, Direction.UP);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return type.get().create(pos, state);
    }
}