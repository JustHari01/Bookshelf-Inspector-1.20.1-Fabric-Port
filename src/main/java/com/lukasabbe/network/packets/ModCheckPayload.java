package com.lukasabbe.network.packets;

import com.lukasabbe.Constants;
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
/*public record ModCheckPayload(boolean modActivated) implements CustomPacketPayload {
    public static final Type<ModCheckPayload> ID = new Type<>(Constants.MOD_CHECK_PACKET_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ModCheckPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, ModCheckPayload::modActivated,
            ModCheckPayload::new);

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() { return ID; }
}
*///?} else {
public record ModCheckPayload(boolean modActivated) {
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(modActivated);
    }

    public static ModCheckPayload read(FriendlyByteBuf buf) {
        return new ModCheckPayload(buf.readBoolean());
    }
}
//?}
