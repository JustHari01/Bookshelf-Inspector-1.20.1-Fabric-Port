package com.lukasabbe.network.packets;

import com.lukasabbe.Constants;
import net.minecraft.core.BlockPos;
//? if >= 1.20.5 {
/*import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;
*///?} else {
import net.minecraft.network.FriendlyByteBuf;
//?}

//? if >= 1.20.5 {
/*public record LecternInventoryRequestPayload(BlockPos pos) implements CustomPacketPayload {
    public static final Type<LecternInventoryRequestPayload> ID = new Type<>(Constants.LECTERN_INVENTORY_REQUEST_PACKET_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, LecternInventoryRequestPayload> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, LecternInventoryRequestPayload::pos,
            LecternInventoryRequestPayload::new);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() { return ID; }
}
*///?} else {
public record LecternInventoryRequestPayload(BlockPos pos) {
    public void write(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static LecternInventoryRequestPayload read(FriendlyByteBuf buf) {
        return new LecternInventoryRequestPayload(buf.readBlockPos());
    }
}
//?}
