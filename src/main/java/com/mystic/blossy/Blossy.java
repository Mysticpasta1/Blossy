package com.mystic.blossy;

import com.mystic.blossy.init.BlockEntityInit;
import com.mystic.blossy.init.BlockInit;
import com.mystic.blossy.init.CreativeTabInit;
import com.mystic.blossy.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Blossy.MODID)
public class Blossy {
    public static final String MODID = "blossy";

    public Blossy(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        ItemInit.init(bus);
        BlockInit.init(bus);
        BlockEntityInit.init(bus);
        CreativeTabInit.init(bus);
    }
}
