package com.mystic.blossy.init;

import com.mystic.blossy.Blossy;
import com.mystic.blossy.blockentities.plants.MoonflowerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Blossy.MODID);

	public static final RegistryObject<BlockEntityType<MoonflowerBlockEntity>> MOONFLOWER = BLOCK_ENTITY_TYPES.register("moonflower", () -> BlockEntityType.Builder.of(MoonflowerBlockEntity::new, BlockInit.MOONFLOWER.get()).build(null));
		public static void init(IEventBus bus) {
		BLOCK_ENTITY_TYPES.register(bus);
	}

}