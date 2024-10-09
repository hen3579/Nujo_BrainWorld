package com.HEN.Nujomod.blocks.entity;

import com.HEN.Nujomod.GUI.menu.BlockImaginationMenu;
import com.HEN.Nujomod.inits.InitBlockEntities;
import com.HEN.Nujomod.inits.InitBlockEntities.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockImaginationEntity extends BlockEntity implements MenuProvider {
    protected static final int SLOT_INPUT = 0;
    private final ItemStackHandler itemHandler = new ItemStackHandler(5);
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    public BlockImaginationEntity(BlockPos pBlockPos, BlockState pBlockState){
        super(InitBlockEntities.IMAGINATIONAL_BLOCK.get(), pBlockPos, pBlockState);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        return super.getCapability(cap);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerID, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    public void tick(Level plevel, BlockPos pPos, BlockState pState, BlockImaginationEntity pBlockEntity) {
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        BlockPos blockPos;
    }
    
}
