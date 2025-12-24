package com.mystic.blossy.client;

import com.mystic.blossy.Blossy;
import com.mystic.blossy.blockentities.plants.GeneralPlantBlockEntity;
import com.mystic.blossy.blockentities.renderers.GeneralPlantRenderer;
import com.mystic.blossy.init.BlockEntityInit;
import com.mystic.blossy.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib.GeckoLib;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = Blossy.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientInit {
    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        GeckoLib.initialize();
        registerPlantRenderer(BlockEntityInit.MOONFLOWER, "moonflower");

        registerBlockRenderLayers(RenderType.cutout(),
                BlockInit.MOONFLOWER.get()
        );
    }

    private static <T extends GeneralPlantBlockEntity<T>> void registerPlantRenderer(RegistryObject<BlockEntityType<T>> registryObject, String name) {
        BlockEntityRenderers.register(registryObject.get(), pContext -> new GeneralPlantRenderer<T>(name));
    }

    private static void registerBlockRenderLayers(RenderType layer, Block... blocks) {
        Stream.of(blocks).forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, layer));
    }
}
