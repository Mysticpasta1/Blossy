package com.mystic.blossy.init;

import com.mystic.blossy.Blossy;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Blossy.MODID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        var register = ITEMS.register(name, item);
        CreativeTabInit.addToMainTabItems(register);
        return register;
    }
}