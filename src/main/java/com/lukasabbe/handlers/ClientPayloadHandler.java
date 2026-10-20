package com.lukasabbe.handlers;

import net.minecraft.client.player.LocalPlayer;
public interface ClientPayloadHandler<T> {
    void receive(T payload, LocalPlayer player);

}
