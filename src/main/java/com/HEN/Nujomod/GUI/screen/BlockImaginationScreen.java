package com.HEN.Nujomod.GUI.screen;

import com.HEN.Nujomod.GUI.menu.BlockImaginationMenu;
import com.HEN.Nujomod.blocks.entity.BlockImaginationEntity;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class BlockImaginationScreen extends AbstractContainerScreen<BlockImaginationMenu> {
    private static final ResourceLocation IMAGINATION_GUI_LOCATION = new ResourceLocation("nujo", "textures/gui/container/imaginational_block.png");
    static final ResourceLocation BUTTON_SPRITE = new ResourceLocation("nujo","textures/gui/sprite/container/imaginational_block/button.png");
    static final ResourceLocation BUTTON_DISABLED_SPRITE = new ResourceLocation("nujo","textures/gui/sprite/container/imaginational_block/button_disabled.png");
    static final ResourceLocation BUTTON_SELECTED_SPRITE = new ResourceLocation("nujo","textures/gui/sprite/container/imaginational_block/button_selected.png");
    static final ResourceLocation BUTTON_HIGHLIGHTED_SPRITE = new ResourceLocation("nujo","textures/gui/sprite/container/imaginational_block/button_highlighted.png");
    static final ResourceLocation ACTIVE_SPRITE = new ResourceLocation("nujo","textures/gui/sprite/container/imaginational_block/active_icon.png");
    private final List<BlockImaginationScreen.BlockImaginationButton> blockImaginationButtons = Lists.newArrayList();
    public BlockImaginationScreen(BlockImaginationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 175;
        this.imageHeight = 165;
        pMenu.addSlotListener(new ContainerListener() {
            @Override
            public void slotChanged(AbstractContainerMenu pMenu, int pSlot, ItemStack pStack) {
            }

            @Override
            public void dataChanged(AbstractContainerMenu pMenu, int pSlot, int pStack) {
            }
        });
    }

    private <T extends AbstractWidget & BlockImaginationScreen.BlockImaginationButton> void addButton(T pButton) {
        this.addRenderableWidget(pButton);
        this.blockImaginationButtons.add(pButton);
    }


    protected void init() {
        super.init();
        this.blockImaginationButtons.clear();
        this.addButton(new BlockImaginationScreen.BlockImaginationActiveButton(this.leftPos+122,this.topPos+32));
    }


    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, IMAGINATION_GUI_LOCATION);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        pGuiGraphics.blit(IMAGINATION_GUI_LOCATION, x, y, 0, 0, imageWidth, imageHeight);
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @OnlyIn(Dist.CLIENT)
    interface BlockImaginationButton {
        void updateStatus(int pStatus);
    }
    @OnlyIn(Dist.CLIENT)
    class BlockImaginationActiveButton extends BlockImaginationScreen.BlockImaginationSpriteScreenButton{
        public BlockImaginationActiveButton(int pX, int pY) {
            super(pX,pY,BlockImaginationScreen.ACTIVE_SPRITE,CommonComponents.GUI_DONE);
        }

        public void onPress() {BlockImaginationScreen.this.minecraft.player.closeContainer();}

        public void updateStatus(int pStatus) {}
    }

    abstract static class BlockImaginationScreenButton extends AbstractButton implements BlockImaginationScreen.BlockImaginationButton{
        private boolean selected;
        protected BlockImaginationScreenButton(int pX, int pY) {
            super(pX,pY,22,22, CommonComponents.EMPTY);
        }
        protected BlockImaginationScreenButton(int pX,int pY,Component pText) {
            super(pX,pY,22,22,pText);
        }
        public void renderWidget(GuiGraphics guiGraphics,int pMouseX, int pMouseY, float pPartialTick) {
            ResourceLocation resourceLocation;
            if (!this.active) {
                resourceLocation = BUTTON_DISABLED_SPRITE;
            } else if (this.selected) {
                resourceLocation = BUTTON_SELECTED_SPRITE;
            } else if (this.isHoveredOrFocused()) {
                resourceLocation = BUTTON_HIGHLIGHTED_SPRITE;
            }else {
                resourceLocation = BUTTON_SPRITE;
            }

            guiGraphics.blitSprite(resourceLocation,this.getX(),this.getY(),this.width,this.height);
            this.renderIcon(guiGraphics);
        }

        protected abstract void renderIcon(GuiGraphics guiGraphics);

        public boolean isSelected() {return this.selected;}
        public void setSelected(boolean pSelected) {this.selected = pSelected;}

        public void updateWidgetNarration(NarrationElementOutput elementOutput){
            this.defaultButtonNarrationText(elementOutput);
        }

    }
    @OnlyIn(Dist.CLIENT)
    abstract static class BlockImaginationSpriteScreenButton extends BlockImaginationScreen.BlockImaginationScreenButton {
        private final ResourceLocation sprite;

        protected BlockImaginationSpriteScreenButton(int pX, int pY,ResourceLocation pSprite, Component pText) {
            super(pX, pY,pText);
            this.sprite = pSprite;
        }

        protected void renderIcon(GuiGraphics guiGraphics) {
            guiGraphics.blitSprite(this.sprite, this.getX() + 2, this.getY() + 2, 18, 18);
        }
    }



}





