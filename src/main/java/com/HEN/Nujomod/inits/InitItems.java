package com.HEN.Nujomod.inits;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.HEN.Nujomod.items.Materials.*;
import com.HEN.Nujomod.items.Tools.*;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"nujo");

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> MAGIC_PAINTBRUSH = ITEMS.register("magic_paintbrush", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMAGINATIONAL_CORE = ITEMS.register("imaginational_core", () -> new Item(new Item.Properties()));
}
