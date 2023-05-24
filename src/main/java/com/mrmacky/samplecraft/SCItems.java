package com.mrmacky.samplecraft;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SCItems {
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

    //Add items to tabs
    public static void addItemsToTabs(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(new ItemStack(SHRIMP.get()));
        }
    }

}
