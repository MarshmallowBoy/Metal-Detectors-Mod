package com.MetalDetectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MetalDetectorsMod.MODID);

    public static final RegistryObject<CreativeModeTab> Detector_Tab = CREATIVE_MODE_TABS.register("detector_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.MetalDetector1.get()))
                    .title(Component.translatable("creativetab.detector_tab"))
                    .displayItems(((pParam, pOutput) -> {
                        pOutput.accept(ModItems.MetalDetector1.get());
                        pOutput.accept(ModItems.MetalDetector2.get());
                        pOutput.accept(ModItems.MetalDetector3.get());
                        pOutput.accept(ModItems.MetalDetector4.get());
                        pOutput.accept(ModItems.MetalDetector5.get());
                        pOutput.accept(ModItems.MetalDetector6.get());
                    }))
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
