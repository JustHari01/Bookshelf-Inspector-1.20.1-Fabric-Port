package com.lukasabbe.mixin;

//? if >= 1.21.10 {
//?} else if >= 1.21 {
/*import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.OptionalInt;

@Mixin(ChiseledBookShelfBlock.class)
public interface BookshelfInvoker {
    @Invoker("getHitSlot")
    OptionalInt invokerGetSlotForHitPos(BlockHitResult hit, BlockState state);
}
*///?}
