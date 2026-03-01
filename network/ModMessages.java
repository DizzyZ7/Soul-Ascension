package com.dizzy.soulrpg.network;

import com.dizzy.soulrpg.SoulRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkDirection;

public class ModMessages {

    private static SimpleChannel INSTANCE;
    private static int packetId = 0;

    public static void register() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(SoulRPG.MOD_ID, "messages"),
                () -> "1.0",
                s -> true,
                s -> true
        );

        INSTANCE.registerMessage(
                packetId++,
                SoulSyncPacket.class,
                SoulSyncPacket::encode,
                SoulSyncPacket::decode,
                SoulSyncPacket::handle
        );
    }

    public static <MSG> void sendToPlayer(MSG msg, ServerPlayer player) {
        INSTANCE.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }
}
