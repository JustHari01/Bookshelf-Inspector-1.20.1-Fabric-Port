package com.lukasabbe.data;

import net.minecraft.core.registries.Registries;
import com.lukasabbe.Constants;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static final TagKey<Block> CHISELED_BOOKSHELVES = TagKey.create(Registries.BLOCK, Constants.id("c", "chiseled_bookshelves"));
    public static final TagKey<Block> LECTERNS = TagKey.create(Registries.BLOCK, Constants.id("c", "lectern"));
    public static final TagKey<Block> SHELVES = TagKey.create(Registries.BLOCK, Constants.id("c", "shelves"));
}
