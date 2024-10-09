package com.HEN.Nujomod;

import com.HEN.Nujomod.inits.CreativeTabReg;
import com.HEN.Nujomod.inits.InitBlockEntities;
import com.HEN.Nujomod.inits.InitBlocks;
import com.HEN.Nujomod.inits.InitItems;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import javax.swing.text.html.parser.Entity;

@Mod("nujo")
public class nujo {
    public static final String MOD_ID = "nujo";
    public static final Logger LOGGER = LogUtils.getLogger();

    public nujo(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this.getClass());
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::ClientSetup);
        modEventBus.addListener(this::addCreative);


        InitBlocks.BLOCKS.register(modEventBus);
        InitItems.ITEMS.register(modEventBus);
        InitBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        CreativeTabReg.TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void modEventHandler(RegisterEvent event){
        //模组事件总线
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(InitItems.MAGIC_PAINTBRUSH);
            event.accept(InitBlocks.IMAGINATIONAL_BLOCK);
            event.accept(InitItems.IMAGINATIONAL_CORE);
        }
    }
    private static void forgeEventHandler(AttachCapabilitiesEvent<Entity> event) {
        //forge事件总线
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    private void ClientSetup(final FMLCommonSetupEvent event){}

}

