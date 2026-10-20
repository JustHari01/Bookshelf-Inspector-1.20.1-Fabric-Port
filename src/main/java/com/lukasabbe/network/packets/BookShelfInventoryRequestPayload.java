package com.lukasabbe.network.packets;

import com.lukasabbe.Constants;
import net.minecraft.core.BlockPos;
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
/*public record BookShelfInventoryRequestPayload(BlockPos pos, int slotNum) implements CustomPacketPayload {
    public static final Type<BookShelfInventoryRequestPayload> ID = new Type<>(Constants.BOOK_SHELF_INVENTORY_REQUEST_PACKET_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, BookShelfInventoryRequestPayload> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, BookShelfInventoryRequestPayload::pos,
            ByteBufCodecs.INT, BookShelfInventoryRequestPayload::slotNum,
            BookShelfInventoryRequestPayload::new);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() { return ID; }
}
*///?} else {
public record BookShelfInventoryRequestPayload(BlockPos pos, int slotNum) {
    public void write(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeVarInt(slotNum);
    }

    public static BookShelfInventoryRequestPayload read(FriendlyByteBuf buf) {
        return new BookShelfInventoryRequestPayload(buf.readBlockPos(), buf.readVarInt());
    }
}
//?}
