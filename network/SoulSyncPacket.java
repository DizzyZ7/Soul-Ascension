package com.dizzy.soulrpg.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class SoulSyncPacket {

    private final int soul;

    public SoulSyncPacket(int soul) {
        this.soul = soul;
    }

    public static void encode(SoulSyncPacket msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.soul);
    }

    public static SoulSyncPacket decode(FriendlyByteBuf buf) {
        return new SoulSyncPacket(buf.readInt());
    }

    public static void handle(SoulSyncPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientSoulData.set(msg.soul);
        });
        ctx.get().setPacketHandled(true);
    }
}
