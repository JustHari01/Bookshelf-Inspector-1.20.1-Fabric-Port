# Bookshelf Inspector — Unofficial Fabric 1.20.1 Port

This is an unofficial Fabric backport of [Bookshelf Inspector](https://modrinth.com/mod/bookshelf-inspector) for Minecraft 1.20.1. Aim at a book in a chiseled bookshelf to view its item name and details in the HUD. Lecterns are supported too. In multiplayer, install the mod on the server for book and lectern inspection; clients without it can still connect.

Install Fabric Loader for Minecraft 1.20.1, Fabric API, and this mod. Mod Menu and Cloth Config are optional and expose the settings screen.

## Source and attribution

This repository contains the 1.20.1 port source. The original mod is by Lukasabbe: [upstream source](https://github.com/lukasabbe/bookshelf-inspector). The original project credits Wikiraze for the request, Img00 for shelf support, and the GM4 Bookshelf Inspector data pack as inspiration. This port preserves those credits and is distributed under the MIT License; the included `LICENSE` retains the upstream notice and credits the port changes to JustHari01. This repository is separate from the upstream project.

## Build

Use JDK 17 and run `./gradlew :1.20.1-fabric:build` from the repository root. On Windows, run `gradlew.bat :1.20.1-fabric:build`.

The release is a 1.20.1 Fabric adaptation. A dedicated-server and client world-load/save smoke test completed. Direct in-game HUD inspection of books and lecterns has not yet been manually verified.

AI assistance was used to adapt and test this unofficial 1.20.1 port.
