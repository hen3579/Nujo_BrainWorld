package com.HEN.Nujomod.inits;

import com.HEN.Nujomod.blocks.BlockImagination;
import com.HEN.Nujomod.blocks.entity.BlockImaginationEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("DataFlowIssue")
public class InitBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "nujo");

    public static final RegistryObject<BlockEntityType<BlockImaginationEntity>> IMAGINATIONAL_BLOCK = BLOCK_ENTITIES.register("block_imagination", () -> BlockEntityType.Builder.of(BlockImaginationEntity::new, InitBlocks.IMAGINATIONAL_BLOCK.get()).build(null));

}
