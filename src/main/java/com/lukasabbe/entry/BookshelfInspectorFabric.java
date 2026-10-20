package com.lukasabbe.entry;

//? if fabric {
import com.lukasabbe.BookshelfInspector;
import com.lukasabbe.BookshelfInspectorClient;
import com.lukasabbe.Constants;
import com.lukasabbe.network.packets.*;
import com.lukasabbe.renderer.HudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
//? if >= 1.20.5 {
/*import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
*///?}

//? if >= 1.21.11 {
/*import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.resources.ResourceLocation;
*///?} else {
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
//?}

public class BookshelfInspectorFabric implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        //? if >= 1.20.5 {
        /*//? if >= 26.1 {
        /^PayloadTypeRegistry.serverboundPlay().register(BookShelfInventoryRequestPayload.ID, BookShelfInventoryRequestPayload.CODEC);
        PayloadTypeRegistry.serverboundPlay().register(LecternInventoryRequestPayload.ID, LecternInventoryRequestPayload.CODEC);
        PayloadTypeRegistry.serverboundPlay().register(ShelfInventoryRequestPayload.ID, ShelfInventoryRequestPayload.CODEC);
        PayloadTypeRegistry.clientboundPlay().register(BookShelfInventoryPayload.ID, BookShelfInventoryPayload.CODEC);
        PayloadTypeRegistry.clientboundPlay().register(ModCheckPayload.ID, ModCheckPayload.CODEC);
        ^///?} elif < 26.1 {
        PayloadTypeRegistry.playC2S().register(BookShelfInventoryRequestPayload.ID, BookShelfInventoryRequestPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(LecternInventoryRequestPayload.ID, LecternInventoryRequestPayload.CODEC);
        //? if >= 1.21.9 {
        /^PayloadTypeRegistry.playC2S().register(ShelfInventoryRequestPayload.ID, ShelfInventoryRequestPayload.CODEC);
        ^///?}
        PayloadTypeRegistry.playS2C().register(BookShelfInventoryPayload.ID, BookShelfInventoryPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModCheckPayload.ID, ModCheckPayload.CODEC);
        //?}

        ServerPlayNetworking.registerGlobalReceiver(
                BookShelfInventoryRequestPayload.ID,
                (payload, context) -> BookshelfInspector.networkHandlers.bookShelfInventoryRequestServerPayloadHandler.receive(payload, context.player()));
        ServerPlayNetworking.registerGlobalReceiver(
                LecternInventoryRequestPayload.ID,
                (payload, context) -> BookshelfInspector.networkHandlers.lecternInventoryRequestServerPayloadHandler.receive(payload, context.player()));
        //? if >= 1.21.9 {
        /^ServerPlayNetworking.registerGlobalReceiver(
                ShelfInventoryRequestPayload.ID,
                (payload, context) -> BookshelfInspector.networkHandlers.shelfInventoryRequestServerPayloadHandler.receive(payload, context.player()));
        ^///?}
        *///?} else {
        ServerPlayNetworking.registerGlobalReceiver(
                Constants.BOOK_SHELF_INVENTORY_REQUEST_PACKET_ID,
                (server, player, handler, buf, responseSender) -> BookshelfInspector.networkHandlers.bookShelfInventoryRequestServerPayloadHandler.receive(BookShelfInventoryRequestPayload.read(buf), player));
        ServerPlayNetworking.registerGlobalReceiver(
                Constants.LECTERN_INVENTORY_REQUEST_PACKET_ID,
                (server, player, handler, buf, responseSender) -> BookshelfInspector.networkHandlers.lecternInventoryRequestServerPayloadHandler.receive(LecternInventoryRequestPayload.read(buf), player));
        //?}

        BookshelfInspector.init();
    }

    @Override
    public void onInitializeClient() {
        //? if >= 1.20.5 {
        /*ClientPlayNetworking.registerGlobalReceiver(
                BookShelfInventoryPayload.ID,
                (payload, context) -> BookshelfInspector.networkHandlers.bookShelfInventoryHandlerServer.receive(payload, context.player()));
        ClientPlayNetworking.registerGlobalReceiver(
                ModCheckPayload.ID,
                (payload, context) -> BookshelfInspector.networkHandlers.modServerPayloadHandler.receive(payload, context.player()));
        *///?} else {
        ClientPlayNetworking.registerGlobalReceiver(
                Constants.BOOK_SHELF_INVENTORY_PACKET_ID,
                (client, handler, buf, responseSender) -> BookshelfInspector.networkHandlers.bookShelfInventoryHandlerServer.receive(BookShelfInventoryPayload.read(buf), client.player));
        ClientPlayNetworking.registerGlobalReceiver(
                Constants.MOD_CHECK_PACKET_ID,
                (client, handler, buf, responseSender) -> BookshelfInspector.networkHandlers.modServerPayloadHandler.receive(ModCheckPayload.read(buf), client.player));
        //?}

        //? if >= 1.21.11 {
        /*HudElementRegistry.attachElementAfter(
                VanillaHudElements.CROSSHAIR,
                ResourceLocation.fromNamespaceAndPath("bookshelfinspector", "inspect"),
                (ctx, dt) -> HudRenderer.hudRender(ctx, Minecraft.getInstance()));
        *///?} else {
        HudRenderCallback.EVENT.register((ctx, dt) -> HudRenderer.hudRender(ctx, Minecraft.getInstance()));
        //?}

        BookshelfInspectorClient.clientInit();
    }
}
//?}
