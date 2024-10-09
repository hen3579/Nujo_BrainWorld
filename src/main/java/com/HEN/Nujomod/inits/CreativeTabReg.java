package com.HEN.Nujomod.inits;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.example.registry.ItemRegistry;

import static com.HEN.Nujomod.inits.InitItems.*;
import static com.HEN.Nujomod.inits.InitBlocks.*;

public class CreativeTabReg {
    public static final DeferredRegister<CreativeModeTab> TABS =DeferredRegister.create(Registries.CREATIVE_MODE_TAB,"nujo");
    public static final RegistryObject<CreativeModeTab> NUJO_GROUP_ITEM_TABS = TABS.register("nujo_item_group",() -> CreativeModeTab.builder()
            .title(Component.translatable("item.nujo.nujo_item_group"))
            .icon(()-> IMAGINATIONAL_CORE.get().getDefaultInstance())
            .displayItems((par, output) -> {
                output.accept(IMAGINATIONAL_CORE.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> NUJO_GROUP_TOOL_TABS = TABS.register("nujo_tool_group",() -> CreativeModeTab.builder()
            .title(Component.translatable("item.nujo.nujo_tool_group"))
            .icon(()-> MAGIC_PAINTBRUSH.get().getDefaultInstance())
            .displayItems((par, output) -> {
                output.accept(MAGIC_PAINTBRUSH.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> NUJO_GROUP_BLOCKS_TABS = TABS.register("nujo_block_group",() -> CreativeModeTab.builder()
            .title(Component.translatable("block.nujo.nujo_block_group"))
            .icon(()-> new ItemStack(IMAGINATIONAL_BLOCK.get()))
            .displayItems((par, output) -> {
                output.accept(IMAGINATIONAL_BLOCK.get());
            })
            .build());
}
