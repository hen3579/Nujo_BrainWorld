package com.HEN.Nujomod.inits;

import com.HEN.Nujomod.GUI.menu.BlockImaginationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitMenuType {
    public static final DeferredRegister<MenuType<?>> MENUS=
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, "nujo");

    public static final RegistryObject<MenuType<BlockImaginationMenu>> IMAGINATIONAL_BLOCK_MENU =  registerMenuType("block_imagination_menu", BlockImaginationMenu::new);

    public static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory)
    {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
