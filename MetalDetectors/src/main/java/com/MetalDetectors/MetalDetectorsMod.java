package com.MetalDetectors;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MetalDetectorsMod.MODID)
public class MetalDetectorsMod {
    public static final String MODID = "metal_detectors_mod";

    public MetalDetectorsMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "metal_detector_mod-common.toml");
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
