package com.HEN.Nujomod.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation("nujo",name));
        }

        private static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge",name));
        }
    }
    public static class Blocks{
        public static final TagKey<Block> IMAGINATIONAL_BLOCKS = tag("imaginational_blocks");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation("nujo",name));
        }

        private static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge",name));
        }
    }
}
