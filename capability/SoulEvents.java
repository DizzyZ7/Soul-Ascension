package com.dizzy.soulrpg.capability;

import com.dizzy.soulrpg.network.ModMessages;
import com.dizzy.soulrpg.network.SoulSyncPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.resources.ResourceLocation;
import com.dizzy.soulrpg.SoulRPG;

@Mod.EventBusSubscriber(modid = SoulRPG.MOD_ID)
public class SoulEvents {

    @SubscribeEvent
    public static void attach(AttachCapabilitiesEvent<?> event) {
        if (event.getObject() instanceof ServerPlayer player) {
            event.addCapability(
                new ResourceLocation(SoulRPG.MOD_ID, "soul"),
                new SoulProvider()
            );
        }
    }

    @SubscribeEvent
    public static void onKill(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof ServerPlayer player) {
            player.getCapability(SoulProvider.SOUL).ifPresent(data -> {
                data.addSoul(10);
                ModMessages.sendToPlayer(
                    new SoulSyncPacket(data.getSoul()),
                    player
                );
            });
        }
    }

    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(SoulProvider.SOUL).ifPresent(oldStore -> {
            event.getEntity().getCapability(SoulProvider.SOUL).ifPresent(newStore -> {
                newStore.setSoul(oldStore.getSoul());
            });
        });
    }
}
