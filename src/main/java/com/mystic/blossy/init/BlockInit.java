package com.mystic.blossy.init;

import com.mystic.blossy.Blossy;
import com.mystic.blossy.blockentities.plants.MoonflowerBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Blossy.MODID);
    public static final RegistryObject<MoonflowerBlock> MOONFLOWER = registerBlock("moonflower", MoonflowerBlock::new);


    private static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<B> block) {
        return registerMainTabBlock(name, block, b -> () -> new BlockItem(b.get(), new Item.Properties()));
    }

    private static <B extends Block, I extends BlockItem> RegistryObject<B> registerMainTabBlock(String name, Supplier<B> block, Function<RegistryObject<B>, Supplier<I>> item) {
        var reg = BLOCKS.register(name, block);
        CreativeTabInit.addToMainTab(ItemInit.ITEMS.register(name, () -> item.apply(reg).get()));
        return reg;
    }

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
