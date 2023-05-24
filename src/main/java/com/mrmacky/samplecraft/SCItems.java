package com.mrmacky.samplecraft;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SCItems {
    public static CreativeModeTab MOD_TAB;

    //Create DeferredRegister for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SampleCraft.MODID);

    //Register Items
    public static final RegistryObject<Item> SHRIMP = ITEMS.register(
            "shrimp",
            () -> new Item(new Item.Properties()));

    //Registration methods
    static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    //Create a Creative mode tab
    public static void registerTabs(CreativeModeTabEvent.Register event) {
        MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(SampleCraft.MODID, "tab"), builder -> builder
                .icon(() -> new ItemStack(SHRIMP.get()))
                .title(Component.translatable("tabs." + SampleCraft.MODID + ".tab"))
                .displayItems((featureFlagSet, tabOutput, bool) -> {
                    tabOutput.accept(new ItemStack(SHRIMP.get()));
                    tabOutput.accept(new ItemStack(SCBlocks.SHRIMP_BLOCK.get().asItem()));
                })
        );
    }

    //Add items to tabs
    public static void addItemsToTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(new ItemStack(SHRIMP.get()));
        }
    }

}
