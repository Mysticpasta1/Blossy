package com.mystic.blossy.init;

import com.mystic.blossy.Blossy;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreativeTabInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Blossy.MODID);

    public static final List<Supplier<? extends ItemLike>> MAIN_BLOCKS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> MAIN_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.blossy.general"))
            .icon(BlockInit.MOONFLOWER.get().asItem()::getDefaultInstance)
            .withSearchBar(58)
            .displayItems((pParameters, pOutput) -> {
                MAIN_BLOCKS.forEach(itemLike -> pOutput.accept(itemLike.get()));
                MAIN_ITEMS.forEach(itemLike -> pOutput.accept(itemLike.get()));
            })
            .build());


    public static <T extends Item> void addToMainTab (RegistryObject<T> itemLike) {
        MAIN_BLOCKS.add(itemLike);
    }

    public static <T extends Item> void addToMainTabItems (RegistryObject<T> itemLike) {
        MAIN_ITEMS.add(itemLike);
    }

    public static void init(IEventBus bus){
        CREATIVE_TABS.register(bus);
    }
}
