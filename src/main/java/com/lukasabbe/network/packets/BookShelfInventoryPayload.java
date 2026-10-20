package com.lukasabbe.network.packets;

import com.lukasabbe.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
//? if >= 1.20.5 {
/*import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;
*///?} else {
import net.minecraft.network.FriendlyByteBuf;
//?}

//? if >= 1.20.5 {
/*public record BookShelfInventoryPayload(ItemStack itemStack, BlockPos pos, int slotNum) implements CustomPacketPayload {
    public static final Type<BookShelfInventoryPayload> ID = new Type<>(Constants.BOOK_SHELF_INVENTORY_PACKET_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, BookShelfInventoryPayload> CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_STREAM_CODEC, BookShelfInventoryPayload::itemStack,
            BlockPos.STREAM_CODEC, BookShelfInventoryPayload::pos,
            ByteBufCodecs.INT, BookShelfInventoryPayload::slotNum,
            BookShelfInventoryPayload::new);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() { return ID; }
}
*///?} else {
public record BookShelfInventoryPayload(ItemStack itemStack, BlockPos pos, int slotNum) {
    public void write(FriendlyByteBuf buf) {
        buf.writeItem(itemStack);
        buf.writeBlockPos(pos);
        buf.writeVarInt(slotNum);
    }

    public static BookShelfInventoryPayload read(FriendlyByteBuf buf) {
        return new BookShelfInventoryPayload(buf.readItem(), buf.readBlockPos(), buf.readVarInt());
    }
}
//?}
