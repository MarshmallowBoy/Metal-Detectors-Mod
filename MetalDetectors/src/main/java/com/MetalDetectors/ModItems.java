package com.MetalDetectors;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MetalDetectorsMod.MODID);
    public static final RegistryObject<Item> MetalDetector1 = ITEMS.register("metal_detector_1", () -> new MetalDetectorItem(new Item.Properties().durability(500), 1));
    public static final RegistryObject<Item> MetalDetector2 = ITEMS.register("metal_detector_2", () -> new MetalDetectorItem(new Item.Properties().durability(500), 2));
    public static final RegistryObject<Item> MetalDetector3 = ITEMS.register("metal_detector_3", () -> new MetalDetectorItem(new Item.Properties().durability(500), 3));
    public static final RegistryObject<Item> MetalDetector4 = ITEMS.register("metal_detector_4", () -> new MetalDetectorItem(new Item.Properties().durability(500), 4));
    public static final RegistryObject<Item> MetalDetector5 = ITEMS.register("metal_detector_5", () -> new MetalDetectorItem(new Item.Properties().durability(500), 5));
    public static final RegistryObject<Item> MetalDetector6 = ITEMS.register("metal_detector_6", () -> new MetalDetectorItem(new Item.Properties().durability(600), 6));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
