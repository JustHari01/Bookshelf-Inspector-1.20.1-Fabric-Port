package com.lukasabbe.handlers;

import net.minecraft.server.level.ServerPlayer;

public interface ServerPayloadHandler<T> {
    void receive(T payload, ServerPlayer player);
}
