package com.HEN.Nujomod.GUI.menu;

import com.HEN.Nujomod.blocks.BlockImagination;
import com.HEN.Nujomod.blocks.entity.BlockImaginationEntity;
import com.HEN.Nujomod.inits.InitBlocks;
import com.HEN.Nujomod.inits.InitMenuType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockImaginationMenu extends AbstractContainerMenu {
    private static final int SLOT_COUNT = 5;
    private static final int SLOT_BLACK_DYE = 0;
    private static final int SLOT_CYAN_DYE = 1;
    private static final int SLOT_MAGENTA_DYE = 2;
    private static final int SLOT_YELLOW_DYE = 3;
    private static final int SLOT_PAPER = 4;
    private static final int DATA_COUNT = 6;

    public final BlockImaginationEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public BlockImaginationMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv,inv.player.level().getBlockEntity(extraData.readBlockPos()),new SimpleContainerData(5));

    }

    public BlockImaginationMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(InitMenuType.IMAGINATIONAL_BLOCK_MENU.get(), pContainerId);
        checkContainerSize(inv,5);
        checkContainerDataCount(data, 5);
        blockEntity = ((BlockImaginationEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        this.addSlot(new BlockImaginationMenu.BlackSlot(inv,0,44,17));
        this.addSlot(new BlockImaginationMenu.CyanSlot(inv,1,26,35));
        this.addSlot(new BlockImaginationMenu.MagentaSlot(inv,2,44,53));
        this.addSlot(new BlockImaginationMenu.PaperSlot(inv,4,44,35));
        this.addSlot(new BlockImaginationMenu.YellowSlot(inv,3,62,35));

        addPlayersInventory(inv);
        addPlayerHotbar(inv);


    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if(pIndex == 0){
                if (BlockImaginationMenu.BlackSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1,0,5,false)){
                        return ItemStack.EMPTY;
                    }
                } else if (BlockImaginationMenu.CyanSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1,1,6,false)){
                        return ItemStack.EMPTY;
                    }
                } else if (BlockImaginationMenu.MagentaSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1,2,7,false)){
                        return ItemStack.EMPTY;
                    }
                } else if (BlockImaginationMenu.YellowSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1,3,8,false)){
                        return ItemStack.EMPTY;
                    }
                } else if (BlockImaginationMenu.PaperSlot.mayPlaceItem(itemstack)) {
                    if (this.moveItemStackTo(itemstack1,4,9,false)){
                        return ItemStack.EMPTY;
                    }

                }else {
                    if(!this.moveItemStackTo(itemstack1,0,5,false)){
                        return ItemStack.EMPTY;
                    }
                }
            }
        }
        return itemstack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level,blockEntity.getBlockPos()),
                pPlayer, InitBlocks.IMAGINATIONAL_BLOCK.get());
    }



    private void addPlayersInventory(Inventory playerInventory) {
        for (int i=0;i<3;i++){
            for (int j=0;j<9;j++){
                this.addSlot(new Slot(playerInventory, j+i*9+9, 8+j*18, 84+i*18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i=0;i<9;i++){
            this.addSlot(new Slot(playerInventory, i, 8+i*18, 142));
        }
    }

    static class BlackSlot extends Slot {
        public BlackSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        public boolean mayPlace(ItemStack stack) {
            return mayPlaceItem(stack);
        }

        public static boolean mayPlaceItem(ItemStack stack) {
            return stack.is(Items.BLACK_DYE);
        }

        public int getMaxStackSize() {
            return 1;
        }
    }
    static class CyanSlot extends Slot{
        public CyanSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        public boolean mayPlace(ItemStack stack) {
            return mayPlaceItem(stack);
        }

        public static boolean mayPlaceItem(ItemStack stack) {
            return stack.is(Items.CYAN_DYE);
        }
        public int getMaxStackSize() {
            return 1;
        }
    }
    static class MagentaSlot extends Slot{
        public MagentaSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        public boolean mayPlace(ItemStack stack) {
            return mayPlaceItem(stack);
        }

        public static boolean mayPlaceItem(ItemStack stack) {
            return stack.is(Items.MAGENTA_DYE);
        }

        public int getMaxStackSize() {
            return 1;
        }
    }
    static class YellowSlot extends Slot{
        public YellowSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        public boolean mayPlace(ItemStack stack) {
            return mayPlaceItem(stack);
        }

        public static boolean mayPlaceItem(ItemStack stack) {
            return stack.is(Items.YELLOW_DYE);
        }

        public int getMaxStackSize() {
            return 1;
        }
    }
    static class PaperSlot extends Slot{
        public PaperSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        public boolean mayPlace(ItemStack stack) {
            return mayPlaceItem(stack);
        }

        public static boolean mayPlaceItem(ItemStack stack) {
            return stack.is(Items.PAPER);
        }

        public int getMaxStackSize() {
            return 1;
        }
    }
}
