package com.lukasabbe;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    public static final String MOD_ID = "bookshelfinspector";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final String VERSION = /*$ mod_version*/ "2.4-port.1";
    public static final String MINECRAFT = /*$ minecraft*/ "1.20.1";
    public static final ResourceLocation BOOK_SHELF_INVENTORY_REQUEST_PACKET_ID = id(MOD_ID,"book_shelf_inventory_request");
    public static final ResourceLocation BOOK_SHELF_INVENTORY_PACKET_ID = id(MOD_ID,"book_shelf_inventory");
    public static final ResourceLocation MOD_CHECK_PACKET_ID = id(MOD_ID,"mod_check");
    public static final ResourceLocation LECTERN_INVENTORY_REQUEST_PACKET_ID = id(MOD_ID, "lectern_inventory_request");
    public static final ResourceLocation SHELF_INVENTORY_REQUEST_PACKET_ID = id(MOD_ID,"shelf_inventory_request");

    /**
     * Adapts to the {@link ResourceLocation} changes introduced in 1.21.
     */
    public static ResourceLocation id(String namespace, String path) {
        //? if <1.21 {
        return new ResourceLocation(namespace, path);
         //?} else
        //return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }
}
