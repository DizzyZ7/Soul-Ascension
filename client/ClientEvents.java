package com.dizzy.soulrpg.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.dizzy.soulrpg.SoulRPG;

@Mod.EventBusSubscriber(modid = SoulRPG.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRender(RenderGuiOverlayEvent.Post event) {
        String text = "Soul: " + ClientSoulData.get();
        event.getGuiGraphics().drawString(
                event.getGuiGraphics().guiWidth() - 100,
                10,
                0xFFFFFF
        );
    }
}
