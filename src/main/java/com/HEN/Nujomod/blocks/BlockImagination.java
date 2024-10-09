package com.HEN.Nujomod.blocks;

import com.HEN.Nujomod.blocks.entity.BlockImaginationEntity;
import com.HEN.Nujomod.inits.InitBlockEntities;
import com.HEN.Nujomod.inits.InitBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkContext;
import net.minecraftforge.network.NetworkInitialization;
import net.minecraftforge.network.NetworkInstance;
import org.jetbrains.annotations.Nullable;

public class BlockImagination extends BaseEntityBlock {
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    protected BlockImagination(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(ACTIVATED, Boolean.valueOf(false)));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(ACTIVATED, Boolean.valueOf(false));
    }



    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level plevel, BlockState pState, BlockEntityType<T> pType) {
        if(plevel.isClientSide()){
            return null;
        }

        return createTickerHelper(pType, InitBlockEntities.IMAGINATIONAL_BLOCK.get(),(plevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(plevel1, pPos, pState1, pBlockEntity));
    }




    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BlockImaginationEntity(pPos, pState);
    }
}
